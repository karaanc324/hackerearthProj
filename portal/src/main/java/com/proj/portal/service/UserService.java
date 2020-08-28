package com.proj.portal.service;

import com.proj.portal.dao.UserDao;
import com.proj.portal.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class UserService {

    @Autowired
    UserDao userDao;

    public int saveUser(User u) throws SQLException {
        return userDao.saveUser(u);
    }

    public String validateLogin(String email, String pass) throws SQLException {
        User user = userDao.getUserDetails(email);
        if (user.getEmail() == null) {
            return "No user found with this email Id";
        } else if (!user.getPassword().equals(pass)) {
            return "Password wrong";
        } else {
            return "Logged in";
        }
    }
}

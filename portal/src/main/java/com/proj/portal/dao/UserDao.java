package com.proj.portal.dao;

import com.proj.portal.connection.ConnectionClass;
import com.proj.portal.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserDao {
    ConnectionClass connectionClass = new ConnectionClass();
    public int saveUser(User u) throws SQLException {
        User user = getUserDetails(u.getEmail());
        if(user.getEmail() == null) {
            Connection connection = connectionClass.getConnection();
            PreparedStatement ps = connection.prepareStatement("insert into user (name, email, phone, password) values(?,?,?,?)");
            ps.setString(1, u.getName());
            ps.setString(2, u.getEmail());
            ps.setInt(3, u.getPhone());
            ps.setString(4, u.getPassword());

            ps.executeUpdate();
            return 0;
        } else {
            return 1;
        }
    }

    public User getUserDetails(String email) throws SQLException {
        Connection connection = connectionClass.getConnection();
        User user = new User();
        PreparedStatement ps = connection.prepareStatement("select * from user where email = ?");
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            user.setName(rs.getString(2));
            user.setEmail(rs.getString(3));
            user.setPhone(rs.getInt(4));
            user.setPassword(rs.getString(6));
        }
        return user;

    }
}

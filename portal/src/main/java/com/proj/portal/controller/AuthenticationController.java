package com.proj.portal.controller;

import com.proj.portal.model.User;
import com.proj.portal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
public class AuthenticationController {
    @Autowired
    UserService userService;
    @RequestMapping("/register")
    @ResponseBody
    public String register(@RequestBody User user) throws SQLException {
        int result = userService.saveUser(user);
        if (result == 0) {
            return "User registered";
        } else {
            return "User already exists";
        }
    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestParam String email, @RequestParam String password) throws SQLException {
        System.out.println(email);
        return userService.validateLogin(email, password);
    }
}

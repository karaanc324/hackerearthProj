package com.proj.portal.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {

    @RequestMapping("/")
    public String getDashboard() {
        return "Dashboard";
    }
}

package com.proj.portal.model;

import javax.persistence.Column;
import javax.persistence.Entity;

public class User {
    String name;
    String email;
    int phone;
    String password;

    public User() {}

    public User(String name, String email, int phone, String about, String password) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public int getPhone() {
        return phone;
    }

//    public String getAbout() {
//        return about;
//    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
//
//    public void setAbout(String about) {
//        this.about = about;
//    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package com.etracker.controller;

import com.etracker.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

public class UserController {

    @Autowired
    UserServiceImpl userService;

//    @GetMapping("/")
//    public String registrationForm() {
//        return "user";
//    }
}

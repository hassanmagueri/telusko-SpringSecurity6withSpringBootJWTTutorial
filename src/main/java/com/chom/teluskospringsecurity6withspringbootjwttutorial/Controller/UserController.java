package com.chom.teluskospringsecurity6withspringbootjwttutorial.Controller;

import com.chom.teluskospringsecurity6withspringbootjwttutorial.Models.User;
import com.chom.teluskospringsecurity6withspringbootjwttutorial.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    UserService service;

    @Autowired
    public UserController(UserService userService){
        this.service = userService;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user){
        return service.save(user);
    }
}

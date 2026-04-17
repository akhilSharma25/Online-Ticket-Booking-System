package com.learning.rest;

import com.learning.model.User;
import com.learning.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private IUserService service;

    @PostMapping("sign-in")
    public Integer addUser(@RequestBody User user){
            return  service.addUser(user);
    }

//    public Integer bookTicket(@RequestBody User user){
//
//
//    }
//
//    @PostMapping("login")
//    public String addUser(@RequestBody User user){
//
//    }
}

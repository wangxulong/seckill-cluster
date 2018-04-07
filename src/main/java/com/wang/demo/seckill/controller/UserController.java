package com.wang.demo.seckill.controller;

import com.wang.demo.seckill.entity.User;
import com.wang.demo.seckill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/{id}")
    @ResponseBody
    public User getById(@PathVariable Integer id) {
        System.out.println(id);
        return userService.findById(id);
    }
}

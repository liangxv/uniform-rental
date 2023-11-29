package com.woniuxy.uniformrental.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.kotlin.KtQueryWrapper;
import com.woniuxy.uniformrental.entity.User;
import com.woniuxy.uniformrental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

//    @PostMapping("login")
//    public String login(String username, String password) {
//        User username1 = userService.getOne(new QueryWrapper<User>().eq("username", username));
//        return userService.login(username, password);
//    }

}

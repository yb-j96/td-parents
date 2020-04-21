package com.syh.user.controller;

import com.syh.common.model.LoginAppUser;
import com.syh.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author jyb
 * @Date 2020/4/15 11:00
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/user/selectUserByUserName")
    public LoginAppUser selectUserByUserName(String username) {
       /* LoginAppUser loginAppUser = userService.selectUserByUserName(username);
        System.out.println(loginAppUser);
        return loginAppUser;*/
       return null;
    }

}

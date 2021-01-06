package com.liuwenxu.mybatisplus.controller;


import com.liuwenxu.mybatisplus.annotation.Phone;
import com.liuwenxu.mybatisplus.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Copyright (C), 2016-2019, Mobius-Vision
 * FileName: SysUserController
 * Author: liuwenxu
 * Date: 2019-12-20 16:21:56
 * Description:  前端控制器
 */
@RestController
@RequestMapping("/user")
public class SysUserController {

    @PostMapping
    public String createUser(@Valid @RequestBody User user, BindingResult results) {
        String password = user.getPassword();
        String phone = user.getPhone();
        String username = user.getUsername();
        if (results.hasErrors())
            return results.getFieldError().getDefaultMessage();
        return "success";
    }

    /**
     * 无效的验证
     * @param user
     * @param results
     * @return
     */
    private String test(@Valid User user, BindingResult results) {
        String password = user.getPassword();
        String phone = user.getPhone();
        String username = user.getUsername();
        System.out.println(password+phone+username);
        if (results.hasErrors())
            return results.getFieldError().getDefaultMessage();
        return "success";
    }

    @PostMapping("/1")
    public String createUser1(User user, BindingResult results) {
        return test(user,results);
    }


    @GetMapping("/{username}")
    public String getUser(@Valid @PathVariable("username") String username) {
        //逻辑处理

        return "success";
    }
}

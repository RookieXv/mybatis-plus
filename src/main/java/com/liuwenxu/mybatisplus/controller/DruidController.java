package com.liuwenxu.mybatisplus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


/**
 * Copyright (C), 2016-2019, Mobius-Vision
 * FileName: DruidController
 * Author: liuwenxu
 * Date: 2019/12/20 11:33
 * Description: 测试druid
 */
@RestController("/dataSource")
public class DruidController {

    @Autowired
    private DataSource dataSource;

    @GetMapping
    public String dataSource() {
        try {
            System.out.println("dataSource = " + dataSource);
            Connection connection = dataSource.getConnection();
            System.out.println("connection = " + connection);
            return "success";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "end.";
    }
}

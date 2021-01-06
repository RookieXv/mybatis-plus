package com.liuwenxu.mybatisplus.controller;

import com.liuwenxu.mybatisplus.config.CommonResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;

/**
 * Copyright (C), 2015-2020, https://www.liuwenxu.com/
 * FileName: CreatTestData
 * Author: liuwenxu
 * Date: 2020/8/21 3:54 下午
 * Description:
 */
@RestController
public class CreatTestData {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     *
     * @param count
     * @return
     */
    @PostMapping("/db")
    @ApiOperation(value = "测试批量添加百万数据", notes = "", httpMethod = "POST")
    public CommonResult createData(Integer count) {

        String sql = "insert into product(product_name, product_price, product_count) values(?,?,?)";

        long start = System.currentTimeMillis();
        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, "商品" + i);
                ps.setBigDecimal(2, BigDecimal.valueOf(888));
                ps.setInt(3, 999);
            }

            @Override
            public int getBatchSize() {
                return count;
            }
        });
        return CommonResult.buildSuccess("插入数据：" + count + "条",
                "共耗时：" + (System.currentTimeMillis() - start) + "毫秒");
    }

    /**
     * {
     *     "code": 0,
     *     "errorMsg": "线程：10，插入数据：100000条",
     *     "stackException": null,
     *     "result": "共耗时：51960毫秒"
     * }
     * @param count
     * @param t
     * @return
     */
    @PostMapping("/db2")
    @ApiOperation(value = "测试批量添加百万数据多线程", notes = "", httpMethod = "POST")
    public CommonResult createData2(Integer count, Integer t) {

        String sql = "insert into product(product_name, product_price, product_count) values(?,?,?)";

        CountDownLatch countDownLatch = new CountDownLatch(t);

        long start = System.currentTimeMillis();
        new Thread(
                () -> {
                    for (int i = 0; i < t; i++) {
                        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
                            @Override
                            public void setValues(PreparedStatement ps, int i) throws SQLException {
                                ps.setString(1, "商品" + i);
                                ps.setBigDecimal(2, BigDecimal.valueOf(888));
                                ps.setInt(3, 999);
                            }

                            @Override
                            public int getBatchSize() {
                                return count;
                            }
                        });
                        countDownLatch.countDown();
                    }
                }
        ).start();

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();

        return CommonResult.buildSuccess("线程：" + t + "，插入数据：" + count * t + "条",
                "共耗时：" + (end - start) + "毫秒");
    }
}

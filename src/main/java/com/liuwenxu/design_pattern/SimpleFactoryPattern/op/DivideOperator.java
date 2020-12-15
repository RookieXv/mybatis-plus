package com.liuwenxu.design_pattern.SimpleFactoryPattern.op;

import java.math.BigDecimal;

/**
 * Copyright (C), 2016-2020, https://liuwenxu.com/
 * FileName: AddOperator
 * Author: liuwenxu
 * Date: 2020/12/15 10:56
 * Description: 除法运算符
 */
public class DivideOperator implements Operator {
    @Override
    public double calculate(double numA, double numB) {
        if (numB == 0) {
            try {
                throw new IllegalAccessException("divide by zero");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return BigDecimal.valueOf(numA).divide(BigDecimal.valueOf(numB)).doubleValue();
    }
}

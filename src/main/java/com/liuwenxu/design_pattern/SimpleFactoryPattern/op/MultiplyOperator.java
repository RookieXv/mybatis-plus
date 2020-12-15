package com.liuwenxu.design_pattern.SimpleFactoryPattern.op;

import java.math.BigDecimal;

/**
 * Copyright (C), 2016-2020, https://liuwenxu.com/
 * FileName: AddOperator
 * Author: liuwenxu
 * Date: 2020/12/15 10:56
 * Description: 乘法运算符
 */
public class MultiplyOperator implements Operator {
    @Override
    public double calculate(double numA, double numB) {
        return BigDecimal.valueOf(numA).multiply(BigDecimal.valueOf(numB)).doubleValue();
    }
}

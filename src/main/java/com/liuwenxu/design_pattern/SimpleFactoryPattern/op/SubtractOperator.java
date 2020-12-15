package com.liuwenxu.design_pattern.SimpleFactoryPattern.op;

import java.math.BigDecimal;

/**
 * Copyright (C), 2016-2020, https://liuwenxu.com/
 * FileName: AddOperator
 * Author: liuwenxu
 * Date: 2020/12/15 10:56
 * Description: 减法运算符
 */
public class SubtractOperator implements Operator {
    @Override
    public double calculate(double numA, double numB) {
        return BigDecimal.valueOf(numA).subtract(BigDecimal.valueOf(numB)).doubleValue();
    }
}

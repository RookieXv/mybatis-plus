package com.liuwenxu.design_pattern.SimpleFactoryPattern.factory;

import com.liuwenxu.design_pattern.SimpleFactoryPattern.op.*;

import java.util.Objects;

/**
 * Copyright (C), 2016-2020, https://liuwenxu.com/
 * FileName: OPFactory
 * Author: liuwenxu
 * Date: 2020/12/15 11:09
 * Description:
 */
public class OPFactory {
    public static Operator creatOp(String op) {
        Operator operator = null;
        if (Objects.nonNull(op)) {
            switch (op) {
                case "+":
                    operator = new AddOperator();
                    break;
                case "-":
                    operator = new SubtractOperator();
                    break;
                case "*":
                    operator = new MultiplyOperator();
                    break;
                case "/":
                    operator = new DivideOperator();
                    break;
            }
        }
        return operator;
    }
}

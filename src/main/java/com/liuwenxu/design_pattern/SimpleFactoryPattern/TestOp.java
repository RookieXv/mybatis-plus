package com.liuwenxu.design_pattern.SimpleFactoryPattern;

import com.liuwenxu.design_pattern.SimpleFactoryPattern.factory.OPFactory;
import com.liuwenxu.design_pattern.SimpleFactoryPattern.op.Operator;

import java.util.Scanner;

/**
 * Copyright (C), 2016-2020, https://liuwenxu.com/
 * FileName: TestOp
 * Author: liuwenxu
 * Date: 2020/12/15 11:18
 * Description:
 */
public class TestOp {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入第一个数：");
        String numA = scanner.nextLine();
        System.out.println("请输入运算符(+-*/)：");
        String op = scanner.nextLine();
        System.out.println("请输入第二个数：");
        String numB = scanner.nextLine();
        Operator operator = OPFactory.creatOp(op);
        double result = operator.calculate(Double.valueOf(numA), Double.valueOf(numB));
        System.out.println(result);
    }
}

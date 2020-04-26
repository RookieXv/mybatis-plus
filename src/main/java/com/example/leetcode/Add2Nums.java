package com.example.leetcode;

/**
 * Copyright (C), 2016-2020, Mobius-Vision
 * FileName: Add2Nums
 * Author: liuwenxu
 * Date: 2020/3/24 17:26
 * Description: 两数相加
 */
public class Add2Nums {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // 定义哑结点，我们使用哑结点来简化代码。如果没有哑结点，则必须编写额外的条件语句来初始化表头的值。
        ListNode dummynode = new ListNode(0);

        // 定义指针，指向dummynode
        ListNode head = dummynode;

        // 定义进位，默认为0
        int carry = 0;

        while (l1 != null || l2 != null) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;

            int sum = a + b + carry;
            carry = sum / 10;

            head.next = new ListNode(sum % 10);
            head = head.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry == 1) head.next = new ListNode(carry); // 放到while loop外面（针对最后一位）

        return dummynode.next;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public static String print(ListNode l) {
            StringBuilder stringBuilder = new StringBuilder();
            while (l != null) {
                stringBuilder.append(l.val);
                l = l.next;
            }
            return stringBuilder.toString();
        }
    }

    /**
     * 2-----4
     * 5-----6
     * <p>
     * 7-----0------1
     *
     * @param args
     */

    public static void main(String[] args) {
//        ListNode l1 = new ListNode(2);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);
//
//        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);
//
//        System.out.println(ListNode.print(addTwoNumbers(l1, l2)));

        System.out.println(addTwoBigNums("123456789", "987654321"));
        System.out.println(123456789 + 987654321);

    }


    /**
     * 两个大数相加。
     * 1、是整数；
     * 2、两个数无限大，long都装不下；
     * 3、不能用BigInteger；
     * 4、不能用任何包装类提供的运算方法；
     * 5、两个数都是以字符串的方式提供。
     */
    public static String addTwoBigNums(String num1, String num2) {

        // 反转num1，num2
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        StringBuilder res = new StringBuilder();

        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;

        while (i >= 0 || j >= 0) {
            int a = i >= 0 ? num1.charAt(i) - '0' : 0;
            int b = j >= 0 ? num2.charAt(j) - '0' : 0;

            int sum = a + b + carry;
            carry = sum / 10;
            res.append(sum % 10);

            i--;
            j--;
        }
        if (carry == 1) res.append(1);

        return res.reverse().toString();
    }

}
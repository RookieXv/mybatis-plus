package com.liuwenxu.algorithm.arrays;

import java.util.Arrays;

/**
 * Copyright (C), 2015-2021, https://www.liuwenxu.com/
 * FileName: FindNumbers
 * Author: liuwenxu
 * Date: 2021/1/7 3:13 下午
 * Description:
 * Example 1:
 * <p>
 * Input: nums = [12,345,2,6,7896]
 * Output: 2
 * Explanation:
 * 12 contains 2 digits (even number of digits).
 * 345 contains 3 digits (odd number of digits).
 * 2 contains 1 digit (odd number of digits).
 * 6 contains 1 digit (odd number of digits).
 * 7896 contains 4 digits (even number of digits).
 * Therefore only 12 and 7896 contain an even number of digits.
 * Example 2:
 * <p>
 * Input: nums = [555,901,482,1771]
 * Output: 1
 * Explanation:
 * Only 1771 contains an even number of digits.
 */
public class FindNumbers {
    public static int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            int length = String.valueOf(num).length();
            if (length % 2 == 0) {
                count += 1;
            }
        }
        return count;
    }

    public static int findNumbersPlus(int[] nums) {
        return (int) Arrays.stream(nums).filter(num -> (int) (Math.log10(num) + 1) % 2 == 0).count();
    }


    public static void main(String[] args) {
        int[] nums = {12, 345, 2, 6, 7896};
//        System.out.println(findNumbers(nums));
        System.out.println(findNumbersPlus(nums));
    }
}

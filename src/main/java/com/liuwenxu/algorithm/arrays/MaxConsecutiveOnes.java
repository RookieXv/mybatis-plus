package com.liuwenxu.algorithm.arrays;

import org.junit.jupiter.api.Test;

/**
 * Copyright (C), 2015-2021, https://www.liuwenxu.com/
 * FileName: MaxConsecutiveOnes
 * Author: liuwenxu
 * Date: 2021/1/6 4:19 下午
 * Description: 求最大连续数的长度 110111
 */
public class MaxConsecutiveOnes {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxLength = 0, tempMaxLength = 0;
        for (int num : nums) {
            if (num == 1) {
                tempMaxLength++;
            } else {
                maxLength = Math.max(tempMaxLength, maxLength);
                tempMaxLength = 0;
            }
        }
        return Math.max(tempMaxLength, maxLength);
    }

    public static int findMaxConsecutiveOnesPlus(int[] nums) {
        int l = 0, r = 0, res = 0;
        while (r < nums.length) {
            if (nums[r++] == 0) {
                res = Math.max(res, r - l - 1);
                l = r;
            }
        }
        return Math.max(res, r - l);
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 0, 1, 1};
        System.out.println(findMaxConsecutiveOnesPlus(nums));
    }


    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4};
        int n = 0;
        int res = nums[n++];
        System.out.println(res);
        System.out.println(n);
    }
}

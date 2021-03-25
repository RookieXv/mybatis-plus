package com.liuwenxu.algorithm.arrays;

import java.util.Arrays;

/**
 * Copyright (C), 2015-2021, https://www.liuwenxu.com/
 * FileName: SortedSquares
 * Author: liuwenxu
 * Date: 2021/1/7 3:36 下午
 * Description:
 * Example 1:
 * <p>
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 * Example 2:
 * <p>
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums is sorted in non-decreasing order.
 * <p>
 * <p>
 * Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?
 */
public class SortedSquares {
    public static int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = nums[i] * nums[i];
        }
        Arrays.sort(res);
        return res;
    }

    /**
     * 双指针
     *
     * @param nums
     * @return
     */
    public static int[] sortedSquaresPlus(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];

        for (int i = 0, j = len - 1, pos = len - 1; i <= j; ) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                res[pos] = nums[i] * nums[i];
                i++;
            } else {
                res[pos] = nums[j] * nums[j];
                j--;
            }
            pos--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        long s = System.currentTimeMillis();
        int[] res = sortedSquaresPlus(nums);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long e = System.currentTimeMillis();
        Arrays.stream(res).forEach(System.out::println);
        System.out.println(e - s);
    }
}

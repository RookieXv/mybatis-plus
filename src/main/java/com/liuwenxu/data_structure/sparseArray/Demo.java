package com.liuwenxu.data_structure.sparseArray;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Copyright (C), 2016-2020, https://liuwenxu.com/
 * FileName: Class_1
 * Author: liuwenxu
 * Date: 2020/12/28 16:19
 * Description: 稀疏数组
 * 原始数组：
 * ```
 * 0 0 1 0 0 0
 * 0 0 0 2 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * ```
 * 转化后：
 * ```
 * row col value
 * 4   6   2
 * 0   2   1
 * 1   3   2
 * ```
 */
public class Demo {
    public static void main(String[] args) {
        // 创建一个二维数组 6*4, 0：没有棋子，1代表白子，2代表黑子
        int[][] arr = new int[4][6];
        arr[0][2] = 1;
        arr[1][3] = 2;
        printArr("原始数组：", arr);
        int[][] sparseArr = arr2sparse(arr);
        printArr("稀疏数组：", sparseArr);
        printArr("还原数组：", sparse2arr(sparseArr));


    }

    /**
     * 二维数组转稀疏数组
     *
     * @param arr
     * @return
     */
    private static int[][] arr2sparse(int[][] arr) {
        int count = 0;
        for (int[] ints : arr) {
            for (int anInt : ints) {
                if (anInt != 0) {
                    count++;
                }
            }
        }
        int[][] sparseArr = new int[count + 1][3];

        // 插入第一行的值
        sparseArr[0][0] = 4;
        sparseArr[0][1] = 6;
        sparseArr[0][2] = count;

        // 插入非第一行的值
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    sparseArr[i + 1][0] = i;
                    sparseArr[i + 1][1] = j;
                    sparseArr[i + 1][2] = arr[i][j];
                }
            }
        }
        return sparseArr;
    }

    /**
     * 稀疏数组转二维数组
     *
     * @param sparseArr
     * @return
     */
    private static int[][] sparse2arr(int[][] sparseArr) {
        int[][] arr = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            arr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        return arr;
    }


    /**
     * 打印数组
     *
     * @param desc
     * @param arr
     */
    private static void printArr(String desc, int[][] arr) {
        System.out.println(desc);
        Arrays.stream(arr).forEach(
                i -> {
                    Arrays.stream(i).forEach(j -> System.out.printf("%d\t", j));
                    System.out.println();
                }
        );
    }

}

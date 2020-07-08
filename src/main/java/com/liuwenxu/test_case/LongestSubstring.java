package com.liuwenxu.test_case;

import java.util.HashMap;

/**
 * Copyright (C), 2016-2020, Mobius-Vision
 * FileName: LongestSubstring
 * Author: liuwenxu
 * Date: 2020/3/25 19:17
 * Description: 最长子串
 * int length = s.length();
 * int left = 0, i = 0, maxlen = 0;
 * <p>
 * StringBuilder temp = new StringBuilder();
 * while (i < length) {
 * StringBuilder sb = new StringBuilder();
 * <p>
 * for (i = left; i < length; i++) {
 * if (!sb.toString().contains(s.charAt(i) + "")) {
 * sb.append(s.charAt(i));
 * } else {
 * left += 1;
 * break;
 * }
 * }
 * temp = sb.length() > temp.length() ? sb : temp;
 * maxlen = temp.length();
 * }
 */
public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxlen = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            maxlen = Math.max(maxlen, i - left + 1);
        }
        return maxlen;
    }


    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring("dvdf"));

//        String s = "asdf";
//        System.out.println(s.indexOf(s.charAt(2)));
        int[] index = new int[128];
        System.out.println(index.length);
    }
}

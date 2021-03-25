package com.liuwenxu.test_case;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <ListTest> 测试new一个list的各种方法
 *
 * @author Vinsh Liu
 * @since 2021.03.25 周四
 */
public class ListTest {
    public static void main(String[] args) {
//        List<Object> objects = Lists.emptyList(); //UnsupportedOperationException
        List<Object> objects = Lists.newArrayList();
//        List<Object> objects = ImmutableList.of(); // UnsupportedOperationException
//        List<Object> objects = Collections.emptyList(); // UnsupportedOperationException
//        List<Object> objects = Collections.EMPTY_LIST; // UnsupportedOperationException
//        List<Object> objects = null; // NullPointerException
//        List<Object> objects = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            objects.add(i);
        }

        objects.forEach(System.out::println);
    }
}

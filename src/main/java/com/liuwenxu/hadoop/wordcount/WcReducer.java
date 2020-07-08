package com.liuwenxu.hadoop.wordcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Copyright (C), 2016-2020, Mobius-Vision
 * FileName: WcReducer
 * Author: liuwenxu
 * Date: 2020/3/16 19:50
 * Description:
 */
public class WcReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

    private IntWritable res = new IntWritable();
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int sum = 0;
        // 累加
        for (IntWritable value : values) {
            sum += value.get();
        }

        // 包装并输出
        res.set(sum);
        context.write(key,res);
    }
}

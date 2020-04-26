package com.example.hadoop.wordcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Copyright (C), 2016-2020, Mobius-Vision
 * FileName: WcMapper
 * Author: liuwenxu
 * Date: 2020/3/16 19:19
 * Description:
 */
public class WcMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    private Text word = new Text();
    private IntWritable one = new IntWritable(1);

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
       // 拿到一行数据
        String line = value.toString();

        // 切分
        String[] words = line.split(" ");

        // 遍历，（word，1）的形式交给框架
        for (String word : words) {
            this.word.set(word);
            context.write(this.word, this.one);
        }
    }
}
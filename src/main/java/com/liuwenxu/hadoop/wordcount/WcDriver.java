package com.liuwenxu.hadoop.wordcount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * Copyright (C), 2016-2020, Mobius-Vision
 * FileName: WcDriver
 * Author: liuwenxu
 * Date: 2020/3/16 19:56
 * Description:
 */
public class WcDriver {
    public static void main(String[] args) throws Exception {
        // 获取job实例
        Job job = Job.getInstance(new Configuration());

        // 设置类路径
        job.setJarByClass(WcDriver.class);

        job.setMapperClass(WcMapper.class);
        job.setReducerClass(WcReducer.class);

        // 设置mapper、reducer输出类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        /**
         * 设置输入输出数据
         * 注意FileInputFormat导包：import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
         **/
        FileInputFormat.setInputPaths(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        // 提交给job
        boolean b = job.waitForCompletion(true);
        System.exit(b ? 0 : 1);
    }
}

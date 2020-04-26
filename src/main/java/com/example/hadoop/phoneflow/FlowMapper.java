package com.example.hadoop.phoneflow;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Copyright (C), 2016-2020, Mobius-Vision
 * FileName: FlowMapper
 * Author: liuwenxu
 * Date: 2020/3/17 13:58
 * Description:
 */
public class FlowMapper extends Mapper<LongWritable, Text, Text, FlowBean> {

    private Text phone = new Text();
    private FlowBean flow = new FlowBean();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] folws = value.toString().split("\t");
        phone.set(folws[1]);
        long up = Long.parseLong(folws[2]);
        long down = Long.parseLong(folws[3]);
        flow.set(up, down);

        context.write(phone, flow);

    }
}
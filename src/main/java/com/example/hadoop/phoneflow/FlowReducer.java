package com.example.hadoop.phoneflow;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Copyright (C), 2016-2020, Mobius-Vision
 * FileName: FlowReducer
 * Author: liuwenxu
 * Date: 2020/3/17 14:08
 * Description:
 */
public class FlowReducer extends Reducer<Text, FlowBean, Text, FlowBean> {

    private FlowBean flow = new FlowBean();

    @Override
    protected void reduce(Text key, Iterable<FlowBean> values, Context context) throws IOException, InterruptedException {
        long upSum = 0L;
        long downSum = 0L;

        for (FlowBean value : values) {
            upSum += value.getUpFolw();
            downSum += value.getDownFlow();
        }
        flow.set(upSum, downSum);
        context.write(key, flow);
    }
}
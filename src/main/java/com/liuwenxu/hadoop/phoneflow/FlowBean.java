package com.liuwenxu.hadoop.phoneflow;

import lombok.Data;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * Copyright (C), 2016-2020, Mobius-Vision
 * FileName: FlowBean
 * Author: liuwenxu
 * Date: 2020/3/17 13:45
 * Description:
 */
@Data
public class FlowBean implements Writable {

    private long upFolw;
    private long downFlow;
    private long sumFlow;

    public void set(long upFolw, long dawnFlow) {
        this.upFolw = upFolw;
        this.downFlow = dawnFlow;
        this.sumFlow = upFolw + dawnFlow;
    }

    /**
     * 序列化
     *
     * @param dataOutput 框架提供给的数据出口
     * @throws IOException
     */
    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeLong(upFolw);
        dataOutput.writeLong(downFlow);
        dataOutput.writeLong(sumFlow);
    }

    /**
     * 反序列化
     *
     * @param dataInput 框架提供给的数据来源
     * @throws IOException
     */
    @Override
    public void readFields(DataInput dataInput) throws IOException {
        upFolw = dataInput.readLong();
        downFlow = dataInput.readLong();
        sumFlow = dataInput.readLong();
    }

    @Override
    public String toString() {
        return "[" +
                "upFolw=" + upFolw +
                ", downFlow=" + downFlow +
                ", sumFlow=" + sumFlow +
                ']';
    }
}

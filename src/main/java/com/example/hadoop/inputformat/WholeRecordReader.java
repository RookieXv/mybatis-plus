package com.example.hadoop.inputformat;

import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import java.io.IOException;

/**
 * Copyright (C), 2016-2020, Mobius-Vision
 * FileName: WholeRecordReader
 * Author: liuwenxu
 * Date: 2020/3/20 14:26
 * Description: 自定义recordreader
 */
public class WholeRecordReader extends RecordReader<Text, BytesWritable> {

    private boolean progress = true;
    private Text key = new Text();
    private BytesWritable value = new BytesWritable();


    FSDataInputStream is;
    FileSplit fs;

    /**
     * 初始化recordreader
     *
     * @param inputSplit
     * @param context
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    public void initialize(InputSplit inputSplit, TaskAttemptContext context) throws IOException, InterruptedException {
        //转换切片类型
        fs = (FileSplit) inputSplit;
        // 获取路径
        Path path = fs.getPath();
        // 获取文件系统
        FileSystem fileSystem = path.getFileSystem(context.getConfiguration());
        // 开流
        is = fileSystem.open(path);

    }

    /**
     * 获取下一个kv
     *
     * @return 如果读到了，返回true，读完了，返回false
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    public boolean nextKeyValue() throws IOException, InterruptedException {
        // 如果为true，开始读文件
        if (progress) {
            // 具体读的过程
            key.set(fs.getPath().toString());


            byte[] buf = new byte[(int) fs.getLength()];
//            is.read(buf);
            IOUtils.readFully(is, buf, 0, buf.length);
            value.set(buf, 0, buf.length);

            //读到了，变为false，返回true
            progress = false;
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取当前的key
     *
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    public Text getCurrentKey() throws IOException, InterruptedException {
        return key;
    }

    /**
     * 获取当前的value
     *
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    public BytesWritable getCurrentValue() throws IOException, InterruptedException {
        return value;
    }

    /**
     * 获取读取进度
     *
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    public float getProgress() throws IOException, InterruptedException {
        return progress ? 1 : 0;
    }


    @Override
    public void close() throws IOException {
        IOUtils.closeStream(is);
    }
}
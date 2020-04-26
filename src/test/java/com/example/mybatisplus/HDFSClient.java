package com.example.mybatisplus;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.net.URI;

/**
 * Copyright (C), 2016-2020, Mobius-Vision
 * FileName: HDFSClient
 * Author: liuwenxu
 * Date: 2020/3/12 19:09
 * Description:
 */
public class HDFSClient {

    private FileSystem fs;

    @Before
    public void getFS() {
        try {
            fs = FileSystem.get(URI.create("hdfs://hadoop001:9000"), new Configuration(), "lwx");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件上传
     **/
    @Test
    public void put() throws IOException {
        fs.copyFromLocalFile(new Path("d:/wxyj_sj.sql"), new Path("/lwx/test"));
    }

    /**
     * 文件下载
     **/
    @Test
    public void get() throws IOException {
        fs.copyToLocalFile(false, new Path("/lwx/test/wxyj_sj.sql"), new Path("d:/logs/2.sql"));
    }

    /**
     * 创建目录
     **/
    @Test
    public void makeDir() throws IOException {
        fs.mkdirs(new Path("/lwx/test"));
    }

    /**
     * 删除文件夹
     **/
    @Test
    public void removeDir() throws IOException {
        boolean delete = fs.delete(new Path("/lwx/test/logs/work"), true);
        System.out.println(delete);

    }

    /**
     * 修改文件名
     **/
    @Test
    public void update() {
    }

    /**
     * 查看文件详情
     **/
    @Test
    public void fileStatus() throws IOException {
        RemoteIterator<LocatedFileStatus> iterator = fs.listFiles(new Path("/"), true);
        while (iterator.hasNext()) {
            LocatedFileStatus next = iterator.next();
            Path path = next.getPath();
            String owner = next.getOwner();
            System.out.println(path.toString() + "-----" + owner);

            BlockLocation[] blockLocations = next.getBlockLocations();
            for (BlockLocation blockLocation : blockLocations) {
                System.out.println("offset：" + blockLocation.getOffset());

                String[] hosts = blockLocation.getHosts();
                for (String host : hosts) {
                    System.out.println("host：" + host);
                }

                String[] names = blockLocation.getNames();
                for (String name : names) {
                    System.out.println("name：" + name);

                }
            }
            System.out.println("---------------------------");
        }
    }

    /**
     * 查看文件夹
     **/
    @Test
    public void dirStatus() throws IOException {
        FileStatus[] listStatus = fs.listStatus(new Path("/lwx/test"));
        for (FileStatus status : listStatus) {
            if (status.isFile()) {
                Path path = status.getPath();
                String owner = status.getOwner();
                System.out.println(path.toString() + "-----" + owner);
            } else {
                System.out.println(status.getPath().toString());
            }
        }
    }

    /**
     * io上传文件
     **/
    @Test
    public void putByIO() throws Exception {
        // 创建输入流
        FileInputStream is = new FileInputStream("d:/wxyj_sj.sql");

        // 创建输出流
//        FSDataOutputStream os = fs.create(new Path("/lwx/io.sql"));
        FSDataOutputStream os = fs.append(new Path("/lwx/io.sql"));
        // 流对接

        try {
            IOUtils.copyBytes(is, os, 1024, false);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeStream(is);
            IOUtils.closeStream(os);
        }

    }

    /**
     * io下载文件
     **/
    @Test
    public void getByIO() throws Exception {
        // 输入流
        FSDataInputStream is = fs.open(new Path("/lwx/io.sql"));
        //对接
        FileOutputStream os = new FileOutputStream("d:/ioout.sql");
        try {
            IOUtils.copyBytes(is, os, 1024, false);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeStream(is);
            IOUtils.closeStream(os);
        }
    }

    @After
    public void close() {
        try {
            fs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
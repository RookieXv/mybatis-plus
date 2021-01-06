package com.liuwenxu.mybatisplus;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.google.gson.Gson;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Stream;

/**
 * Copyright (C), 2016-2019, Mobius-Vision
 * FileName: YY
 * Author: liuwenxu
 * Date: 2019/7/29 15:47
 * Description:
 */
public class YY {
//    public static void main(String[] args) {
//
//        Member m = new Member()
//                .setUserId("ff05c247-de58-4aba-91ce-66df54761a0f")
//                .setProductId("2")
//                .setCumulativeMonth(5)
//                .setIsValid("1")
//                .setBuyCounts(5)
//                .setId("dm200325103330p0MRD1gedw")
//                .setStartTime(LocalDateTime.now())
//                .setEndTime(LocalDateTime.now().plusMonths(5));
//        try {
//            String encode = URLEncoder.encode(JSONObject.toJSONString(m),"utf-8");
//            System.out.println(encode);
//
//            String decode = URLDecoder.decode(encode, "utf-8");
//            JSONObject jsonObject = JSONObject.parseObject(decode);
//            String startTime = jsonObject.getString("startTime");
//            String endTime = jsonObject.getString("endTime");
//
//
//            Instant instant = Instant.ofEpochMilli(Long.valueOf(startTime));
//            ZoneId zone = ZoneId.systemDefault();
//            LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
//
//            Instant instant2 = Instant.ofEpochMilli(Long.valueOf(endTime));
//            ZoneId zone2 = ZoneId.systemDefault();
//            LocalDateTime localDateTime2 = LocalDateTime.ofInstant(instant2, zone2);
//
//
//            jsonObject.put("startTime", localDateTime);
//            jsonObject.put("endTime", localDateTime2);
//
//            System.out.println(jsonObject);
//            Member member = JSONObject.toJavaObject(jsonObject, Member.class);
//            System.out.println(m.getStartTime());
//            System.out.println(member.getStartTime());
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void gson555() {
//        Gson gson = new Gson();
//
//        Member m = new Member()
//                .setUserId("ff05c247-de58-4aba-91ce-66df54761a0f")
//                .setProductId("2")
//                .setCumulativeMonth(5)
//                .setIsValid("1")
//                .setBuyCounts(5)
//                .setId("dm200325103330p0MRD1gedw")
//                .setStartTime(LocalDateTime.now())
//                .setEndTime(LocalDateTime.now().plusMonths(5));
//        try {
//            String encode = URLEncoder.encode(gson.toJson(m.getId()),"utf-8");
//            System.out.println(encode);
//
//            String decode = URLDecoder.decode(encode, "utf-8");
////            Member member = gson.fromJson(decode, Member.class);
//            System.out.println(decode);
//
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    @Test
//    public void ran() {
//        Member member = new Member()
//                .setUserId("ff05c247-de58-4aba-91ce-66df54761a0f")
//                .setProductId("2")
//                .setCumulativeMonth(5)
//                .setIsValid("1")
//                .setBuyCounts(5)
//                .setId("dm200325103330p0MRD1gedw")
//                .setStartTime(LocalDateTime.now())
//                .setEndTime(LocalDateTime.now().plusMonths(5));
//        StringBuilder sb = new StringBuilder()
//                .append(member.getId())
//                .append(",")
//                .append(member.getProductId())
//                .append(",")
//                .append(member.getBuyCounts())
//                .append(",")
//                .append(member.getStartTime())
//                .append(",")
//                .append(member.getEndTime())
//                .append(",")
//                .append(member.getCumulativeMonth())
//                .append(",")
//                .append(member.getUserId())
//                .append(",")
//                .append(member.getIsValid());
//        try {
//            String encode = URLEncoder.encode(JSONObject.toJSONString(member), "UTF-8");
//            byte[] buf = encode.getBytes();
//            System.out.println(encode);
//            System.out.println(buf.length+"Byte="+buf.length/1024+"KB" );
//
//            String decode = URLDecoder.decode(encode, "UTF-8");
//            Member m = JSONObject.parseObject(decode, Member.class);
//            System.out.println(m);
//
//
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//
//    }
    @Test
    public void localdate() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

    }
    @Test
    public void getSize() {
        String uid = "oFvyU5yzQQ9rBZKSomBU5lr9QYwA";
        int length = uid.length();
        System.out.println(length);

    }
    @Test
    public void encodetest() {
        String s = null;
        String d = null;
        try {
            s = URLEncoder.encode("你是谁-123、asd", "UTF-8");
            d = URLDecoder.decode("%E4%BD%A0%E6%98%AF%E8%B0%81-123%E3%80%81asd", "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        System.out.println(s);
        System.out.println(d);

    }
    @Test
    public void testLocalDateTime() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime localDateTime = LocalDateTime.parse("2017-11-06T16:48:15.801");
        LocalDateTime localDateTime1 = LocalDateTime.of(2017, 11, 06, 16, 48, 15, 801);

        // 加减
        LocalDateTime plusHours = now.plusHours(1);
        LocalDateTime plusDays =now.plusMonths(12);
        System.out.println(now);
        System.out.println(plusDays);
//        LocalDateTime minus = now.minus(2, ChronoUnit.DAYS);
//
//        System.out.println(now.getDayOfMonth());
//
//        LocalDate localDate = localDateTime.toLocalDate();
//        LocalTime localTime = localDateTime.toLocalTime();
//        LocalDateTime localDateTime2 = LocalDateTime.from(localDate.atStartOfDay());
    }

    @Test
    public void toptional() {
        String aa = "s,a,sd";

        System.out.println(Arrays.toString(aa.split(",")));
    }

    @Test
    public void gene() {
        Stream.generate(() -> 1).limit(5).forEach(
                System.out::println
        );
    }

    @Test
    public void idworker() {
        for (int i = 0; i < 1000; i++) {
        long id = IdWorker.getId();

        System.out.println(id);
        }
    }

    @Test
    public void decimaltest() {
        BigDecimal a = new BigDecimal(1.01);
        BigDecimal b = new BigDecimal(2.02);
        BigDecimal c = new BigDecimal("1.01");
        BigDecimal d = new BigDecimal("2.02");
        BigDecimal e = BigDecimal.valueOf(1.01);
        BigDecimal f = BigDecimal.valueOf(2.02);

        System.out.println(a.add(b));
        System.out.println(c.add(d));
        System.out.println(e.add(f));
    }

    @Test
    public void bigdecimalQuyu() {
        BigDecimal a = BigDecimal.valueOf(550.00);
        BigDecimal b = BigDecimal.valueOf(100.00);
        BigDecimal cumulativeConsumption = BigDecimal.valueOf(0);

        BigDecimal[] c = a.divideAndRemainder(b);

        System.out.println(Arrays.toString(c));


        System.out.println(cumulativeConsumption.compareTo(new BigDecimal(0)) == 0);
    }

    @Test
    public void scannertest() {
//        Integer x = 3;
//        Integer y = 3;
//        System.out.println(x == y);// true
//        Integer a = new Integer(3);
//        Integer b = new Integer(3);
//        System.out.println(a == b);//false
//        System.out.println(a.equals(b));//true


//        BigDecimal m = new BigDecimal("1.25553354646546546", MathContext.DECIMAL32);
//        BigDecimal n = m.setScale(3,BigDecimal.ROUND_HALF_DOWN);
//        BigDecimal n2 = m.setScale(3,BigDecimal.ROUND_HALF_EVEN);
//        System.out.println(m);// 1.255
//        System.out.println(n);// 1.255
//        System.out.println(n2);// 1.255

        String[] str = new String[]{"you", "me"};

        List<String> list = Arrays.asList(str);
        ArrayList<Object> objects = new ArrayList<>();

//        class java.util.Arrays$ArrayList
//        class java.util.ArrayList
        System.out.println(list.getClass());
        System.out.println(objects.getClass());
        list.forEach(
                System.out::println
        );

        list.add("he"); //java.lang.UnsupportedOperationException

        System.out.println(list.size());


    }

    @Test
    public void toarray() {
        String [] s= new String[]{
                "dog", "lazy", "a", "over", "jumps", "fox", "brown", "quick", "A"
        };
        List<String> list = Arrays.asList(s);
        Collections.reverse(list);
        s=list.toArray(new String[0]);//没有指定类型的话会报错

        System.out.println(Arrays.toString(s));

    }
}

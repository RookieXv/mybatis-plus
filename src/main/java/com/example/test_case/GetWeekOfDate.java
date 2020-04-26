package com.example.test_case;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.*;

/**
 * Copyright (C), 2016-2020, Mobius-Vision
 * FileName: getWeekOfDate
 * Author: liuwenxu
 * Date: 2020/4/26 0026 18:21
 * Description: 获取指定时间段内周几的日期
 */
@Slf4j
@SuppressWarnings("all")
public class GetWeekOfDate {
    public static void main(String[] args) {
        //
//        System.out.println(getWeekendInMonth(2020, 4));
        LocalDate s = LocalDate.of(2020, 4, 1);
        LocalDate e = LocalDate.of(2020, 5, 1);
        System.out.println(getWeekInTimes(s, e, 1));


    }

    /**
     * 获取当月的所有周末
     *
     * @param year  2020
     * @param month 4
     * @return [2020-4-4, 2020-4-5, 2020-4-11, 2020-4-12, 2020-4-18, 2020-4-19, 2020-4-25, 2020-4-26]
     */
    public static List getWeekendInMonth(int year, int month) {

        List list = new ArrayList();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);// 不设置的话默认为当年
        calendar.set(Calendar.MONTH, month - 1);// 设置月份
        calendar.set(Calendar.DAY_OF_MONTH, 1);// 设置为当月第一天
        int daySize = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);// 当月最大天数
        for (int i = 0; i < daySize - 1; i++) {
            calendar.add(Calendar.DATE, 1);//在第一天的基础上加1
            int week = calendar.get(Calendar.DAY_OF_WEEK);
            if (week == Calendar.SATURDAY || week == Calendar.SUNDAY) {// 1代表周日，7代表周六 判断这是一个星期的第几天从而判断是否是周末
                list.add(year + "-" + month + "-" + calendar.get(Calendar.DAY_OF_MONTH));// 得到当天是一个月的第几天
            }
        }
        return list;
    }


    public static List getWeekInMonth() {
        ArrayList<String> list = new ArrayList<>();

        Calendar start = Calendar.getInstance();
        start.set(2020, Calendar.APRIL, 1);

        Calendar end = Calendar.getInstance();
        end.set(2020, Calendar.MAY, 30);

        long diffDays = (end.getTimeInMillis() - start.getTimeInMillis()) / (1000 * 60 * 60 * 24);
        System.out.println("时间段：" + diffDays);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < diffDays - 1; i++) {
            start.add(Calendar.DATE, 1);
            int week = start.get(Calendar.DAY_OF_WEEK);
            if (week == Calendar.MONDAY) {// 1代表周日，7代表周六 判断这是一个星期的第几天从而判断是否是周末
                list.add(format.format(start.getTime()));// 得到当天是一个月的第几天
            }
        }
        return list;
    }

    /**
     * 获取指定时间内星期几的所有日期
     * @Author liuwenxu.com (2020-04-26)
     *
     * @param start 开始日期 2020-04-01
     * @param end   截止日期 2020-05-01
     * @param week  星期几 1
     * @return ArrayList<LocalDate> [2020-04-06, 2020-04-13, 2020-04-20, 2020-04-27]
     */
    public static List getWeekInTimes(LocalDate start, LocalDate end, int week) {
        ArrayList<LocalDate> list = new ArrayList<>();

        long days = ChronoUnit.DAYS.between(start, end);
        log.info("[{}~{})之间共有：{}天", start, end, days);

        Calendar startCalender = GregorianCalendar.from(start.atStartOfDay(ZoneId.systemDefault()));
        for (int i = 0; i < days - 1; i++) {
            startCalender.add(Calendar.DATE, 1);

            if (startCalender.get(Calendar.DAY_OF_WEEK) == week + 1) {// 1代表周日，7代表周六
                list.add(
                        LocalDateTime.ofInstant(
                                startCalender.toInstant(),
                                ZoneOffset.systemDefault()
                        ).toLocalDate()
                );
            }
        }
        log.info("[{}~{})之间共有：{}个 星期{}", start, end, list.size(), week);
        return list;
    }
}
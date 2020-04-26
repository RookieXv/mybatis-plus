package com.example.test_case;

import lombok.extern.slf4j.Slf4j;

import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * Copyright (C), 2016-2020, Mobius-Vision
 * FileName: TimeDifference
 * Author: liuwenxu
 * Date: 2020/4/26 0026 21:09
 * Description: 时间差
 */
@Slf4j
public class TimeDifference {
    public static void main(String[] args) {
        LocalDate start = LocalDate.of(2020, 1, 1);
        LocalDate end = LocalDate.of(2020, 5, 1);

        testPeriod(start, end);
        testDuration(start, end);
        testChronoUnit(start, end);
    }

    /**
     * 主要是Period类方法getYears（），getMonths（）和getDays（）来计算.
     * @Author liuwenxu.com (2020-04-26)
     *
     * @param start
     * @param end
     * @return void
     * 21:26:49.196 [main] INFO com.example.test_case.TimeDifference - startPeriod : 2020-01-01
     * 21:26:49.205 [main] INFO com.example.test_case.TimeDifference - endPeriod : 2020-05-01
     * 21:26:49.306 [main] INFO com.example.test_case.TimeDifference - [2020-01-01~2020-05-01)之间共有：0年,4月,0日
     **/
    private static void testPeriod(LocalDate start, LocalDate end) {

        log.info("startPeriod : {}", start);
        log.info("endPeriod : {}", end);

        Period period = Period.between(start, end);
        log.info("[{}~{})之间共有：{}年,{}月,{}日", start, end, period.getYears(), +period.getMonths(), +period.getDays());
    }

    /**
     *
     * @Author liuwenxu.com (2020-04-26)
     *
     * @param start
     * @param end
     * @return void
     * 21:26:49.318 [main] INFO com.example.test_case.TimeDifference - startInstant : 2019-12-31T16:00:00Z
     * 21:26:49.325 [main] INFO com.example.test_case.TimeDifference - endInstant : 2020-04-30T16:00:00Z
     * 21:26:49.325 [main] INFO com.example.test_case.TimeDifference - [2020-01-01~2020-05-01)之间共有：121天
     **/
    private static void testDuration(LocalDate start, LocalDate end) {

        Instant startInstant = start.atStartOfDay(ZoneId.systemDefault()).toInstant();
        Instant endInstant = end.atStartOfDay(ZoneId.systemDefault()).toInstant();

        log.info("startInstant : {}", startInstant);
        log.info("endInstant : {}", endInstant);

        Duration between = Duration.between(startInstant, endInstant);
        log.info("[{}~{})之间共有：{}天", start, end, between.toDays());

    }

    /**
     *
     * @Author liuwenxu.com (2020-04-26)
     *
     * @param start
     * @param end
     * @return void
     * 21:26:49.325 [main] INFO com.example.test_case.TimeDifference - startChronoUnit : 2020-01-01
     * 21:26:49.325 [main] INFO com.example.test_case.TimeDifference - endChronoUnit : 2020-05-01
     * 21:26:49.326 [main] INFO com.example.test_case.TimeDifference - [2020-01-01~2020-05-01)之间共有：121天
     **/
    private static void testChronoUnit(LocalDate start, LocalDate end) {
        log.info("startChronoUnit : {}", start);
        log.info("endChronoUnit : {}", end);

        long daysDiff = ChronoUnit.DAYS.between(start, end);
        log.info("[{}~{})之间共有：{}天", start, end, daysDiff);

    }
}
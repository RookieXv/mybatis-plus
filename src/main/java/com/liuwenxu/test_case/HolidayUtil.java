package com.liuwenxu.test_case;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.util.Calendar;

/**
 * Copyright (C), 2015-2020, https://www.liuwenxu.com/
 * FileName: HolidayUtil
 * Author: liuwenxu
 * Date: 2020/7/30 6:37 下午
 * Description:
 */
public class HolidayUtil {

	/**
	 * 节假日请求工具类
	 * @param httpArg 日期字符串
	 * @return 0上班  1周末  2节假日
	 */
	public static String request(String httpArg) {
	    String httpUrl = "http://tool.bitefu.net/jiari/";
	    BufferedReader reader = null;
	    String result = null;
	    StringBuffer sbf = new StringBuffer();
	    httpUrl = httpUrl + "?d=" +httpArg;
	    try {
	        URL url = new URL(httpUrl);
	        HttpURLConnection connection = (HttpURLConnection) url
	                .openConnection();
	        connection.setRequestMethod("GET");
	        connection.connect();
	        InputStream is = connection.getInputStream();
	        reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
	        String strRead = null;
	        while ((strRead = reader.readLine()) != null) {
	            sbf.append(strRead);
	        }
	        reader.close();
	        result = sbf.toString();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return result;
	}

	public static void main(String[] args) {

		String dateStr = LocalDate.now().toString().replaceAll("-", "");
//		System.out.println(dateStr);
//		Calendar timestampCalendar = Calendar.getInstance();
//		timestampCalendar.setTimeInMillis(System.currentTimeMillis());
//		System.out.println(timestampCalendar.get(Calendar.DAY_OF_WEEK));

		String jsonResult = HolidayUtil.request(dateStr);
		// 0 上班  1周末 2节假日
		if ("0".equals(jsonResult)) {
			//return resultObject.getFailResult("上班");
			System.out.println("0上班");
		}
		if ("1".equals(jsonResult)) {
			//return resultObject.getFailResult("1周末");
			System.out.println("1周末");
		}
		if ("2".equals(jsonResult)) {
			//return resultObject.getFailResult("");
			System.out.println("2节假日");
		}
	}

}

package com.unicom.salesmanagebehind.utils;

import java.text.*;
import java.util.*;

/**
 * 
 * 时间转换工具类
 * @author ldh
 *
 *
 */
public class DateUtil {

	//将时间串转为Date ，传入格式如“2018-01-01”
		public static Date parseDate(String rpDate) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = null;
			try {
				date = sdf.parse(rpDate);
			} catch (ParseException e) {

				e.printStackTrace();
//				时间转换出错时，应抛出异常
			}	
			return date;
		}
		
//		将时间转为固定格式的String
		public static String getStringDate(Date date) {
			Date currentTime = date;
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String dateString = null;
			try {
				dateString= formatter.format(currentTime);
			} catch (Exception e) {
				e.printStackTrace();
//				时间转换出错时，应抛出异常
			}	
			return dateString;
		}
	
}

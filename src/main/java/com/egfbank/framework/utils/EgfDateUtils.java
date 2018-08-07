package com.egfbank.framework.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EgfDateUtils {

	public final static String  DATETIME_DETAIL_LIST = "yyyyMMddHHmmss";
	
	public final static String DATE_LIST ="yyyyMMdd";
	
	private static SimpleDateFormat dateDetailFormat = new SimpleDateFormat(DATETIME_DETAIL_LIST);
	private static SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_LIST);
	
	public static String formateCurrentDateTime(Date date){
		return dateDetailFormat.format(date);
	}
	
	public static String formateCurrentDateTime(){
		return dateDetailFormat.format(new java.util.Date());
	}
	
	public static String formateCurrentDate(){
		return dateFormat.format(new java.util.Date());
	}
	
	public static void main(String[] args){
		System.out.println(EgfDateUtils.formateCurrentDate());
		System.out.println(EgfDateUtils.formateCurrentDateTime());
	}
}

package com.egfbank.account.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EgfDateUtils {

	public final static String  DATE_DETAIL_LIST = "yyyyMMddHHmmss";
	
	public final static String  DATE_SIMPLE_FORMATE="yyyyMMdd";
	
	 
	private static SimpleDateFormat createSimpleDateFormat (String formate){
		SimpleDateFormat dateDetailFormat = new SimpleDateFormat(formate);
		return dateDetailFormat;
	}
	
	public static String formateStringDate(Date date){
		return  createSimpleDateFormat(DATE_DETAIL_LIST).format(date);
	}
	
	public static String formateCurrentDateTime(){
		return createSimpleDateFormat(DATE_DETAIL_LIST).format(new java.util.Date());
	}
	
	public static String formateCurrentDate(){
		return createSimpleDateFormat(DATE_SIMPLE_FORMATE).format(new java.util.Date());
	}
	
	public static void main(String[] args){
		System.out.println(EgfDateUtils.formateCurrentDateTime());
		SimpleDateFormat dateFormate = createSimpleDateFormat(DATE_SIMPLE_FORMATE);
		System.out.println(dateFormate.format(new java.util.Date()));
	}
}

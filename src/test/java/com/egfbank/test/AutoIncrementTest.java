package com.egfbank.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AutoIncrementTest {

	public static void main(String[] args) {
		AtomicInteger transactionIndex = new AtomicInteger(1);
		for(int i=0;i<20;i++){
			System.out.println(transactionIndex.getAndIncrement());
		}
		// TODO Auto-generated method stub
		List<String>  fieldList = new ArrayList<String>();
		fieldList.add("ABC");
		fieldList.add("DEF");
		fieldList.add("xyz");
		int size = fieldList.size();
		StringBuffer buffer = new StringBuffer();
		for (int i=0;i<fieldList.size();i++) {
			buffer.append(fieldList.get(i));
			if(i<(size-1))
			buffer.append(",");
			
		}
		
		String field = "";// 字段字符串，字段之间以‘,’分开
		for (String f : fieldList) {
			if (field.equals("")) {
				field = f;
			} else {
				field += "," + f;
			}
		}
		System.out.println(field);
		System.out.println(buffer.toString());
		
	}

}

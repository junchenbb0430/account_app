package com.egfbank.framework.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileService {
	
	private static final String FILE_NAME = System.getProperty("user.dir")+"/src/main/resources/result/conumerResult.txt";
	
	// 换行符，linux平台 "\n"，windows平台是"\r\n"
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");
	
	public static void writeIntoFile(String content){
		writeIntoFile(content,true);
		
	}
	
	public static void writeIntoFile(String content,boolean append){
		
		BufferedWriter bufferWriter = null;;
		try {
			bufferWriter = new BufferedWriter(new FileWriter(FILE_NAME,true));
			bufferWriter.write(content);
			bufferWriter.newLine();
			bufferWriter.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				bufferWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	public static void main(String[] args){
		System.out.println(System.getProperty("user.dir"));
		System.out.println(System.getProperty("line.separator"));
//		FileService.writeIntoFile("abc");
		while(true){
			int[] arr = new int[1024];
		}
	}
}

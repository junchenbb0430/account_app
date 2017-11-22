package com.egfbank.jvm;

import java.util.ArrayList;
import java.util.List;

public class OOMExampleTest {

	public static void main(String[] args) {
		 List<byte[]> buffer = new ArrayList<byte[]>();
		 for(int i=0;i<8;i++)
		 buffer.add(new byte[10*1024*1024]);
		 try {
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e) {
			 
			e.printStackTrace();
		}
	}

}

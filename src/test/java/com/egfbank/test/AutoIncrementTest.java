package com.egfbank.test;

import java.util.concurrent.atomic.AtomicInteger;

public class AutoIncrementTest {

	public static void main(String[] args) {
		AtomicInteger transactionIndex = new AtomicInteger(1);
		for(int i=0;i<20;i++){
			System.out.println(transactionIndex.getAndIncrement());
		}
		
	}

}

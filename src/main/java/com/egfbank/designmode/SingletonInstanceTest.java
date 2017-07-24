package com.egfbank.designmode;

public class SingletonInstanceTest {

	public static void main(String[] args) {
		for(int i=0;i<50;i++){
			 new Thread(new ThreadDemo()).start();
		}
		for(int i=0;i<30;i++){
			 new Thread(new ThreadDemo()).start();
		}
	}
}

class ThreadDemo implements Runnable{
	public void run() {
		System.out.println(SingletonInstance.getInstance3());
	}
	
}

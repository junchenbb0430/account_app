package com.egfbank.concurrent.synchronizetest;

public class SynchronizedNumTest {

	public static void main(String[] args) {
		ConcurrentNum num = new ConcurrentNum();
		 
		ThreadA threada = new ThreadA(num);
		ThreadB threadb = new ThreadB(num);
		threada.start();
		threadb.start();
	}

}

class ConcurrentNum{
	private volatile int counter = 0;
	
	public synchronized void trans(String var){
		if("a".equals(var)){
			counter = 100;
			System.out.println("a的值应该是100，实际值是  "+counter);
		}else if("b".equals(var)){
			counter = 200;
			System.out.println("b的值应该是200，实际值是  "+counter);
		}
	}
}

class ThreadA extends Thread{
	private ConcurrentNum concurrent;
	
	public ThreadA(ConcurrentNum concurrent){
		this.concurrent = concurrent;
	}
	
	public void run(){
		concurrent.trans("a");
	}
}

class ThreadB extends Thread{
	private ConcurrentNum concurrent;
	
	public ThreadB(ConcurrentNum concurrent){
		this.concurrent = concurrent;
	}
	
	public void run(){
		concurrent.trans("b");
	}
}

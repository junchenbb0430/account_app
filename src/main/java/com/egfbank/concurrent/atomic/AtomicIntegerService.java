package com.egfbank.concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author tonny
 * AtomicIngeter封装及测试
 */
public class AtomicIntegerService{
	
	private int counter;
	private AtomicInteger atomic ;
	
	
	public AtomicIntegerService(int counter){
		this.counter = counter;
		atomic = new AtomicInteger(counter);
	}
	
	public AtomicIntegerService( ){
	 
	}
	
	/**
	 * 返回当前值
	 * @return
	 */
	public int getCurrent(){
		return atomic.get();
	}
	
	
	/**
	 * 返回更新后的数值,每次默认加1.
	 * next = current+1
	 * @return current
	 */
	public int getAndIncrement(){
		return atomic.getAndIncrement();
	}
	/**
	 * 返回更新后的数值,每次默认加1.
	 * next = current+1
	 * @return  next
	 */
	public int incrementAndGet(){
		return atomic.incrementAndGet();
	}
	/**
	 * 当前数值current，加上num。next = current+num
	 * 返回next
	 * @param num
	 * @return 返回更新后的数值
	 */
	public int addAndGet(int num){
		return atomic.addAndGet(num);
	}
	/**
	 * 将num加到当前数值上。即current+num=next
	 * 但是返回current
	 * @param num
	 * @return 返回更新前的数值
	 */
	public int getAndAdd(int num){
		return atomic.getAndAdd(num);
	}
	
	/**
	 * 直接将newValue设置成最新的值，然后返回 以前的数值
	 * @param newValue
	 * @return
	 */
	public int getAndSet(int newValue){
		return atomic.getAndSet(newValue);
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
	
	
}

class AtomicIntegerServiceThread implements Runnable{

	private  AtomicIntegerService service;
	
	
	
	public AtomicIntegerServiceThread(AtomicIntegerService service) {
		super();
		this.service = service;
	}



	public void run() {
		System.out.println(service.incrementAndGet());
	}
	
}

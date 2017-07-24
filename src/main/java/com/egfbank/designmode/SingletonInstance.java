package com.egfbank.designmode;


public class SingletonInstance {

	private   volatile static SingletonInstance instance = null;
	
	private SingletonInstance(){}
	
	/**
	 * 这种方式实现单例模式有问题
	 * @return
	 */
	public static SingletonInstance getInstance (){
		if(null == instance){	 
			instance = new  SingletonInstance();
		}
		return instance;
	}
	
	/**
	 * 生产的对象实例，不是单一的。即非单例模式
	 * @return
	 */
	public static SingletonInstance getInstance2 (){
		if(null == instance){
			synchronized(SingletonInstance.class){
				  instance = new  SingletonInstance();
			}
		
		}
		return instance;
	}
	
	/**
	 * 这种方式虽然也能实现单例，但是每次线程都要去获取当前锁，
	 * 增加性能开销；好的方式是前面增加一个该对象是否为空判断
	 * 见getSingleInstance方法
	 * @return
	 */
	public static SingletonInstance getInstance3 (){
		 
			synchronized(SingletonInstance.class){
				if(null == instance)  
				instance = new  SingletonInstance();
			}
		
		 
		return instance;
	}
	
	public static SingletonInstance getSingleInstance(){
		if(null == instance){
			synchronized(SingletonInstance.class){
				  if(null == instance)
				   instance = new  SingletonInstance();
			}
		
		}
		return instance;
	}
}

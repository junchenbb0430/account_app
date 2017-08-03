package com.egfbank.concurrent.locktest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author tonny
 *
 */
public class ConditionOrderExecuteTest {

	private volatile static int nextPrint = 1;
	private static Lock lock = new ReentrantLock();
	private static Condition conditionA = lock.newCondition();
	private static Condition conditionB = lock.newCondition();
	private static Condition conditionC = lock.newCondition();
	 
	public static void main(String[] args) {
		 Thread threadA = new Thread( ){

			public void run() {		
					 try {
						 lock.lock();
						 while(nextPrint!=1){
							 conditionA.await();
						 }
						 for(int i=0;i<3;i++){
							 System.out.println("threadA "+(i+1));
						 }
						 nextPrint=2;
						 conditionB.signalAll();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						lock.unlock();
					}
				
			}};
		 
		 Thread threadB = new Thread(){

				public void run() {
					 try {
						 lock.lock();
						 while(nextPrint!=2){
							 conditionB.await();
						 }
						 for(int i=0;i<3;i++){
							 System.out.println("threadB "+(i+1));
						 }
						 nextPrint=3;
						 conditionC.signalAll();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						lock.unlock();
					}			
				}};
		 
		 Thread threadC = new Thread(){

				public void run() {
					 try {
						 lock.lock();
						 while(nextPrint!=3){
							 conditionC.await();
						 }
						 for(int i=0;i<3;i++){
							 System.out.println("threadC "+(i+1));
						 }
						 nextPrint=1;
						 conditionA.signalAll();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						lock.unlock();
					}	
				}};
				 		
		 Thread[] threadAs = new Thread[3];
		 Thread[] threadbs = new Thread[3];
		 Thread[] threadcs = new Thread[3];
		 for(int i=0;i<3;i++){
			 threadAs[i] = new Thread(threadA);
			 threadbs[i] = new Thread(threadB);
			 threadcs[i] = new Thread(threadC);
			 threadAs[i].start();
			 threadbs[i].start();
			 threadcs[i].start();
		 }
	}

}

class ConditionOrderService{
	
	private Lock lock;
	
	private Condition condition;
	
	
	
	public ConditionOrderService(Lock lock, Condition condition) {
		super();
		this.lock = lock;
		this.condition = condition;
	}



	public void execute(){
		
	}
}

class ConditionThreadA implements Runnable{

	private Lock lock;
	 
	 
	public ConditionThreadA(Lock lock) {
		super();
		this.lock = lock;
	}



	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}

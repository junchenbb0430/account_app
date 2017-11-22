package com.egfbank.concurrent.jdkutils;

/**
 * 1. CyclicBarrier主要是用来设置一组屏障，当前线程到达这个屏障时进行阻塞。当最后线程执行到屏障时，
 * 解除屏障。先前阻塞的所有线程再正式运行。
 * 2. CyclicBarrier的构造函数中可以指定优先执行的线程CyclicBarrier barrier = new CyclicBarrier(counter,Runnable);
 * @author tonny
 *
 */
public class CyclicBarrierTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

package com.egfbank.concurrent.atomic;
/**
 * @author tonny
 *
 */
public class AtomicIntegerServiceTest2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 
		AtomicIntegerService service = new AtomicIntegerService(1);
		for(int i=0;i<25;i++){
			Thread t = new Thread(new AtomicIntegerServiceThread(service));
			t.start();
		} 

	}

}

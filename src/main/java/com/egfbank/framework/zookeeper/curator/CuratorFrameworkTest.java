package com.egfbank.framework.zookeeper.curator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CuratorFrameworkTest {

	public static void main(String[] args) {
		String configLocation="classpath:config/spring/spring-config.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
		CuratorFrameworkCreator creator = context.getBean(CuratorFrameworkCreator.class);
		 
				
				 
	}

}

class CuratorFrameworkThead implements Runnable{

	private CuratorFrameworkCreator creator ;
	
	private int counter;
	
	public CuratorFrameworkThead(CuratorFrameworkCreator creator,int i ) {
		super();
		this.creator = creator;
		this.counter = i;
	}



	public void run() {
		System.out.println(counter+"-->"+creator.getCuratorFrameWork());
		
	}
	
}

package com.egfbank.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class AccountServiceContext implements ApplicationContextAware,InitializingBean,DisposableBean {

	private transient ApplicationContext applicationContext;
	
	private String serviceName;
	
	public AccountServiceContext(){
		System.out.println("constructor execute! ");
		
		
	}
	
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
		System.out.println("Spring容器主动调用ApplicationContextAwar接口，将ApplicationContext加载 : "+applicationContext);
		 
	}
	public void afterPropertiesSet() throws Exception {
		 System.out.println("*****afterPropertiesSet method execute!*****");
		 System.out.println("属性值是 ： "+this.getServiceName());
		 this.setServiceName("初始化数据库连接");
	}
	
	public void destroy() throws Exception {
		 System.out.println("*****destroy method execute!*****");
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	
	
}

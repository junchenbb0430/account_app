package com.egfbank.springredis;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.connection.RedisClusterConnection;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisSentinelConnection;

import com.egfbank.account.utils.EgfDateUtils;

public class RedisConnectionManager {

	// 默认是JedisClusterConnection
	 private RedisConnectionFactory connFactory;
	 
	 /**
	  * 
	  * @return  集群连接
	  */
	 public RedisClusterConnection getClusterConnection(){
		
		
		 return  connFactory.getClusterConnection();
	 }
	 
	 /**
	  * 单个连接
	  * @return
	  */
	 public RedisConnection getConnection(){
		 return null;
	 }
	
	 /**
	  * 返回RedisSentinel连接
	  * @return
	  */
	 public RedisSentinelConnection getSentinelConnection(){
		 return null;
	 }
	 
	 public void setConnFactory(RedisConnectionFactory connFactory) {
		this.connFactory = connFactory;
	 }



	public static void main(String[] args){
		 
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:/config/spring-redis.xml");
		RedisConnectionManager connectionManager = context.getBean(RedisConnectionManager.class);
		RedisClusterConnection  clusterConnection= connectionManager.getClusterConnection(); 
//		String currentDate = EgfDateUtils.formateCurrentDate();
//		try {
//			for(int i=0;i<200;i++){
//				
//				RedisClusterConnection  clusterConnection= connectionManager.getClusterConnection();
//				System.out.println(clusterConnection);
//				clusterConnection.set((currentDate+i).getBytes("UTF-8"),currentDate.getBytes("UTF-8"));
//			}
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		 
	}
}

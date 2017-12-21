package com.egfbank.redis.sentinel;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Response;
import redis.clients.jedis.Transaction;

public class RedisSentinelTest {

	
	
	public static void main(String[] args) throws InterruptedException {
		 
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:/config/spring-redis.xml");
//		JedisSentinelConnectionPool jedisSentinel = context.getBean(JedisSentinelConnectionPool.class);
//		Jedis jedis = jedisSentinel.getJedisInstance();
//		jedis.pipelined();
		Jedis jedis = new Jedis("192.168.121.5",9000);
		 
		Transaction transaction  =jedis.multi();
		transaction.incr("counter");
		 		Response response = transaction.get("counter");
		transaction.exec();
		System.out.println(response);
		 
		
	}

}

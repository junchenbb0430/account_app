package com.egfbank.redis.service.template;

import org.springframework.beans.factory.InitializingBean;

import com.egfbank.redis.factory.RedisConnectionFactory;

public class RedisDataAccessor implements InitializingBean{

	
	private RedisConnectionFactory  jedisFactory;

	
	
	public RedisDataAccessor() {
		super();
	}

	public void setJedisFactory(RedisConnectionFactory jedisFactory) {
		this.jedisFactory = jedisFactory;
	}

	public RedisConnectionFactory getJedisFactory() {
		return jedisFactory;
	}

	public void afterPropertiesSet() throws Exception {
		if(null != jedisFactory) 
		System.out.println("JedisConnectionFactory is not null!");
	}
	
	
}

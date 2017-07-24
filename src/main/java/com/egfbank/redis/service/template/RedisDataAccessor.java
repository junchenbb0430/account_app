package com.egfbank.redis.service.template;

import org.springframework.beans.factory.InitializingBean;

import com.egfbank.redis.factory.EgfRedisConnectionFactory;

public class RedisDataAccessor implements InitializingBean{

	
	private EgfRedisConnectionFactory  jedisFactory;

	
	
	public RedisDataAccessor() {
		super();
	}

	public void setJedisFactory(EgfRedisConnectionFactory jedisFactory) {
		this.jedisFactory = jedisFactory;
	}

	public EgfRedisConnectionFactory getJedisFactory() {
		return jedisFactory;
	}

	public void afterPropertiesSet() throws Exception {
		if(null != jedisFactory) 
		System.out.println("JedisConnectionFactory is not null!");
	}
	
	
}

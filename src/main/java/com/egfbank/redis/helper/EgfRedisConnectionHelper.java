package com.egfbank.redis.helper;

import redis.clients.jedis.Jedis;

import com.egfbank.redis.factory.EgfRedisConnectionFactory;

public class EgfRedisConnectionHelper {

	
	public static Jedis getRedisConnection(EgfRedisConnectionFactory factory){
		return factory.getRedisConnection();
	}
}

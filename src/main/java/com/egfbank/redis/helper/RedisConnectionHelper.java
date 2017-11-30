package com.egfbank.redis.helper;

import redis.clients.jedis.Jedis;

import com.egfbank.redis.factory.RedisConnectionFactory;

public class RedisConnectionHelper {

	
	public static Jedis getRedisConnection(RedisConnectionFactory factory){
		return factory.getRedisConnection();
	}
}

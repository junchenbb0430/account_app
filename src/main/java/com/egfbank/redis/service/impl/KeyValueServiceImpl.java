package com.egfbank.redis.service.impl;

import redis.clients.jedis.Jedis;

import com.egfbank.redis.sentinel.JedisSentinelConnectionPool;
import com.egfbank.redis.service.KeyValueService;
import com.egfbank.serialize.EgfJdkSerializeService;

public class KeyValueServiceImpl<K,V> implements KeyValueService<K, V> {

	private JedisSentinelConnectionPool jedisSentinelPool;
	
	public void set(K key, V value) {
		Jedis jedis = jedisSentinelPool.getJedisInstance();
		 byte[] keyBytes = EgfJdkSerializeService.serializeObject2Byte(key);
		 byte[] valueBytes = EgfJdkSerializeService.serializeObject2Byte(value);
		jedis.set(keyBytes, valueBytes);
		jedis.close();
	}

	public V get(K key) {
		Jedis jedis = jedisSentinelPool.getJedisInstance();
		 byte[] keyBytes = EgfJdkSerializeService.serializeObject2Byte(key);
		 byte[] valueBytes = jedis.get(keyBytes);
		 jedis.close();
		return (V)EgfJdkSerializeService.deserializeBytes2Object(valueBytes);
	}

	public void setJedisSentinelPool(JedisSentinelConnectionPool jedisSentinelPool) {
		this.jedisSentinelPool = jedisSentinelPool;
	}
	
	

}

package com.egfbank.redis.service;

public interface KeyValueService<K,V> {

	/**
	 * 存储key,value
	 */
	 void set(K key,V value);
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	 V get(K key);
	
	 
	
	
}

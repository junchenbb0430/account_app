package com.egfbank.redis.service;

public interface EgfKeyValueService<K,V> {

	/**
	 * 存储key,value
	 */
	public void set(K key,V value);
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public V get(K key);
	
}

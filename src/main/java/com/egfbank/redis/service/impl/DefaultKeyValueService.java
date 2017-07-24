	package com.egfbank.redis.service.impl;

import com.egfbank.redis.callback.EgfRedisCallback;
import com.egfbank.redis.connection.EgfRedisConnection;
import com.egfbank.redis.service.EgfKeyValueService;
import com.egfbank.redis.service.template.EgfRedisKVServiceTemplate;
import com.egfbank.serialize.EgfJdkSerializeService;

public class DefaultKeyValueService<K,V> implements EgfKeyValueService<K, V> {

	 
	
	private EgfRedisKVServiceTemplate template;
	
	public void set(K key, V value) {
		
		final byte[] byteKey = EgfJdkSerializeService.serializeObject2Byte(key);
		final byte[] byteValue = EgfJdkSerializeService.serializeObject2Byte(value);
		
		execute(new EgfRedisCallback(){
			
			public Object doInRedis(EgfRedisConnection conn) {
				conn.set(byteKey, byteValue); 
				return null;
			}});
		 
	}

	public V get(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object execute(EgfRedisCallback callback){
		return template.execute(callback);
	}
	
}

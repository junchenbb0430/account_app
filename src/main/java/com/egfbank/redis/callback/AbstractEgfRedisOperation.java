package com.egfbank.redis.callback;

import com.egfbank.redis.connection.EgfRedisConnection;

public abstract class AbstractEgfRedisOperation<T> implements EgfRedisCallback<T> {

	
	
	public T doInRedis(EgfRedisConnection conn) {
		
	
		
		return null;
	}
 
	public  abstract T inRedis(byte[] key,EgfRedisConnection conn);
}

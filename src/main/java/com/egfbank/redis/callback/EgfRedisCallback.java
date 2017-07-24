package com.egfbank.redis.callback;

import com.egfbank.redis.connection.EgfRedisConnection;

public interface EgfRedisCallback<T> {

	 public T doInRedis(EgfRedisConnection conn);
}

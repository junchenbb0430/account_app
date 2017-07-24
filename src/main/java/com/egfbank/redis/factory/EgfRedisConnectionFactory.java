package com.egfbank.redis.factory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisShardInfo;

public class EgfRedisConnectionFactory {

	private JedisPool pool;
	
	private boolean usePool = true;
	
	private JedisCluster cluster;
	
	private JedisShardInfo jedisShardInfo;

	public Jedis getRedisConnection(){
		//如果cluster不为空，优先使用集群
		if(null!=cluster){
			// TODO
			return null;
		}else if(usePool){
			return pool.getResource();
		}else{
			Jedis jedis = new Jedis(jedisShardInfo);
			jedis.connect();
			return jedis;
		}
	
	}
	
	public void setPool(JedisPool pool) {
		this.pool = pool;
	}

	public void setUsePool(boolean usePool) {
		this.usePool = usePool;
	}

	public void setCluster(JedisCluster cluster) {
		this.cluster = cluster;
	}

	public void setJedisShardInfo(JedisShardInfo jedisShardInfo) {
		this.jedisShardInfo = jedisShardInfo;
	}
	
	
	
	
}

package com.egfbank.redis.service.template;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;

import com.egfbank.redis.callback.EgfRedisCallback;
import com.egfbank.redis.factory.RedisConnectionFactory;
import com.egfbank.redis.helper.RedisConnectionHelper;
import com.egfbank.redis.service.KeyValueService;
import com.egfbank.serialize.EgfJdkSerializeService;
import com.egfbank.serialize.Person;
/**
 * 
 * @author lijunshi
 * 提供Redis操作的封装，屏蔽对象的序列化和反序列化
 * 同时对于redis的连接进行底层管理，无需关注连接获取和释放
 * 提供线程安全的操作，防止并发操作的危险
 * @param <T>
 */
@Service
public class EgfRedisKVServiceTemplate<K,V, T> extends RedisDataAccessor{
	
   
}

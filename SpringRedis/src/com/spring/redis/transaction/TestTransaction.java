package com.spring.redis.transaction;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;

public class TestTransaction {

	public static void main(String[] args) {
		ApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
		RedisTemplate redisTemplate= (RedisTemplate) cxt.getBean("hashRedisTemplate");
		SessionCallback sessionCallback = new SessionCallback() {

			@Override
			public Object execute(RedisOperations redisOperations)
					throws DataAccessException {
				redisOperations.multi();
				redisOperations.boundValueOps("key1").set("value1");
				String value = (String) redisOperations.boundValueOps("key1").get();
				System.out.println("事务执行过程中，命令入队列，而没有被执行，所以value="+value);
				List list = redisOperations.exec();
				System.out.println(list);
				value = (String) redisOperations.boundValueOps("key1").get();
				return value;
			}
		};
		String value = (String) redisTemplate.execute(sessionCallback);
		System.out.println(value);
	}
}

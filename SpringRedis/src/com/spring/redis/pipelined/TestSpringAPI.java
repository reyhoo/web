package com.spring.redis.pipelined;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;

public class TestSpringAPI {

	
	public static void main(String[] args) {
		ApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
		RedisTemplate redisTemplate = (RedisTemplate) cxt.getBean("hashRedisTemplate");
		SessionCallback callback = new SessionCallback() {

			@Override
			public Object execute(RedisOperations ops)
					throws DataAccessException {
				for (int i = 0; i < 100000; i++) {
					int j = i + 1;
					ops.boundValueOps("pipeline_key_"+j).set("pipeline_value_"+j);
					ops.boundValueOps("pipeline_key_"+j).get();
				}
				return null;//right
			}
		};
		
		long start = System.currentTimeMillis();
		Object resultList = redisTemplate.executePipelined(callback);
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	}
}

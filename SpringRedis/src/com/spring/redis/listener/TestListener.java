package com.spring.redis.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

public class TestListener {

	public static void main(String[] args) {
		ApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
		RedisTemplate redisTemplate = (RedisTemplate) cxt.getBean("hashRedisTemplate");
		String channel = "chat";
		redisTemplate.convertAndSend(channel, "ÄãºÃ");
	}
}

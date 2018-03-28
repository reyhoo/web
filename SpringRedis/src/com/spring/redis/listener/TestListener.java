package com.spring.redis.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

public class TestListener {
/***
 * 要测试发布订阅要在applicationContext.xml中取消topicContainer的注释
 * @param args
 */
	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis()/1000+3600);
		ApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
		RedisTemplate redisTemplate = (RedisTemplate) cxt.getBean("hashRedisTemplate");
		String channel = "chat";
		redisTemplate.convertAndSend(channel, "你好");
	}
}

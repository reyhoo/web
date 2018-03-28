package com.spring.redis.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

public class TestListener {
/***
 * Ҫ���Է�������Ҫ��applicationContext.xml��ȡ��topicContainer��ע��
 * @param args
 */
	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis()/1000+3600);
		ApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
		RedisTemplate redisTemplate = (RedisTemplate) cxt.getBean("hashRedisTemplate");
		String channel = "chat";
		redisTemplate.convertAndSend(channel, "���");
	}
}

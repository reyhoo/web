package com.spring.redis.str;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

public class TestNum {

	
	public static void main(String[] args) {
		ApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
		RedisTemplate redisTemplate = (RedisTemplate) cxt.getBean("strRedisTemplate");
		redisTemplate.opsForValue().set("i", "9");
		printCurrValue(redisTemplate,"i");
		redisTemplate.opsForValue().increment("i", 2);
		printCurrValue(redisTemplate,"i");
		redisTemplate.getConnectionFactory().getConnection().decr(redisTemplate
				.getKeySerializer().serialize("i"));
		printCurrValue(redisTemplate,"i");
		redisTemplate.getConnectionFactory().getConnection().decrBy(redisTemplate.getKeySerializer().serialize("i"), 6);
		printCurrValue(redisTemplate,"i");
		redisTemplate.opsForValue().increment("i", 2.3);
		printCurrValue(redisTemplate, "i");
	}
	
	private static void printCurrValue(RedisTemplate redisTemplate,String key){
		System.out.println(redisTemplate.opsForValue().get(key));
	}
}

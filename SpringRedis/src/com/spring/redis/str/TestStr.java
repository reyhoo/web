package com.spring.redis.str;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

public class TestStr {
	
	
	/***
	 * 127.0.0.1:6379> set key1 value1
		OK
		127.0.0.1:6379> set key2 value2
		OK
		127.0.0.1:6379> get key1
		"value1"
		127.0.0.1:6379> del key1
		(integer) 1
		127.0.0.1:6379> get key1
		(nil)
		127.0.0.1:6379> strlen key2
		(integer) 6
		127.0.0.1:6379> getset key2 new_value2
		"value2"
		127.0.0.1:6379> get key2
		"new_value2"
		127.0.0.1:6379> getrange key2 0 3
		"new_"
		127.0.0.1:6379> append key2 _app
		(integer) 14
		127.0.0.1:6379> get key2
		"new_value2_app"
	 * @param args
	 */
	
	public static void main(String[] args) {
		ApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
		RedisTemplate<String,String> redisTemplate = (RedisTemplate) cxt.getBean("strRedisTemplate");
		System.out.println("set key1 value1");
		System.out.println("set key2 value2");
		redisTemplate.opsForValue().set("key1", "value1");
		redisTemplate.opsForValue().set("key2", "value2");
		String value1 = redisTemplate.opsForValue().get("key1");
		System.out.println("key1="+value1);
		System.out.println("del key1");
		redisTemplate.delete("key1");
		value1 = redisTemplate.opsForValue().get("key1");
		System.out.println("key1="+value1);
		System.out.println("getset key2");
		String oldValue2 = redisTemplate.opsForValue().getAndSet("key2", "new_value2");
		System.out.println("key2="+oldValue2);
		String value2 = redisTemplate.opsForValue().get("key2");
		System.out.println("key2="+value2);
		System.out.println("getrange key2 0 3");
		String rangeValue2 =  redisTemplate.opsForValue().get("key2", 0, 3);
		System.out.println("rangeKey2="+rangeValue2);
		System.out.println("append key2 _app");
		int newLen = redisTemplate.opsForValue().append("key2", "_app");
		System.out.println("newLen:"+newLen);
		String appendValue2 =  redisTemplate.opsForValue().get("key2");
		System.out.println("appendKey2="+appendValue2);
	}

}

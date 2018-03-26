package com.spring.redis.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

public class TestHash {

	public static void main(String[] args) {
		ApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
		RedisTemplate redisTemplate = (RedisTemplate) cxt.getBean("hashRedisTemplate");
		String key = "hash";
		Map<String, String>map = new HashMap<String, String>();
		map.put("key1", "value1");
		map.put("key2", "value2");
//		相当于 hmset key field1 value1 field2 value2
		redisTemplate.opsForHash().putAll(key, map);
		//相当于hset key field fieldvalue
		redisTemplate.opsForHash().put(key, "f3", "6");
		printValueForhash(redisTemplate,key,"f3");
		//hexists key field
		boolean exists = redisTemplate.opsForHash().hasKey(key, "f3");
		System.out.println(exists);
		//hgetall key
		Map keyAndValue = redisTemplate.opsForHash().entries(key);
		System.out.println(keyAndValue);
		//hincrby key field num
		redisTemplate.opsForHash().increment(key, "f3", 4);
		printValueForhash(redisTemplate,key,"f3");
		//hincrbyfloat key field num
		redisTemplate.opsForHash().increment(key, "f3", -2.5);
		printValueForhash(redisTemplate,key,"f3");
		//hvals key
		List vals = redisTemplate.opsForHash().values(key);
		System.out.println(vals);
		//hkeys key
		Set keys = redisTemplate.opsForHash().keys(key);
		System.out.println(keys);
		//hmget key field1 field2
		List<String>fieldList = new ArrayList<>();
		fieldList.add("key1");
		fieldList.add("key2");
		List valueList2 = redisTemplate.opsForHash().multiGet(key,fieldList);
		
		//hsetnx key newfield newfieldvalue不存在时再增加
		boolean success = redisTemplate.opsForHash().putIfAbsent(key, "f3", "3");
		System.out.println(success);
		success = redisTemplate.opsForHash().putIfAbsent(key, "f4", "hsetnx_value");
		System.out.println(success);
		//hdel key field1 field2
		Long result = redisTemplate.opsForHash().delete(key, "key1","key2");
		System.out.println(result);
	}
	private static void printValueForhash(RedisTemplate redisTemplate,String key,
			String field){
		//hget key field
		Object value = redisTemplate.opsForHash().get(key, field);
//		System.out.println(value.getClass());
		System.out.println(value);
	}
}

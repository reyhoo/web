package com.spring.redis.linklist;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

public class TestBList {
	/***
	 * 阻塞的链表操作
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext cxt = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		RedisTemplate redisTemplate = (RedisTemplate) cxt
				.getBean("hashRedisTemplate");
		printList(redisTemplate, "list1");
		printList(redisTemplate, "list2");
		System.out.println("del list1 list2");
		redisTemplate.delete("list1");
		redisTemplate.delete("list2");
		List<String> nodeList = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			nodeList.add("node" + i);
		}
		System.out.println("lpush list1 #{nodeList}");
		redisTemplate.opsForList().leftPushAll("list1", nodeList);
		printList(redisTemplate, "list1");
		// blpop list1 #{timeout}
		System.out.println("blpop list1 #{timeout}");
		redisTemplate.opsForList().leftPop("list1", 1, TimeUnit.SECONDS);
		// brpop list1 #{timeout}
		System.out.println("brpop list1 #{timeout}");
		redisTemplate.opsForList().rightPop("list1", 1, TimeUnit.SECONDS);
		printList(redisTemplate, "list1");
		nodeList.clear();
		for (int i = 1; i <= 3; i++) {
			nodeList.add("data" + i);
		}
		// lpush list2 #{nodeList}
		System.out.println("lpush list2 #{nodeList}");
		redisTemplate.opsForList().leftPushAll("list2", nodeList);
		printList(redisTemplate, "list1");
		printList(redisTemplate, "list2");
		// rpoplpush list1 list2
		System.out.println("rpoplpush list1 list2");
		redisTemplate.opsForList().rightPopAndLeftPush("list1", "list2");
		System.out.println("brpoplpush list1 list2 #{timeout}");
		redisTemplate.opsForList().rightPopAndLeftPush("list1", "list2", 1,
				TimeUnit.SECONDS);
		printList(redisTemplate, "list1");
		printList(redisTemplate, "list2");
	}

	static void printList(RedisTemplate redisTemplate, String key) {
		Long size = redisTemplate.opsForList().size(key);
		// lrange key start end 包含start和end
		List valueList = redisTemplate.opsForList().range(key, 0, size);// 严格意义上讲这里应该是size-1
		System.out.println(valueList);
	}
}

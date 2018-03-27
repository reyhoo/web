package com.spring.redis.pf;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Isolation;

/***
 * »ùÊý
 * @author Administrator
 *
 */
public class TestHyperLogLog {

	public static void main(String[] args) {
		ApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
		RedisTemplate redisTemplate =  (RedisTemplate) cxt.getBean("hashRedisTemplate");
		redisTemplate.opsForHyperLogLog().add("HyperLogLog", "a","b","c","d","a");
		redisTemplate.opsForHyperLogLog().add("HyperLogLog2", "a");
		redisTemplate.opsForHyperLogLog().add("HyperLogLog2", "z");
		Long size = redisTemplate.opsForHyperLogLog().size("HyperLogLog");
		System.out.println(size);
		size = redisTemplate.opsForHyperLogLog().size("HyperLogLog2");
		System.out.println(size);
		redisTemplate.opsForHyperLogLog().union("des_key", "HyperLogLog","HyperLogLog2");
		size = redisTemplate.opsForHyperLogLog().size("des_key");
		System.out.println(size);
	}
}

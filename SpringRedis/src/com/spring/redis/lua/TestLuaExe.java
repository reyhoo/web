package com.spring.redis.lua;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import redis.clients.jedis.Jedis;

public class TestLuaExe {

	public static void main(String[] args) {
		ApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
		RedisTemplate redisTemplate = (RedisTemplate) cxt.getBean("hashRedisTemplate");
		Jedis jedis = (Jedis) redisTemplate.getConnectionFactory().getConnection().getNativeConnection();
		System.out.println(jedis.eval("return 'hellojava'"));
		jedis.eval("redis.call('set',KEYS[1],ARGV[1])", 1, "lua-key","lua-valuej");
		System.out.println(jedis.get("lua-key"));
		String sha = jedis.scriptLoad("redis.call('set',KEYS[1],ARGV[1])");
		System.out.println(sha);
		jedis.evalsha(sha,1,"sha-key","sha-valuej");
		System.out.println(jedis.get("sha-key"));
		jedis.close();
	}
}

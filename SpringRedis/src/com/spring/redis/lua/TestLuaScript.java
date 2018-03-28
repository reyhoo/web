package com.spring.redis.lua;

import org.apache.tools.ant.types.CommandlineJava.SysProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import redis.clients.jedis.Jedis;

public class TestLuaScript {
	
	/**
	 * 用lua脚本语言执行redis操作
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
		RedisTemplate redisTemplate = (RedisTemplate) cxt.getBean("hashRedisTemplate");
		Jedis jedis = (Jedis) redisTemplate.getConnectionFactory().getConnection().getNativeConnection();
		//执行简单脚本
		String hellojava = (String) jedis.eval("return 'hello java'");
		System.out.println(hellojava);
		//执行带参数的脚本
		Object o = jedis.eval("redis.call('set',KEYS[1],ARGV[1])", 1, "lua-key","lua-value-spring");
		String luaKey = jedis.get("lua-key");
		System.out.println(luaKey);
		//缓存脚本，返回sha1签名标识
		String sha1 = jedis.scriptLoad("redis.call('set',KEYS[1],ARGV[1])");
		System.out.println(sha1);
		//通过标识执行脚本
		jedis.evalsha(sha1, 1, "sha-key","sha-value");
		//获取执行脚本后的数据
		String shaVal = jedis.get("sha-key");
		System.out.println(shaVal);
		jedis.close();
	}

}

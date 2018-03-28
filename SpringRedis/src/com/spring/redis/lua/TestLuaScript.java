package com.spring.redis.lua;

import org.apache.tools.ant.types.CommandlineJava.SysProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import redis.clients.jedis.Jedis;

public class TestLuaScript {
	
	/**
	 * ��lua�ű�����ִ��redis����
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
		RedisTemplate redisTemplate = (RedisTemplate) cxt.getBean("hashRedisTemplate");
		Jedis jedis = (Jedis) redisTemplate.getConnectionFactory().getConnection().getNativeConnection();
		//ִ�м򵥽ű�
		String hellojava = (String) jedis.eval("return 'hello java'");
		System.out.println(hellojava);
		//ִ�д������Ľű�
		Object o = jedis.eval("redis.call('set',KEYS[1],ARGV[1])", 1, "lua-key","lua-value-spring");
		String luaKey = jedis.get("lua-key");
		System.out.println(luaKey);
		//����ű�������sha1ǩ����ʶ
		String sha1 = jedis.scriptLoad("redis.call('set',KEYS[1],ARGV[1])");
		System.out.println(sha1);
		//ͨ����ʶִ�нű�
		jedis.evalsha(sha1, 1, "sha-key","sha-value");
		//��ȡִ�нű��������
		String shaVal = jedis.get("sha-key");
		System.out.println(shaVal);
		jedis.close();
	}

}

package com.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class TestRedis {

	public static void main(String[] args) {
		
		Jedis jedis = new Jedis("localhost", 6379);
		int i = 0;
		try{
			long start = System.currentTimeMillis();
			while(true){
				long end = System.currentTimeMillis();
				if(end - start >= 1000){
					break;
				}
				i ++;
				jedis.set("test"+i, i+"");
			}
		}finally{
			jedis.close();
		}
		System.out.println("redis每秒操作:"+i+"次");
		testJedisPool();
	}
	static void testJedisPool(){
		JedisPoolConfig poolCfg = new JedisPoolConfig();
		//最大空闲数
		poolCfg.setMaxIdle(50);
		//最大连接数
		poolCfg.setMaxTotal(100);
		//最大等待毫秒数
		poolCfg.setMaxWaitMillis(20000);
		
		JedisPool jedisPool = new JedisPool(poolCfg,"localhost");
		
		Jedis jedis = jedisPool.getResource();
		
		jedis.set("name", "姚磊");
		jedisPool.close();
	}
}

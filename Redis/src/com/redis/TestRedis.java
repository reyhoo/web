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
		System.out.println("redisÿ�����:"+i+"��");
		testJedisPool();
	}
	static void testJedisPool(){
		JedisPoolConfig poolCfg = new JedisPoolConfig();
		//��������
		poolCfg.setMaxIdle(50);
		//���������
		poolCfg.setMaxTotal(100);
		//���ȴ�������
		poolCfg.setMaxWaitMillis(20000);
		
		JedisPool jedisPool = new JedisPool(poolCfg,"localhost");
		
		Jedis jedis = jedisPool.getResource();
		
		jedis.set("name", "Ҧ��");
		jedisPool.close();
	}
}

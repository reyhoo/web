package com.spring.redis.pipelined;

import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

public class TestJavaAPI {

	public static void main(String[] args) {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxIdle(50);
		config.setMaxTotal(100);
		config.setMaxWaitMillis(20000);
		JedisPool jedisPool = new JedisPool(config, "localhost");
		Jedis jedis = jedisPool.getResource();
		long start = System.currentTimeMillis();
		Pipeline pipeline = jedis.pipelined();
		for (int i = 0; i < 100000; i++) {
			int j = i+1;
			Response<String> d = pipeline.set("pipeline_key_"+j, "pipeline_value_"+j);
			Response<String> a = pipeline.get("pipeline_key_"+j);
		}
		List<Object> result = pipeline.syncAndReturnAll();
		long end = System.currentTimeMillis();
		System.out.println(end-start);
//		System.out.println(result);
	}
}

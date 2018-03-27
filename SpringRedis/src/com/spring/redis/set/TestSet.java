package com.spring.redis.set;

import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

public class TestSet {

	/**
	 * 127.0.0.1:6379> sadd set1 v1 v2 v3 v4 v5 v6
		(integer) 6
		127.0.0.1:6379> sadd set2 v2 v4 v6 v8
		(integer) 4
		127.0.0.1:6379> sdiffsore diff_set set1 set2
		(error) ERR unknown command 'sdiffsore'
		127.0.0.1:6379> sdiffstore diff_set set1 set2
		(integer) 3
		127.0.0.1:6379> smemebers diff_set
		(error) ERR unknown command 'smemebers'
		127.0.0.1:6379> smembers diff_set
		1) "v1"
		2) "v5"
		3) "v3"
		127.0.0.1:6379> sunionstore union_set set1 set2
		(integer) 7
		127.0.0.1:6379> smembers union_set
		1) "v6"
		2) "v1"
		3) "v4"
		4) "v2"
		5) "v8"
		6) "v3"
		7) "v5"
		127.0.0.1:6379> sinterstore inter_set set1 set2
		(integer) 3
		127.0.0.1:6379> smembers inter_set
		1) "v4"
		2) "v2"
		3) "v6"
	 * @param args
	 */
	
	public static void main(String[] args) {
		ApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
		RedisTemplate redisTemplate = (RedisTemplate) cxt.getBean("hashRedisTemplate");
		Set set = null;
		redisTemplate.delete("set1");
		redisTemplate.delete("set2");
		System.out.println("sadd set1 v1 v2 v3 v4 v5 v6");
		redisTemplate.boundSetOps("set1").add("v1","v2","v3","v4","v5","v6");
		System.out.println("sadd set2 v0 v2 v4 v6 v8");
		redisTemplate.boundSetOps("set2").add("v0","v2","v4","v6","v8");
		Long size1 = redisTemplate.opsForSet().size("set1");
		System.out.println("size1:"+size1);
		set = redisTemplate.opsForSet().difference("set1", "set2");
		System.out.println("sdiff set1 set2 \nset:"+set);
		set = redisTemplate.opsForSet().intersect("set1", "set2");
		System.out.println("sinter set1 set2 \nset:"+set);
		boolean exists = redisTemplate.opsForSet().isMember("set1", "v1");
		System.out.println("sismember set1 v1\n"+exists);
		set = redisTemplate.opsForSet().members("set1");
		System.out.println("smembers set1\nset:"+set);
		System.out.println("spop set1");
		//弹出，集合会少一个元素
		String val = (String) redisTemplate.opsForSet().pop("set1");
		System.out.println(val);
		//获取，集合不变
		System.out.println("srandmember set1");
		val = (String) redisTemplate.opsForSet().randomMember("set1");
		System.out.println(val);
		System.out.println("srandmember set1 2");
		List list = redisTemplate.opsForSet().randomMembers("set1",2);
		System.out.println(list);
		System.out.println("srem set1 v1");
		Long removedCount = redisTemplate.opsForSet().remove("set1", "v1","v100");
		System.out.println("removedCount:"+removedCount);
		set = redisTemplate.opsForSet().members("set1");
		System.err.println("smembers set1\nset:"+set);
		set = redisTemplate.opsForSet().members("set2");
		System.err.println("smembers set2\nset:"+set);
		set = redisTemplate.opsForSet().union("set1", "set2");
		System.out.println("sunion set1 set2\nset:"+set);
		set = redisTemplate.opsForSet().members("set1");
		System.err.println("smembers set1\nset:"+set);
		set = redisTemplate.opsForSet().members("set2");
		System.err.println("smembers set2\nset:"+set);
		long diffSize = redisTemplate.opsForSet().differenceAndStore("set1", "set2", "diff_set");
		System.out.println("sdiffstore diff_set set1 set2\ndiffSize:"+diffSize);
		set = redisTemplate.opsForSet().members("set1");
		System.err.println("smembers set1\nset:"+set);
		set = redisTemplate.opsForSet().members("set2");
		System.err.println("smembers set2\nset:"+set);
		set = redisTemplate.opsForSet().members("diff_set");
		System.out.println("smembers diff_set\ndiff_set:"+set);

		System.out.println("=================================");
		Long interSize = redisTemplate.opsForSet().intersectAndStore("set1", "set2", "inter_set");
		System.out.println("sinterstore inter_set set1 set2\ninterSize:"+interSize);
		set = redisTemplate.opsForSet().members("set1");
		System.err.println("smembers set1\nset:"+set);
		set = redisTemplate.opsForSet().members("set2");
		System.err.println("smembers set2\nset:"+set);
		set = redisTemplate.opsForSet().members("inter_set");
		System.out.println("smembers inter_set\ninter_set:"+set);
		
		
		System.out.println("=================================");
		Long unionSize = redisTemplate.opsForSet().unionAndStore("set1", "set2", "union_set");
		System.out.println("sunionstore union_set set1 set2 \nunionSize:"+unionSize);
		set = redisTemplate.opsForSet().members("set1");
		System.err.println("smembers set1\nset:"+set);
		set = redisTemplate.opsForSet().members("set2");
		System.err.println("smembers set2\nset:"+set);
		set = redisTemplate.opsForSet().members("union_set");
		System.out.println("smembers union_set\nunion_set:"+set);
	}
}

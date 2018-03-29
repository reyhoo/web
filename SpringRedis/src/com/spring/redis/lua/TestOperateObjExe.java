package com.spring.redis.lua;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;

import com.spring.redis.pojo.Role;

public class TestOperateObjExe {

	
	public static void main(String[] args) {
		ApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
		RedisTemplate redisTemplate = (RedisTemplate) cxt.getBean("redisTemplate");
		DefaultRedisScript<Role> redisScript = new DefaultRedisScript<>();
		redisScript.setResultType(Role.class);
		redisScript.setScriptText("redis.call('set',KEYS[1],ARGV[1]) return redis.call('get',KEYS[1])");
		String sha1 = redisScript.getSha1();
		List<String>keyList = new ArrayList<>();
		keyList.add("role1");
		Role role = new Role();
		role.setId(1l);
		role.setRoleName("role_name_1");
		role.setNote("note_1");
		Role role1 = (Role) redisTemplate.execute(redisScript, keyList, role);
		System.out.println(role1==role);
		System.out.println(role1);
	}
}

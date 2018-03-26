package com.spring.redis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;

import com.spring.redis.pojo.Role;

public class TestMain {

	public static void main(String[] args) {
		ApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
		RedisTemplate redisTemplate = cxt.getBean(RedisTemplate.class);
		final Role role = new Role();
		role.setId(1l);
		role.setRoleName("role_name_1");
		role.setNote("note_1");
		//以下两个操作有可能来自于同一个Redis连接池的不同Redis连接
//		redisTemplate.opsForValue().set("role_1", role);
//		Role role1 = (Role) redisTemplate.opsForValue().get("role_1");
//		System.out.println(role1);
		
		//这样操作可能保证连接是同一个Redis连接池的同一个Redis连接，后面在操作多个命令或者事务时常常用到它
		SessionCallback<Role> callBack = new SessionCallback<Role>() {

			@Override
			public  Role execute(RedisOperations ops)
					throws DataAccessException {
				ops.boundValueOps((String) "role_1").set((Role) role);
				return (Role) ops.boundValueOps((String) "role_1").get();
			}
		};
		Role saveRole = (Role) redisTemplate.execute(callBack);
		System.out.println(saveRole);
	}
}

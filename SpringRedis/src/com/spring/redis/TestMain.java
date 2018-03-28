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
		RedisTemplate redisTemplate = (RedisTemplate) cxt.getBean("redisTemplate");
		final Role role = new Role();
		role.setId(1l);
		role.setRoleName("role_name_1");
		role.setNote("note_1");
		//�������������п���������ͬһ��Redis���ӳصĲ�ͬRedis����
//		redisTemplate.opsForValue().set("role_1", role);
//		Role role1 = (Role) redisTemplate.opsForValue().get("role_1");
//		System.out.println(role1);
		
		//�����������ܱ�֤������ͬһ��Redis���ӳص�ͬһ��Redis���ӣ������ڲ�����������������ʱ�����õ���
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

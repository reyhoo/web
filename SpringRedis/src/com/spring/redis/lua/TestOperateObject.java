package com.spring.redis.lua;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

import com.spring.redis.pojo.Role;

public class TestOperateObject {

	public static void main(String[] args) {
		ApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
		RedisTemplate redisTemplate = (RedisTemplate) cxt.getBean("redisTemplate");
		//����Ĭ�Ͻű���װ��
		DefaultRedisScript<Role> redisScript = new DefaultRedisScript<>();
		//���ýű�
		redisScript.setScriptText("redis.call('set',KEYS[1],ARGV[1]) return redis.call('get',KEYS[1])");
		List<String>keylist = new ArrayList<>();
		keylist.add("role1");
		//��Ҫ���л�����Ͷ�ȡ�Ķ���
		Role role = new Role();
		role.setId(1l);
		role.setRoleName("role_name_1");
		role.setNote("note_1");
		//��ñ�ʶ�ַ���
		String sha1 = redisScript.getSha1();
		System.out.println(sha1);
		//���÷��ؽ�����ͣ����û����仰���������Ϊ��
		redisScript.setResultType(Role.class);
		//�������л���
		JdkSerializationRedisSerializer serializer = new JdkSerializationRedisSerializer();
		//��һ����RedisScript�ӿڶ��󣬵ڶ����ǲ������л������������ǽ�����л�����
		//���ĸ���Redis��key�б�����ǲ����б�
//		Role obj = (Role) redisTemplate.execute(redisScript,serializer,serializer, keylist, role);
		//��Ϊ��������redisTemplate��ʼ����ʱ��������valueSerializer��JdkSerializationRedisSerializer��
		//����������Բ��ô�
		Role obj = (Role) redisTemplate.execute(redisScript, keylist, role);
		System.out.println(obj);
	}
}

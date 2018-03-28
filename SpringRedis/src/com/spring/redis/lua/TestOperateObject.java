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
		//定义默认脚本封装类
		DefaultRedisScript<Role> redisScript = new DefaultRedisScript<>();
		//设置脚本
		redisScript.setScriptText("redis.call('set',KEYS[1],ARGV[1]) return redis.call('get',KEYS[1])");
		List<String>keylist = new ArrayList<>();
		keylist.add("role1");
		//需要序列化保存和读取的对象
		Role role = new Role();
		role.setId(1l);
		role.setRoleName("role_name_1");
		role.setNote("note_1");
		//获得标识字符串
		String sha1 = redisScript.getSha1();
		System.out.println(sha1);
		//设置返回结果类型，如果没有这句话，结果返回为空
		redisScript.setResultType(Role.class);
		//定义序列化器
		JdkSerializationRedisSerializer serializer = new JdkSerializationRedisSerializer();
		//第一个是RedisScript接口对象，第二个是参数序列化器，第三个是结果序列化器；
		//第四个是Redis的key列表，最后是参数列表
//		Role obj = (Role) redisTemplate.execute(redisScript,serializer,serializer, keylist, role);
		//因为在配置中redisTemplate初始化的时间设置了valueSerializer是JdkSerializationRedisSerializer，
		//所以这里可以不用传
		Role obj = (Role) redisTemplate.execute(redisScript, keylist, role);
		System.out.println(obj);
	}
}

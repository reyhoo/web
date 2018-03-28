package com.spring.redis.timeout;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.model.ThemesTable.ThemeElement;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;

public class TestTimeout {

	public static void main(String[] args) {
		ApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
		RedisTemplate redisTemplate =  (RedisTemplate) cxt.getBean("hashRedisTemplate");
		redisTemplate.execute(new SessionCallback() {

			@Override
			public Object execute(RedisOperations ops)
					throws DataAccessException {
				//设置值
				ops.boundValueOps("key1").set("value1");
				//获取值
				String keyValue = (String) ops.boundValueOps("key1").get();
				System.out.println(keyValue);
				//获取超时时间没超时是-1，不存在或者已经超时是-2
				Long expireKey = ops.getExpire("key1");
				System.out.println(expireKey);
				boolean b = false;
				//设置超时时间为120秒
				b = ops.expire("key1", 120l, TimeUnit.SECONDS);
				System.out.println(b);
				System.out.println(ops.getExpire("key1"));
				//取消超时时间，持久化
				b = ops.persist("key1");
				System.out.println(b);
				Long l = ops.getExpire("key1");
				System.out.println(l);
				long now = System.currentTimeMillis();
				Date date = new Date();
				date.setTime(now+120000);
				//设置超时到某个时间点
				ops.expireAt("key1", date);
				return null;
			}
		});
	}
}

package com.mybatis.cache.main;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.mybatis.cache.mapper.UserMapper;
import com.mybatis.cache.pojo.SexEnum;
import com.mybatis.cache.pojo.User;
import com.mybatis.cache.utils.SqlSessionFactoryUtils;

public class TestSessionFactoryCache {

	static Logger logger = Logger.getLogger(TestSessionFactoryCache.class);
	public static void main(String[] args) {
		SqlSession session1 = SqlSessionFactoryUtils.openSession();
		UserMapper userMapper1 = session1.getMapper(UserMapper.class);
		SqlSession session2 = SqlSessionFactoryUtils.openSession();
		UserMapper userMapper2 = session2.getMapper(UserMapper.class);
		logger.debug(userMapper1.findById(1003l));
		session1.commit();
	
		logger.debug("相同sqlsession再获取一次。。。。。。");
		logger.debug(userMapper1.findById(1003l));
		logger.debug("不同sqlsession再获取一次。。。。。。");
		logger.debug(userMapper2.findById(1003l));
		session2.commit();
	}
	
	
	static void insertData() {
		SqlSession session = SqlSessionFactoryUtils.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		try {

			for (int i = 0; i < 1000; i++) {
				User user = new User();
				user.setEmail("user" + (i + 1) + "@163.com");
				user.setMobile("151" + (i + 1));
				user.setNote("user" + (i + 1) + "notenotenote");
				user.setRealName("user" + (i + 1) + ".yao");
				SexEnum sex = i % 2 == 0 ? SexEnum.FEMALE : SexEnum.MALE;
				user.setSex(sex);
				user.setUserName("user" + (i + 1));
				userMapper.insertUser(user);
			}
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
	}
}

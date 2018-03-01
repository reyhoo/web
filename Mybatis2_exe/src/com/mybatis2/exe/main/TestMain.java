package com.mybatis2.exe.main;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis2.exe.mapper.UserMapper;
import com.mybatis2.exe.pojo.SexEnum;
import com.mybatis2.exe.pojo.User;
import com.mybatis2.exe.utils.SqlSessionFactoryUtils;

public class TestMain {

	
	public static void main(String[] args) {
		
		SqlSession session = SqlSessionFactoryUtils.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		
		
//		User user = userMapper.getById(1l);
//		System.out.println(user);
		
//		userMapper.delete(2l);
//		session.commit();
		
		
//		User user = new User();
//		user.setSex(SexEnum.MALE);
//		user.setUserName("Ò¦ÀÚ");
//		userMapper.insert(user);
//		user = new User();
//		user.setSex(SexEnum.FEMALE);
//		user.setUserName("lucy");
//		userMapper.insert(user);
//		session.commit();
//		List<User> list = userMapper.findAll();
		List<User> list = userMapper.findByName("lily");
		System.out.println(list);
		
		
		
		list.get(0).setUserName("Îº±ÌÔÆ");
		userMapper.update(list.get(0));
		session.commit();
	}
}

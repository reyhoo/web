package com.mybatis2.exe.main;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis2.exe.mapper.FileMapper;
import com.mybatis2.exe.mapper.UserMapper;
import com.mybatis2.exe.pojo.TestFile;
import com.mybatis2.exe.pojo.User;
import com.mybatis2.exe.utils.SqlSessionFactoryUtils;

public class TestMain {

	
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		SqlSession session = SqlSessionFactoryUtils.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		FileMapper fileMapper = session.getMapper(FileMapper.class);
		
		
//		User user = userMapper.getById(1l);
//		System.out.println(user);
		
//		userMapper.delete(2l);
//		session.commit();
		
		
//		User user = new User();
//		user.setSex(SexEnum.MALE);
//		user.setUserName("姚磊");
//		userMapper.insert(user);
//		user = new User();
//		user.setSex(SexEnum.FEMALE);
//		user.setUserName("lucy");
//		userMapper.insert(user);
//		session.commit();
//		List<User> list = userMapper.findAll();
		List<User> list = userMapper.findByName("l");
		System.out.println(list);
		
		
		
//		list.get(0).setUserName("魏碧云");
//		userMapper.update(list.get(0));
//		session.commit();
		
//		TestFile file = new TestFile();
//		try {
//			file.content = "中华人民共和国".getBytes("utf-8");
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		fileMapper.insertFile(file);
//		session.commit();
		System.out.println(fileMapper.getFile(1l).id);
		System.out.println(new String(fileMapper.getFile(1l).content,"utf-8"));
	}
}

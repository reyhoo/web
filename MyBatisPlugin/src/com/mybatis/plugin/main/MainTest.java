package com.mybatis.plugin.main;

import org.apache.commons.codec.binary.Base64;
import org.apache.ibatis.session.SqlSession;

import com.mybatis.plugin.mapper.UserMapper;
import com.mybatis.plugin.pojo.SexEnum;
import com.mybatis.plugin.pojo.User;
import com.mybatis.plugin.utils.SqlSessionFactoryUtils;

public class MainTest {

	
	public static void main(String[] args) {
//		SqlSession session = SqlSessionFactoryUtils.openSession();
//		UserMapper userMapper = session.getMapper(UserMapper.class);
//		PageParam pageParam = new PageParam();
//		List<User> list = userMapper.findAll(pageParam);
//		System.out.println(list.size());
		
		
//		SqlSession session = SqlSessionFactoryUtils.openSession();
//		UserMapper userMapper = session.getMapper(UserMapper.class);
//		PageParams pageParam = new PageParams();
//		pageParam.setPage(1);
//		pageParam.setPageSize(5);
//		pageParam.setCleanOrderBy(true);
//		List<User> list = userMapper.findWithCondition(200l, 1l, pageParam);
//		System.out.println(list.size());
//		System.out.println(list);
//		System.out.println(pageParam.getTotalPage());
		Base64 base64 = new Base64();
		String encode = base64.encodeToString("中华人民共和国".getBytes());
		System.out.println(encode);
		System.out.println(Base64.encodeBase64String("中华人民共和国".getBytes()));
		byte[] data = Base64.decodeBase64(encode);
		System.out.println(new String(base64.decode(encode)));
		System.out.println(new String(data));
	}
	
	
	static void insertData(){
		SqlSession session = SqlSessionFactoryUtils.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		try {
			
			for (int i = 0; i < 1000; i++) {
				User user = new User();
				user.setEmail("user"+(i + 1)+"@163.com");
				user.setMobile("151"+(i + 1));
				user.setNote("user"+(i + 1)+"notenotenote");
				user.setRealName("user"+(i + 1)+".yao");
				SexEnum sex = i % 2 ==0?SexEnum.FEMALE:SexEnum.MALE;
				user.setSex(sex);
				user.setUserName("user"+(i + 1));
				userMapper.addUser(user);
			}
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally{
			session.close();
		}
	}
}


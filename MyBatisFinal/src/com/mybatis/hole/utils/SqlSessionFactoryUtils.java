package com.mybatis.hole.utils;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryUtils {

	private static final Class<SqlSessionFactoryUtils> LOCK = SqlSessionFactoryUtils.class;
	private static SqlSessionFactory instance;
	
	public static SqlSessionFactory getSqlSessionFactory(){
		if(instance == null){
			synchronized (LOCK) {
				if(instance == null){
					try {
						instance = new SqlSessionFactoryBuilder().build(LOCK.getResourceAsStream("/mybatis-config.xml"));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		return instance;
	}
	
	public static SqlSession openSession(){
		return getSqlSessionFactory().openSession();
	}
}

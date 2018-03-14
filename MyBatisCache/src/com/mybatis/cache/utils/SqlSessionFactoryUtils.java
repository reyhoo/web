package com.mybatis.cache.utils;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryUtils {

	
	private static Class<SqlSessionFactoryUtils> LOCK = SqlSessionFactoryUtils.class;
	private static SqlSessionFactory sqlSessionFactory;
	
	public static SqlSessionFactory getSqlSessionFactory() {
		if(sqlSessionFactory == null){
			synchronized (LOCK) {
				if(sqlSessionFactory == null){
					sqlSessionFactory = new SqlSessionFactoryBuilder().build(LOCK.getResourceAsStream("/mybatis-config.xml"));
				}
			}
		}
		
		return sqlSessionFactory;
	}
	
	public static SqlSession openSession(){
		return getSqlSessionFactory().openSession();
	}
}

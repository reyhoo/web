package com.mybatis.cascade.exe.utils;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryUtils {

	private static final Class<SqlSessionFactoryUtils> LOCK = 
			SqlSessionFactoryUtils.class;
	private static SqlSessionFactory sSqlSessionFactory;
	
	public static SqlSessionFactory getSqlSessionFactory(){
		if(sSqlSessionFactory == null){
			synchronized (LOCK) {
				if(sSqlSessionFactory == null){
					try {
						sSqlSessionFactory = 
								new SqlSessionFactoryBuilder().build(LOCK.getResourceAsStream("/mybatis-config.xml"));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return sSqlSessionFactory;
	}
	
	public static SqlSession openSession(){
		return getSqlSessionFactory().openSession();
	}
}

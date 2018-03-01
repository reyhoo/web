package com.mybatis2.exe.utils;

import org.apache.ibatis.session.SqlSessionFactory;

public class SqlSessionFactoryUtils {

	
	private static final Class<SqlSessionFactoryUtils> LOCK = SqlSessionFactoryUtils.class;
	
	private static SqlSessionFactory sSqlSessionFactory;
	
	public static SqlSessionFactory getSqlSessionFactory(){
		if(sSqlSessionFactory == null){
			synchronized (LOCK) {
				if(sSqlSessionFactory == null){
					
				}
			}
		}
		
		return sSqlSessionFactory;
	}
	
}

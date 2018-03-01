package com.mybatis2.exe.utils;

import java.util.Properties;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryUtils {

	
	private static final Class<SqlSessionFactoryUtils> LOCK = SqlSessionFactoryUtils.class;
	
	private static SqlSessionFactory sSqlSessionFactory;
	
	public static SqlSessionFactory getSqlSessionFactory(){
		if(sSqlSessionFactory == null){
			synchronized (LOCK) {
				if(sSqlSessionFactory == null){
					String configFile = "/mybatis-config.xml";
					String proFile = "/jdbc.properties";
					try{
						Properties properties = new Properties();
						properties.load(LOCK.getResourceAsStream(proFile));
						sSqlSessionFactory = new SqlSessionFactoryBuilder().build(LOCK.getResourceAsStream(configFile), properties);
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		}
		
		return sSqlSessionFactory;
	}
	
	public static SqlSession openSession(){
		try {
			return getSqlSessionFactory().openSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}

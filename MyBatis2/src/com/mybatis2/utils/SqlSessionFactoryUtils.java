package com.mybatis2.utils;

import java.util.Properties;

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
					String propertiesFile = "/jdbc.properties";
					Properties properties = new Properties();
					
					try{
						properties.load(LOCK.getResourceAsStream(propertiesFile));
						
						sSqlSessionFactory = new SqlSessionFactoryBuilder().build(LOCK.getResourceAsStream(configFile),properties);
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		}
		return sSqlSessionFactory;
	}
	public static void main(String[] args) {
		System.out.println(getSqlSessionFactory().openSession().selectOne("getRole",1l));
		System.out.println(getSqlSessionFactory());
		System.out.println(getSqlSessionFactory());
	}
}

package com.yaolei.mybatis.utils;

import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryUtils {

	private static final Class<SqlSessionFactoryUtils> LOCK = SqlSessionFactoryUtils.class;

	private static SqlSessionFactory sSqlSessionFactory;

	private SqlSessionFactoryUtils(){}
	public static SqlSessionFactory getSqlSessionFactory() {
		if (sSqlSessionFactory == null) {
			synchronized (LOCK) {
				if (sSqlSessionFactory == null) {
					String resource = "/mybatis-config.xml";
					InputStream in = null;
					try {
						in = SqlSessionFactoryUtils.class
								.getResourceAsStream(resource);
						sSqlSessionFactory = new SqlSessionFactoryBuilder()
								.build(in);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			}
		}
		return sSqlSessionFactory;
	}
	
	public static SqlSession openSqlSession(){
		try {
			return getSqlSessionFactory().openSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(getSqlSessionFactory());
		System.out.println(getSqlSessionFactory());
		System.out.println(getSqlSessionFactory());
		System.out.println(getSqlSessionFactory());
		System.out.println(getSqlSessionFactory());
		System.out.println(getSqlSessionFactory());
	}
}

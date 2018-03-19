package com.spring.mybatis.trans.exe.pojo;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DataSourceBean {
	@Value("${database.url}")
	private String url;
	@Value("${database.driver}")
	private String driver;
	@Value("${database.username}")
	private String username;
	@Value("${database.password}")
	private String password;
	@Bean(name="dataSource")
	public DataSource getDataSource(){
		Properties prop = new Properties();
		prop.put("url", url);
		prop.put("driverClassName", driver);
		prop.put("username", username);
		prop.put("password", password);
		try {
			return BasicDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

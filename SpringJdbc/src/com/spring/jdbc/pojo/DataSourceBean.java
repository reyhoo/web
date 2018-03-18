package com.spring.jdbc.pojo;

import java.sql.Driver;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Component;
@Component
public class DataSourceBean {
	
	@Value("${database.url}")
	private String url;
	@Value("${database.driver}")
	private String driver;
	@Value("${database.password}")
	private String password;
	@Value("${database.username}")
	private String username;
	
	@Bean(name="simpleDataSource")
	public DataSource getDataSource1(){
		SimpleDriverDataSource dataSource = null;
		dataSource = new SimpleDriverDataSource();
		try {
			dataSource.setDriverClass((Class<? extends Driver>) Class.forName(driver));
			dataSource.setPassword(password);
			dataSource.setUrl(url);
			dataSource.setUsername(username);
		} catch (Exception e) {
			e.printStackTrace();
			dataSource = null;
		}
		return dataSource;
	}
	@Bean(name="dbcpDataSource")
	public DataSource getDataSource2(){
		DataSource dataSource = null;
		Properties prop = new Properties();
		prop.put("url", url);
		prop.put("driverClassName", driver);
		prop.put("username", username);
		prop.put("password", password);
		try {
			dataSource = BasicDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataSource;
	}
}

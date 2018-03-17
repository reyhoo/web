package com.spring.aop.aspect.jdbc.pojo;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.embedded.DataSourceFactory;
import org.springframework.stereotype.Component;
@Component
public class DataSourceBean{
	
	@Value("${database.url}")
	private String url;
	@Value("${database.driver}")
	private String driver;
	@Value("${database.password}")
	private String password;
	@Value("${database.username}")
	private String username;
	@Bean(name={"dataS"})
	public DataSource getDataSource(){
		Properties prop = new Properties();
		prop.put("username", username);
		prop.put("password", password);
		prop.put("driver", driver);
		prop.put("url", url);
		try {
			return BasicDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
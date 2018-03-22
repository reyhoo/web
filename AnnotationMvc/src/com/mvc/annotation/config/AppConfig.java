package com.mvc.annotation.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan(basePackages = "com.mvc.annotation")
@ImportResource("/WEB-INF/config/applicationContext.xml")
public class AppConfig {

	@Value("${database.username}")
	private String username;
	@Value("${database.password}")
	private String password;
	@Value("${database.url}")
	private String url;
	@Value("${database.driver}")
	private String driver;

	private DataSource dataSource;

	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		if (dataSource != null) {
			return dataSource;
		}
		Properties prop = new Properties();
		prop.put("username", username);
		prop.put("password", password);
		prop.put("driverClassName", driver);
		prop.put("url", url);
		try {
			dataSource = BasicDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataSource;
	}
}

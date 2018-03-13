package com.spring.ass.exe.annotation.pojo;


import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DataSourceBean {

	@Value("${jdbc.database.url}")
	private String url;
	@Value("${jdbc.database.username}")
	private String username;
	@Value("${jdbc.database.password}")
	private String password;
	@Value("${jdbc.database.driver}")
	private String driver;
	
	@Bean(name={"dataSource1","dataSource"})
	public DataSource getDataSource(){
		Properties prop = new Properties();
		prop.put("username", new String(Base64.decodeBase64(username)));
		prop.put("url", new String(Base64.decodeBase64(url)));
		prop.put("password", new String(Base64.decodeBase64(password)));
		prop.put("driver", new String(Base64.decodeBase64(driver)));
		try {
			return BasicDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

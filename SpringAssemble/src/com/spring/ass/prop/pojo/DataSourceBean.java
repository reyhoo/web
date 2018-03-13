package com.spring.ass.prop.pojo;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DataSourceBean {

	@Value("${jdbc.database.driver}")
	private String driver = null;
	@Value("${jdbc.database.url}")
	private String url = null;
	@Value("${jdbc.database.username}")
	private String username = null;
	@Value("${jdbc.database.password}")
	private String password=null;
	
	@Bean(name="dataSource")
	public DataSource getDataSource(){
		Properties prop = new Properties();
		prop.put("driver", driver);
		prop.put("url", url);
		prop.put("username", username);
		prop.put("password", password);
		DataSource dataSource = null;
		try {
			dataSource = BasicDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataSource;
	}
	
}

package com.spring.jdbc.trans.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;


@ComponentScan(basePackages="com.spring.jdbc.trans")
@Configuration
@EnableTransactionManagement
@PropertySource(value={"db.properties"})
public class JavaConfig implements TransactionManagementConfigurer{

	
	private DataSource dataSource;
	
	
	
	@Value("${database.url}")
	private String url;
	@Value("${database.driver}")
	private String driver;
	@Value("${database.password}")
	private String password;
	@Value("${database.username}")
	private String username;
	
	
	@Bean(name="dataSource")
	public DataSource initDataSource(){
		if(dataSource != null){
			return dataSource;
		}
		Properties prop = new Properties();
		prop.put("driverClassName", driver);
		prop.put("url", url);
		prop.put("password", password);
		prop.put("username", username);
		try {
			dataSource = BasicDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataSource;
		
	}
	
	
	@Bean(name="jdbcTemplate")
	public JdbcTemplate initJdbcTemplate(){
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(initDataSource());
		return jdbcTemplate;
	}
	
	
	@Override
	@Bean(name="transactionManager")
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(initDataSource());
		return transactionManager;
	}

}

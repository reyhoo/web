package com.grade.mvc.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@Configuration
@ComponentScan(basePackages="com.grade.mvc")
@ImportResource("/WEB-INF/config/applicationContext.xml")
@EnableTransactionManagement //用注解驱动事务或者在xml中配置<tx:annotation-driven transaction-manager="transactionManager"/>
@EnableAspectJAutoProxy //用注解设置切点的通知或者在xml中配置 <aop:aspectj-autoproxy></aop:aspectj-autoproxy>
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

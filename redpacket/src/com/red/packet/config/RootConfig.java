package com.red.packet.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

@Configuration
@ComponentScan(value="com.*",includeFilters= {@Filter(type=FilterType.ANNOTATION,value=Service.class)})
@EnableTransactionManagement
public class RootConfig implements TransactionManagementConfigurer{

	
	private DataSource dataSource;
	
	
	@Bean(name="dataSource")
	public DataSource initDataSource() {
		if(dataSource!=null) {
			return dataSource;
		}
		Properties prop = new Properties();
		prop.setProperty("driverClassName", "com.mysql.jdbc.Driver");
		prop.setProperty("url", "jdbc:mysql://localhost:3306/ssm?useUnicode=true&characterEncoding=utf8");
		prop.setProperty("username", "root");
		prop.setProperty("password", "123456");
		prop.setProperty("maxActive", "200");
		prop.setProperty("maxIdle", "20");
		prop.setProperty("maxWait", "3000");
		try {
			dataSource = BasicDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dataSource;
	}
	
	@Bean(name="sqlSessionFactory")
	public SqlSessionFactoryBean initSqlSessionFactory() {
		SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
		Resource configLocation = new ClassPathResource("mybatis-config.xml");
		sessionFactoryBean.setConfigLocation(configLocation );
		sessionFactoryBean.setDataSource(initDataSource());
		return sessionFactoryBean;
	}
	
	@Bean
	public MapperScannerConfigurer initMapperScannerConfigurer() {
		MapperScannerConfigurer configurer = new MapperScannerConfigurer();
		configurer.setAnnotationClass(Repository.class);
		configurer.setBasePackage("com.red.packet");
		configurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
		return configurer;
	}
	
	@Bean(name="annotationDrivenTransactionManager")
	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		DataSourceTransactionManager manager = new DataSourceTransactionManager();
		manager.setDataSource(initDataSource());
		return manager;
	}

}

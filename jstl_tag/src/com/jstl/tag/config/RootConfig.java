package com.jstl.tag.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;


@Configuration
@ComponentScan(basePackages="com.*",includeFilters= {@Filter(type=FilterType.ANNOTATION,value=Service.class)})
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class RootConfig implements TransactionManagementConfigurer{

	private DataSource dataSource;
	
	
	private String username;
	private String password;
	private String url;
	private String driver;
	
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
		try {
			dataSource = BasicDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dataSource;
	}
	
	@Bean(name="sqlSessionFactory")
	public SqlSessionFactoryBean initSqlSessionFactory() {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(initDataSource());
		Resource configLocation = new ClassPathResource("mybatis-config.xml");
		factoryBean.setConfigLocation(configLocation);
		return factoryBean;
	}
	
	@Bean
	public MapperScannerConfigurer initMapperScannerConfigurer() {
		MapperScannerConfigurer configurer = new MapperScannerConfigurer();
		configurer.setAnnotationClass(Repository.class);
		configurer.setBasePackage("com.*");
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

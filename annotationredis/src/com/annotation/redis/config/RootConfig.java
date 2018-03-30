package com.annotation.redis.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;


@Configuration
@ComponentScan(basePackages="com.*")
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
		prop.setProperty("password", "");
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
		Resource configLocation = new ClassPathResource("mybatis/mybatis-config.xml");
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

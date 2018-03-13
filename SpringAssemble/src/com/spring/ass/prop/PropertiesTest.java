package com.spring.ass.prop;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.ass.prop.config.PropConfig;

public class PropertiesTest {

	
	public static void main(String[] args) {
		ApplicationContext cxt = new AnnotationConfigApplicationContext(PropConfig.class);
//		String url = cxt.getEnvironment().getProperty("jdbc.database.url");
//		System.out.println(url);
		
		DataSource dataSource = cxt.getBean(DataSource.class);
		
		System.out.println(dataSource);
		try {
			Connection conn = dataSource.getConnection();
			ResultSet res = conn.createStatement().executeQuery("select * from t_role");
			while(res.next()){
				System.out.println(res.getString("role_name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

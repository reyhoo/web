package com.spring.jdbc.trans.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.spring.jdbc.trans.config.JavaConfig;

public class TestTransactionManager {
	
	public static void main(String[] args) {
		ApplicationContext cxt = new  AnnotationConfigApplicationContext(JavaConfig.class);
//		ApplicationContext cxt = new ClassPathXmlApplicationContext("transaction-beans.xml");
		JdbcTemplate jdbcTemplate = cxt.getBean(JdbcTemplate.class);
		TransactionDefinition td = new DefaultTransactionDefinition();
		PlatformTransactionManager transactionManager = cxt.getBean(PlatformTransactionManager.class);
		TransactionStatus status = transactionManager.getTransaction(td);
		try {
			jdbcTemplate.update("delete from t_role where id=55");
//			String line = null;line.lastIndexOf(0);
			transactionManager.commit(status);
		} catch (Exception e) {
			e.printStackTrace();
			transactionManager.rollback(status);
		}
	}
}

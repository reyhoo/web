package com.spring.el.main;

import java.util.Arrays;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class SpringElTest {

	
	public static void main(String[] args) {
		//设置el表达式
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression("'hello world'");
		String str = (String) exp.getValue();
		System.out.println(str);
		//通过el访问普通方法
		exp = parser.parseExpression("'hello world'.charAt(0)");
		Character c = (Character) exp.getValue();
		System.out.println(c);
		//通过el访问getter方法
		exp = parser.parseExpression("'hello world'.bytes");
		byte[] bytes = (byte[]) exp.getValue();
		System.out.println(Arrays.toString(bytes));
		//通过el访问属性，相当于"hello world".getBytes().length
		exp = parser.parseExpression("'hello world'.bytes.length");
		int length = (Integer) exp.getValue();
		System.out.println(length);
		
		exp = parser.parseExpression("new String('abc')");
		String abc = (String) exp.getValue();
		System.out.println(abc);
		
		
	}
}

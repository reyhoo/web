package com.spring.el.main;

import java.util.Arrays;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class SpringElTest {

	
	public static void main(String[] args) {
		//����el���ʽ
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression("'hello world'");
		String str = (String) exp.getValue();
		System.out.println(str);
		//ͨ��el������ͨ����
		exp = parser.parseExpression("'hello world'.charAt(0)");
		Character c = (Character) exp.getValue();
		System.out.println(c);
		//ͨ��el����getter����
		exp = parser.parseExpression("'hello world'.bytes");
		byte[] bytes = (byte[]) exp.getValue();
		System.out.println(Arrays.toString(bytes));
		//ͨ��el�������ԣ��൱��"hello world".getBytes().length
		exp = parser.parseExpression("'hello world'.bytes.length");
		int length = (Integer) exp.getValue();
		System.out.println(length);
		
		exp = parser.parseExpression("new String('abc')");
		String abc = (String) exp.getValue();
		System.out.println(abc);
		
		
	}
}

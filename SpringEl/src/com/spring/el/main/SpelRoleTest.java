package com.spring.el.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import com.spring.el.pojo.Role;

public class SpelRoleTest {

	
	public static void main(String[] args) {
		Role role = new Role(1l,"role_name","note1111");
		ExpressionParser parser = new SpelExpressionParser();
		Expression ex = parser.parseExpression("note");
		//从role中获取备注信息，相当于调用getNote();
		String note = (String) ex.getValue(role);
		System.out.println(note);
		
		
		//变量环境类，并且将对象role作为根节点
		EvaluationContext cxt = new StandardEvaluationContext(role);
		//变量环境类操作根节点
		parser.parseExpression("note").setValue(cxt, "new_note");
		note = parser.parseExpression("note").getValue(cxt, String.class);
		System.out.println(note);
		
		//调用getRoleName方法
		String roleName = parser.parseExpression("getRoleName()").getValue(cxt,String.class);
		System.out.println(roleName);
		
		//新增环境变量
		List<String>list = new ArrayList<String>();
		list.add("value1");
		list.add("value2");
		cxt.setVariable("list", list);
		//通过表达式去读/写环境变量的值
		parser.parseExpression("#list[1]").setValue(cxt, "update_value2");
		System.out.println(parser.parseExpression("#list[1]").getValue(cxt));
	}
}

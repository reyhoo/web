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
		//��role�л�ȡ��ע��Ϣ���൱�ڵ���getNote();
		String note = (String) ex.getValue(role);
		System.out.println(note);
		
		
		//���������࣬���ҽ�����role��Ϊ���ڵ�
		EvaluationContext cxt = new StandardEvaluationContext(role);
		//����������������ڵ�
		parser.parseExpression("note").setValue(cxt, "new_note");
		note = parser.parseExpression("note").getValue(cxt, String.class);
		System.out.println(note);
		
		//����getRoleName����
		String roleName = parser.parseExpression("getRoleName()").getValue(cxt,String.class);
		System.out.println(roleName);
		
		//������������
		List<String>list = new ArrayList<String>();
		list.add("value1");
		list.add("value2");
		cxt.setVariable("list", list);
		//ͨ�����ʽȥ��/д����������ֵ
		parser.parseExpression("#list[1]").setValue(cxt, "update_value2");
		System.out.println(parser.parseExpression("#list[1]").getValue(cxt));
	}
}

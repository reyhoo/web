package com.myec.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Random;

public class MessageUtils {

	private static final String CHARSET = "UTF-8";
	public static String md5(String src) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
		
		 // ����md5����
		 md.update(src.getBytes(CHARSET));
		 // digest()���ȷ������md5 hashֵ������ֵΪ8Ϊ�ַ�������Ϊmd5 hashֵ��16λ��hexֵ��ʵ���Ͼ���8λ���ַ�
		 // BigInteger������8λ���ַ���ת����16λhexֵ�����ַ�������ʾ���õ��ַ�����ʽ��hashֵ
		 return new BigInteger(1, md.digest()).toString(16);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
	public static String getRandomString(int length){
	    //����һ���ַ�����A-Z��a-z��0-9����62λ��
	    String str="1234567890";
	    //��Random���������
	        Random random=new Random();  
	        StringBuffer sb=new StringBuffer();
	        //����Ϊ����ѭ������
	        for(int i=0; i<length; ++i){
	          //����0-61������
	          int number=random.nextInt(9);
	          //������������ͨ��length�γ��ص�sb��
	          sb.append(str.charAt(number));
	        }
	        //�����ص��ַ�ת�����ַ���
	        return sb.toString();
	  }

	public static void main(String[] args) {
		System.out.println(md5("123456"));
		System.out.println(getRandomString(6));
	}
}

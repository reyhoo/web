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
		
		 // 计算md5函数
		 md.update(src.getBytes(CHARSET));
		 // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
		 // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
		 return new BigInteger(1, md.digest()).toString(16);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
	public static String getRandomString(int length){
	    //定义一个字符串（A-Z，a-z，0-9）即62位；
	    String str="1234567890";
	    //由Random生成随机数
	        Random random=new Random();  
	        StringBuffer sb=new StringBuffer();
	        //长度为几就循环几次
	        for(int i=0; i<length; ++i){
	          //产生0-61的数字
	          int number=random.nextInt(9);
	          //将产生的数字通过length次承载到sb中
	          sb.append(str.charAt(number));
	        }
	        //将承载的字符转换成字符串
	        return sb.toString();
	  }

	public static void main(String[] args) {
		System.out.println(md5("123456"));
		System.out.println(getRandomString(6));
	}
}

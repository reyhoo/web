package com.spring.redis.luafile;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import redis.clients.jedis.Jedis;

public class TestLuaFile {

	
	public static void main(String[] args) {
		
		ApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
		RedisTemplate redisTemplate = (RedisTemplate) cxt.getBean("redisTemplate");
		Jedis jedis = (Jedis) redisTemplate.getConnectionFactory().getConnection().getNativeConnection();
		//�����ļ������Ƹ�Redis������Redis�ͻ᷵��sha1��ʶ
		byte[] sha1 = jedis.scriptLoad(getFileToByte(new File("test.lua")));
		//ʹ�÷��صı�ʶִ�У����еڶ�������2����ʾʹ��2����
		//��������ַ�����ת��Ϊ�˶������ֽڽ��д���
		Object obj = jedis.evalsha(sha1, 2, "key1".getBytes(),"key2".getBytes(),"2".getBytes(),"4".getBytes());
		System.out.println(obj);
	}
	
	public static byte[] getFileToByte(File file){
		if(file == null){
			throw new RuntimeException("file obj is null");
		}
		if(!file.exists() || !file.isFile()){
			throw new RuntimeException("file is not exists");
		}
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] buf = new byte[1024*3];
			int count;
			while((count = fis.read(buf))!=-1){
				baos.write(buf, 0, count);
			}
			return baos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(fis != null){
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		return null;
		
	}
}

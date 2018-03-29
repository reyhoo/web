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
/***
 * 命令行执行：redis-cli --eval C:\Users\dell\Desktop\test.lua key1 key2 , 2 4
 * @param args
 */
	
	public static void main(String[] args) {
		
		ApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
		RedisTemplate redisTemplate = (RedisTemplate) cxt.getBean("redisTemplate");
		Jedis jedis = (Jedis) redisTemplate.getConnectionFactory().getConnection().getNativeConnection();
		//发送文件二进制给Redis，这样Redis就会返回sha1标识
		byte[] sha1 = jedis.scriptLoad(getFileToByte(new File("test.lua")));
		//使用返回的标识执行，其中第二个参数2，表示使用2个键
		//而后面的字符串都转化为了二进制字节进行传输
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

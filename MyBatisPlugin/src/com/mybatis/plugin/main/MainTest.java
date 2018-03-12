package com.mybatis.plugin.main;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.util.Iterator;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.ibatis.session.SqlSession;

import com.mybatis.plugin.mapper.UserMapper;
import com.mybatis.plugin.pojo.SexEnum;
import com.mybatis.plugin.pojo.User;
import com.mybatis.plugin.utils.SqlSessionFactoryUtils;

public class MainTest {

	public static void main(String[] args) {
		// SqlSession session = SqlSessionFactoryUtils.openSession();
		// UserMapper userMapper = session.getMapper(UserMapper.class);
		// PageParam pageParam = new PageParam();
		// List<User> list = userMapper.findAll(pageParam);
		// System.out.println(list.size());

		// SqlSession session = SqlSessionFactoryUtils.openSession();
		// UserMapper userMapper = session.getMapper(UserMapper.class);
		// PageParams pageParam = new PageParams();
		// pageParam.setPage(1);
		// pageParam.setPageSize(5);
		// pageParam.setCleanOrderBy(true);
		// List<User> list = userMapper.findWithCondition(200l, 1l, pageParam);
		// System.out.println(list.size());
		// System.out.println(list);
		// System.out.println(pageParam.getTotalPage());
		Base64 base64 = new Base64();
		String encode = base64.encodeToString("中华人民共和国".getBytes());
		System.out.println(encode);
		System.out.println(Base64.encodeBase64String("中华人民共和国".getBytes()));
		byte[] data = Base64.decodeBase64(encode);
		System.out.println(new String(base64.decode(encode)));
		System.out.println(new String(data));

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					new FileInputStream("hello")));
			String line = reader.readLine();
			System.out.println("--------------------------");
			byte[] bytes = Base64.decodeBase64("MTIzNDU2Nzg5");
			
			
//			FileOutputStream out  = new FileOutputStream("hello1");
//			out.write(bytes);
			System.out.println(encodeSha512(bytes));
			System.out.println("--------------------------");
			
			String link = "appCustomerId=002&appId=662C9F07E8256DBEE053F0FE83908A24&pic=9nKmRbUhEK3C3bHfmHD04ZyWtMfBBeJR2q0xYo8BlYLAbwqt+6zHef6+nGvvGCrmXFj3bUeV11wLI7FUiCjpnQ==&token=bindFace-d6177f0a2550405a8fc2a6b234470979-20180308141725";
			System.out.println(hmacSHA256(link.getBytes("UTF-8"), "662C9F07E8246DBEE053F0FE83908A24"));
			System.out.println("--------------------------");
			
			System.out.println(DigestUtils.md5Hex(new FileInputStream("1.png")));
			System.out.println(DigestUtils.md5Hex(new FileInputStream("2.png")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			panduan();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String s = "appId=662C9F07E8256DBEE053F0FE83908A24&appCustomerId=003&token=bindFace-662C9F07E8256DBEE053F0FE83908A24-003-c03987ba20284b69-20180309150358&pic=123";
		System.out.println(s);
		try {
			System.out.println(hmacSHA256(s,"662C9F07E8256DBEE053F0FE83908A24"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static String hmacSHA256(String str, String key) throws Exception {
		return hmacSHA256(str.getBytes("utf-8"), key);
	}

	
//	public static String hmacSHA256(byte[] data, String key) throws Exception {
//		String algorithm = "HmacSHA256";
//		Mac mac = Mac.getInstance(algorithm);
//		mac.init(new SecretKeySpec(key.getBytes("UTF-8"), algorithm));
//		return new String(new Base64().encode(mac.doFinal(data)));
//	}
	public static String hmacSHA256(byte[] data, String key) throws Exception {
		String algorithm = "HmacSHA256";
		Mac mac = Mac.getInstance(algorithm);
		mac.init(new SecretKeySpec(key.getBytes("UTF-8"), algorithm));
		return new Base64().encodeToString(mac.doFinal(data));
	}

	public static void panduan() throws Exception {

		// get image format in a file
		File file = new File("0_");

		// create an image input stream from the specified file
		ImageInputStream iis = ImageIO.createImageInputStream(file);

		// get all currently registered readers that recognize the image format
		Iterator<ImageReader> iter = ImageIO.getImageReaders(iis);

		if (!iter.hasNext()) {
			throw new RuntimeException("No readers found!");
		}

		// get the first reader
		ImageReader reader = iter.next();

		System.out.println("Format: " + reader.getFormatName());

		// close stream
		iis.close();

	}



	public static String encodeSha512(byte[] data) throws Exception {
		String algorithm = "SHA-512";
		MessageDigest messgeDigest = MessageDigest.getInstance(algorithm);
		return new Base64().encodeToString(messgeDigest.digest(data));
	}

	private String MD5(String s) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] bytes = md.digest(s.getBytes("utf-8"));
			return toHex(bytes);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static String toHex(byte[] bytes) {

		final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
		StringBuilder ret = new StringBuilder(bytes.length * 2);
		for (int i = 0; i < bytes.length; i++) {
			ret.append(HEX_DIGITS[(bytes[i] >> 4) & 0x0f]);
			ret.append(HEX_DIGITS[bytes[i] & 0x0f]);
		}
		return ret.toString();
	}

	static void insertData() {
		SqlSession session = SqlSessionFactoryUtils.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		try {

			for (int i = 0; i < 1000; i++) {
				User user = new User();
				user.setEmail("user" + (i + 1) + "@163.com");
				user.setMobile("151" + (i + 1));
				user.setNote("user" + (i + 1) + "notenotenote");
				user.setRealName("user" + (i + 1) + ".yao");
				SexEnum sex = i % 2 == 0 ? SexEnum.FEMALE : SexEnum.MALE;
				user.setSex(sex);
				user.setUserName("user" + (i + 1));
				userMapper.addUser(user);
			}
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
	}
}

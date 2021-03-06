package com.myec.util;

import java.util.Arrays;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;

public class RSAUtils {

	public static String[] generateKeys() {
		Map<String, Object> keyMap;
		try {
			keyMap = RSACoder.initKey();
			String publicKey = RSACoder.getPublicKey(keyMap);
			String privateKey = RSACoder.getPrivateKey(keyMap);
			return new String[] { publicKey, privateKey };
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) throws Exception {
		String[] generateKeys = generateKeys();
		System.out.println(Arrays.toString(generateKeys));
		String str = "111111";
		byte[] e = RSACoder.encryptByPublicKey(str.getBytes(), generateKeys[0]);
		System.out.println(Base64.encodeBase64String(e));
		System.out.println(new String(RSACoder.decryptByPrivateKey(e, generateKeys[1])));
	}

}

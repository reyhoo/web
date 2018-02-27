package com.test;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Test {

	
	public static void main(String[] args) throws Exception {
		int a = 'Ҧ'+1-1;
		System.out.println(Integer.toBinaryString(a));
		byte[]data = "Ҧ".getBytes("utf-8");
		for (int i = 0; i < data.length; i++) {
			String s = Integer.toBinaryString(0xff & data[i]);
			data[i] = (byte) (0xff & data[i]);
			System.out.print(s);
			System.out.println();
		}
		System.out.println(new String(data,"utf-8"));
		System.out.println(Integer.toBinaryString(-61));
		System.out.println(0xfffffff0);
	}
	
	/*
	 * ΢�Ź���ƽ̨(JAVA) SDK
	 *
	 * Copyright (c) 2016, Ansitech Network Technology Co.,Ltd All rights reserved.
	 * http://www.ansitech.com/weixin/sdk/
	 *
	 * Licensed under the Apache License, Version 2.0 (the "License");
	 * you may not use this file except in compliance with the License.
	 * You may obtain a copy of the License at
	 *
	 *      http://www.apache.org/licenses/LICENSE-2.0
	 *
	 * Unless required by applicable law or agreed to in writing, software
	 * distributed under the License is distributed on an "AS IS" BASIS,
	 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	 * See the License for the specific language governing permissions and
	 * limitations under the License.
	 */
	package com.levi.utils;

	import java.security.MessageDigest;

	/**
	 * <p>Title: SHA1�㷨</p>
	 *
	 * @author levi
	 */
	public final class SHA1 {

	    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5',
	                           '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

	    /**
	     * Takes the raw bytes from the digest and formats them correct.
	     *
	     * @param bytes the raw bytes from the digest.
	     * @return the formatted bytes.
	     */
	    private static String getFormattedText(byte[] bytes) {
	        int len = bytes.length;
	        StringBuilder buf = new StringBuilder(len * 2);
	        // ������ת����ʮ�����Ƶ��ַ�����ʽ
	        for (int j = 0; j < len; j++) {
	            buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
	            buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
	        }
	        return buf.toString();
	    }

	    public static String encode(String str) {
	        if (str == null) {
	            return null;
	        }
	        try {
	            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
	            messageDigest.update(str.getBytes());
	            return getFormattedText(messageDigest.digest());
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }
	}

}

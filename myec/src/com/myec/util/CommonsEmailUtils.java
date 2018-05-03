package com.myec.util;

import java.io.File;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

public class CommonsEmailUtils {
	private static String host = "smtp.sina.cn";
	private static int port = 25;
	private static String userName = "jobsite910115@sina.cn";
	private static String password = "qjld12004";
	private String to = "";

	private static class EmailInfo {
		String verifyCode;
		long lastSendTime;
	}

	private static Map<String, EmailInfo> verifyCodeMap = new ConcurrentHashMap<>();

	
	public static boolean verify(String email,String code) {
		synchronized (email.intern()) {
			EmailInfo emailInfo = verifyCodeMap.get(email);
			if(emailInfo == null) {
				return false;
			}
			if(System.currentTimeMillis() - emailInfo.lastSendTime >= 1000l * 60 * 30) {
				verifyCodeMap.remove(email);
				return false;
			}
			boolean result = code.equals(emailInfo.verifyCode);
			if(result) {
				verifyCodeMap.remove(email);
			}
			return result;
		}
	}
	
	/**
	 * 发送Html邮件
	 * 
	 * @throws Exception
	 */
	public static int sendHtmlMail(String to) {
		if(to == null || !to.matches("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$")) {
			return -2;
		}
		synchronized (to.intern()) {
		EmailInfo emailInfo = verifyCodeMap.get(to);
		if (emailInfo == null) {
			try {
				long now = System.currentTimeMillis();
				emailInfo = new EmailInfo();
				emailInfo.lastSendTime = now;
				emailInfo.verifyCode = MessageUtils.getRandomString(6);
				realSend(to,emailInfo.verifyCode);
				verifyCodeMap.put(to, emailInfo);
				return 0;
			} catch (Exception e) {
				e.printStackTrace();
				return -2;
			}
		} else {
			long now = System.currentTimeMillis();
			if(now-emailInfo.lastSendTime >= 1000*60) {
				verifyCodeMap.remove(to);
				emailInfo = new EmailInfo();
				emailInfo.lastSendTime = now;
				emailInfo.verifyCode = MessageUtils.getRandomString(6);
				try {
					realSend(to,emailInfo.verifyCode);
					verifyCodeMap.put(to, emailInfo);
					return 0;
				} catch (Exception e) {
					e.printStackTrace();
					return -2;
				}
			}else {
				return -1;
			}
		}
		}
	}

	private static void realSend(String to, String verifyCode) throws Exception {
		HtmlEmail mail = new HtmlEmail();
		// 设置邮箱服务器信息
		mail.setSmtpPort(port);
		mail.setHostName(host);
		// 设置密码验证器
		mail.setAuthentication(userName, password);
		// 设置邮件发送者
		mail.setFrom(userName);
		// 设置邮件接收者
		mail.addTo(to);
//		mail.addCc(userName);
		// 设置邮件编码
		mail.setCharset("UTF-8");
		// 设置邮件主题
		mail.setSubject("验证码");
		// 设置邮件内容
		String yzm = "";
		mail.setHtmlMsg("<!DOCTYPE>"
				+ "<div bgcolor='#f1fcfa'   style='border:1px solid #d9f4ee; font-size:14px; line-height:22px; color:#005aa0;padding-left:1px;padding-top:5px;   padding-bottom:5px;'><span style='font-weight:bold;'>温馨提示：</span>"
				+ "<div style='width:950px;font-family:arial;'>您的注册码为：<br/><h2 style='color:green'>" + verifyCode
				+ "</h2><br/>本邮件由系统自动发出，请勿回复。<br/>感谢您的使用。</div>" + "</div>");
		// 设置邮件发送时间
		mail.setSentDate(new Date());
		// 发送邮件
		mail.send();
	}

	/**
	 * 发送文本邮件
	 * 
	 * @throws Exception
	 */
	public void sendTextMail() throws Exception {
		SimpleEmail mail = new SimpleEmail();
		// 设置邮箱服务器信息
		mail.setSmtpPort(port);
		mail.setHostName(host);
		// 设置密码验证器
		mail.setAuthentication(userName, password);
		// 设置邮件发送者
		mail.setFrom(userName);
		// 设置邮件接收者
		mail.addTo(to);
		// 设置邮件编码
		mail.setCharset("UTF-8");
		// 设置邮件主题
		mail.setSubject("Test Email");
		// 设置邮件内容
		mail.setMsg("this is a test Text mail");
		// 设置邮件发送时间
		mail.setSentDate(new Date());
		// 发送邮件
		mail.send();
	}

	/**
	 * 发送内嵌图片邮件
	 * 
	 * @throws Exception
	 */
	public void sendImageMail() throws Exception {
		HtmlEmail mail = new HtmlEmail();
		// 设置邮箱服务器信息
		mail.setSmtpPort(port);
		mail.setHostName(host);
		// 设置密码验证器
		mail.setAuthentication(userName, password);
		// 设置邮件发送者
		mail.setFrom(userName);
		// 设置邮件接收者
		mail.addTo(to);
		// 设置邮件编码
		mail.setCharset("UTF-8");
		// 设置邮件主题
		mail.setSubject("Test Email");
		mail.embed(new File("1_jianggujin.jpg"), "image");
		// 设置邮件内容
		String htmlText = "<html><body><img src='cid:image'/><div>this is a HTML email.</div></body></html>";
		mail.setHtmlMsg(htmlText);
		// 设置邮件发送时间
		mail.setSentDate(new Date());
		// 发送邮件
		mail.send();
	}

	/**
	 * 发送附件邮件
	 * 
	 * @throws Exception
	 */
	public void sendAttachmentMail() throws Exception {
		MultiPartEmail mail = new MultiPartEmail();
		// 设置邮箱服务器信息
		mail.setSmtpPort(port);
		mail.setHostName(host);
		// 设置密码验证器
		mail.setAuthentication(userName, password);
		// 设置邮件发送者
		mail.setFrom(userName);
		// 设置邮件接收者
		mail.addTo(to);
		// 设置邮件编码
		mail.setCharset("UTF-8");
		// 设置邮件主题
		mail.setSubject("Test Email");

		mail.setMsg("this is a Attachment email.this email has a attachment!");
		// 创建附件
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath("1_jianggujin.jpg");
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setName("1_jianggujin.jpg");
		mail.attach(attachment);

		// 设置邮件发送时间
		mail.setSentDate(new Date());
		// 发送邮件
		mail.send();
	}

	/**
	 * 发送内嵌图片和附件邮件
	 * 
	 * @throws Exception
	 */
	public void sendImageAndAttachmentMail() throws Exception {
		HtmlEmail mail = new HtmlEmail();
		// 设置邮箱服务器信息
		mail.setSmtpPort(port);
		mail.setHostName(host);
		// 设置密码验证器
		mail.setAuthentication(userName, password);
		// 设置邮件发送者
		mail.setFrom(userName);
		// 设置邮件接收者
		mail.addTo(to);
		// 设置邮件编码
		mail.setCharset("UTF-8");
		// 设置邮件主题
		mail.setSubject("Test Email");
		mail.embed(new File("1_jianggujin.jpg"), "image");
		// 设置邮件内容
		String htmlText = "<html><body><img src='cid:image'/><div>this is a HTML email.</div></body></html>";
		mail.setHtmlMsg(htmlText);
		// 创建附件
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath("1_jianggujin.jpg");
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setName("1_jianggujin.jpg");
		mail.attach(attachment);
		// 设置邮件发送时间
		mail.setSentDate(new Date());
		// 发送邮件
		mail.send();
	}
	
	public static void main(String[] args) {
		int result = sendHtmlMail("373561022@qq.com");
		System.out.println(result);
	}
}
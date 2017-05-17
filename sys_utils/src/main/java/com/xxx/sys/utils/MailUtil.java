package com.xxx.sys.utils;

import java.security.Security;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class MailUtil {

	public static void sendMessage(String toAddr,String subject,String content)throws Exception{
		
		Properties props = new Properties();
		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		
		props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
		props.setProperty("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.host","smtp.qq.com");//邮件发送服务器地址
		props.put("mail.smtp.auth",true);//是否验证用户身份
		
		Session session = Session.getInstance(props);//得到Session
		session.setDebug(true);//使用debug模式，在控制台输出smtp协议应答过程
		
		//创建一个MimeMessage格式的邮件
		MimeMessage message = new MimeMessage(session);
		//设置发送者
		Address fromAddress = new InternetAddress("1154684435@qq.com");//邮件地址
		message.setFrom(fromAddress);//设置发件地址
		//设置接收者
		Address toAddress = new InternetAddress(toAddr);//邮件地址
		message.setRecipient(RecipientType.TO, toAddress);//设置收件地址
		
		//设置邮件主题
		message.setSubject(subject);
		//设置邮件内容
		message.setText(content);
		
		//保存邮件
		message.saveChanges();
		
		// 得到发送邮件的通道
		Transport transport = session.getTransport("smtp");
		
		// 通道连接服务器jlqwfmgughplhbgf
		transport.connect("smtp.qq.com","1154684435@qq.com","jlqwfmgughplhbgf");
		
		// 发送
		transport.sendMessage(message, message.getAllRecipients());
		
		// 关闭通道
		transport.close();
		
		
	}
}

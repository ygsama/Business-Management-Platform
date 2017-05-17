package sys_web;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class JavaMail02_Test2 {

	@Test
	public void testJavaMail()throws Exception{
//		加载简单邮件对象
		ApplicationContext applicationContext =new ClassPathXmlApplicationContext("classpath:applicationContext-mail.xml");

//		加载邮件发送对象
		JavaMailSender sender = (JavaMailSender) applicationContext.getBean("mailSender");
//		加载简单邮件对象，并设置属性
		SimpleMailMessage message = (SimpleMailMessage) applicationContext.getBean("mailMessage");
		message.setSubject("spring与javamail的测试");
		message.setText("hello！ \n  world!");
		message.setTo("ygsama@qq.com");
		// 发送
		sender.send(message);
	}
}

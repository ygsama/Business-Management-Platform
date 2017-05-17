package sys_web;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class JavaMail03_Test {

	@Test
	public void testJavaMail()throws Exception{
		//加载
		ApplicationContext applicationContext =new ClassPathXmlApplicationContext("classpath:applicationContext-mail.xml");

		//加载邮件发送对象
		JavaMailSender sender = (JavaMailSender) applicationContext.getBean("mailSender");
		
		// 创建可以发送带图片和附件的邮件
		MimeMessage message = sender.createMimeMessage();
		// spring mail的工具类MimeMailMessage操作邮件对象
		MimeMessageHelper helper = new MimeMessageHelper(message,true);
		
		// 设置主题、内容、图片、附件
		helper.setSubject("主题");
		helper.setText("<h1>标题</h1><img src=cid:image />",true);// true表示字符串解析成html
		// 添加文件
		FileSystemResource exResource = new FileSystemResource(new File("C:/Users/G/Pictures/31.jpg"));
		FileSystemResource imgResource = new FileSystemResource(new File("C:/Users/G/Pictures/31.jpg"));
		
		helper.addInline("image", imgResource);//显示的图片
		helper.addAttachment("", exResource);//附件文件
		
		helper.setFrom("1154684435@qq.com");//发送者
		helper.setTo("ygsama@qq.com");//接收者
		
		
		// 发送
		sender.send(message);
	}
}

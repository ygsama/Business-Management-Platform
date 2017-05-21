package com.xxx.sys.job;

import java.util.Date;

/**
 * 定义一个任务类
 * @author G
 *
 */
public class MailJob {

	
	public void send() throws Exception{
		
		System.out.println("任务执行完成"+new Date());
	}
}

package com.xxx.sys.job;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.xxx.sys.domain.Contract;
import com.xxx.sys.service.ContractService;
import com.xxx.sys.utils.MailUtil;

/**
 * 定义一个任务类，定时任务
 * @author G
 *
 */
public class MailJob {

	//注入ContractService
	private ContractService contractService;
	public void setContractService(ContractService contractService) {
		this.contractService = contractService;
	}
	
	
	public void send() throws Exception{
		System.out.println("任务执行"+new Date());
		
		String hql = "from Contract where to_char(deliveryPeriod,'yyyy-MM-dd')=?";
		
		//获取当前时间
		String deteStr  = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		
		List<Contract> list = contractService.find(hql, Contract.class, new String[]{deteStr});
		
		//判断集合，如果不为空，说明有购销合同今天到期
		if(list!=null && list.size()>0){
			for(final Contract c :list){
				Thread.sleep(3000);//让当前线程休眠  3秒
				
				Thread th = new Thread(new Runnable() {
					
					public void run() {
						//发送邮件的代码	
						try {
							MailUtil.sendMessage("ygsama@qq.com", "【邮件测试】提醒：交期到了", "您好，您有一个购销合同的交货日期于"+new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(c.getDeliveryPeriod())+"到期");
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
				th.start();
			}
		}else{
			System.out.println("您目前还没有到期的购销合同？？？");
		}
		
	}
}

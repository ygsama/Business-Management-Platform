package com.xxx.sys.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.xxx.sys.dao.BaseDao;
import com.xxx.sys.domain.User;
import com.xxx.sys.service.UserService;
import com.xxx.sys.utils.Encrypt;
import com.xxx.sys.utils.Page;
import com.xxx.sys.utils.SysConstant;
import com.xxx.sys.utils.UtilFuns;

public class UserServiceImpl implements UserService {

	private BaseDao baseDao;
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	private SimpleMailMessage mailMessage;
	private JavaMailSender mailSender;
	public void setMailMessage(SimpleMailMessage mailMessage) {
		this.mailMessage = mailMessage;
	}
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
		
	
	@Override
	public List<User> find(String hql, Class<User> entityClass, Object[] params) {
		
		return baseDao.find(hql, entityClass, params);
	}

	@Override
	public User get(Class<User> entityClass, Serializable id) {
		
		return baseDao.get(entityClass, id);
	}

	@Override
	public Page<User> findPage(String hql, Page<User> page, Class<User> entityClass, Object[] params) {
		
		return baseDao.findPage(hql, page, entityClass, params);
	}

	@Override
	public void saveOrUpdate(final User entity) {
		if(UtilFuns.isEmpty(entity.getId())){
			String id=UUID.randomUUID().toString();
			entity.setId(id);
			entity.getUserinfo().setId(id);
			
			// 补充shiro添加后的系统bug
			entity.setPassword(Encrypt.md5(SysConstant.DEFAULT_PASS, entity.getUserName()));
			baseDao.saveOrUpdate(entity);//新增
			
			/*//传统方式：开启一个新线程，发送邮件
			Thread th= new Thread(new Runnable() {
				public void run(){
					try {
						MailUtil.sendMessage(entity.getUserinfo().getEmail(), "【系统通知】新员工入职", entity.getUserinfo().getName()+entity.getUserinfo().getGender()=="男"?"先生":"女士"+"欢迎您加入xx公司！您的用户名和初始密码是："+entity.getUserName()+","+SysConstant.DEFAULT_PASS);
					} catch (Exception e) {
						e.printStackTrace();
					}					
				}
			});
			th.start();*/
			
			//spring mail 
			Thread th= new Thread(new Runnable() {
				public void run(){
					try {
						mailMessage.setTo(entity.getUserinfo().getEmail());
						mailMessage.setSubject("【系统通知】新员工入职");
						mailMessage.setText(entity.getUserinfo().getName()+(entity.getUserinfo().getGender()=="1"?"先生":"女士")+"欢迎您加入xx公司！您的用户名和初始密码是："+entity.getUserName()+","+SysConstant.DEFAULT_PASS);
						mailSender.send(mailMessage);
					} catch (Exception e) {
						e.printStackTrace();
					}					
				}
			});
			th.start();
			
			
			
			
			
		}else{
			//修改保存
			baseDao.saveOrUpdate(entity);
		}
	}

	@Override
	public void saveOrUpdateAll(Collection<User> entitys) {
		baseDao.saveOrUpdateAll(entitys);
	}

	@Override
	public void deleteById(Class<User> entityClass, Serializable id) {
		
		baseDao.deleteById(entityClass, id);// 删除一个
	}

	@Override
	public void delete(Class<User> entityClass, Serializable[] ids) {
		for(Serializable id:ids){
			this.deleteById(entityClass, id);
		}
	}

}

package com.xxx.sys.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

import com.xxx.sys.utils.Encrypt;

public class CustomCredentialsMatcher extends SimpleCredentialsMatcher {

	// 密码比较的方法	token是输入的用户名和密码	info数据库加密的密码
	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		// 向下转型
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		// 加密
		Object pwd = Encrypt.md5(new String(upToken.getPassword()), upToken.getUsername());
		// 数据库密码
		Object dbPwd = info.getCredentials();
		
		return this.equals(pwd, dbPwd);
	}
	
}

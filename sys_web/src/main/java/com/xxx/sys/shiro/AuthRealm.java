package com.xxx.sys.shiro;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.xxx.sys.domain.Module;
import com.xxx.sys.domain.Role;
import com.xxx.sys.domain.User;
import com.xxx.sys.service.UserService;

public class AuthRealm extends AuthorizingRealm {

	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	// 授权	当jsp页面出现shiro标签时，就会执行授权方法
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
		
		User user = (User) pc.fromRealm(this.getName()).iterator().next();//根据realm的名字找对应的realm
		Set<Role> roles = user.getRoles();//对象导航 hibernate 五种数据检索方式
		List<String> permissions = new ArrayList<String>();
		for (Role role : roles) {//遍历角色
			Set<Module> modules = role.getModules();//得到每个角色下的模块列表
			for (Module m : modules) {
				permissions.add(m.getName());//把模块名添加到集合中
			}
		}
		
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addStringPermissions(permissions);//添加用户的权限
		
		return info;
	}
	// 认证	token时输入的用户名和密码
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		// 向下转型
		UsernamePasswordToken up = (UsernamePasswordToken) token;
		
		// 调用业务方法,根据用户名查询
		String hql = "from User where userName=?";
		List<User> list = userService.find(hql, User.class, new String[]{up.getUsername()});
		if(list!=null && list.size()>0){
			User user = list.get(0);
			AuthenticationInfo info = new SimpleAuthenticationInfo(user,user.getPassword(),this.getName());
			return info;//下一步进入密码比较器
		}
		return null;
	}
}
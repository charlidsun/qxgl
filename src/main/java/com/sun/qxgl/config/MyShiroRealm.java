package com.sun.qxgl.config;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * 功能：
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年6月29日 下午5:58:12
 */
public class MyShiroRealm extends AuthorizingRealm{
	
	
	/**
	 * 认证信息
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		
		//获取用户名
		String name = (String) token.getPrincipal();
		//根据用户名查相关信息
		
		//验证
		SimpleAuthenticationInfo simplt = new SimpleAuthenticationInfo(name, hashedCredentials, credentialsSalt, getName());
		
		return simplt;
	}

	
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		
		
		return null;
	}

	
	
}

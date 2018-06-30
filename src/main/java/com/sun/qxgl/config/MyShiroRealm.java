package com.sun.qxgl.config;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.sun.qxgl.authority.entity.UserInfo;
import com.sun.qxgl.authority.service.AuthorityService;

/**
 * 功能：
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年6月29日 下午5:58:12
 */
public class MyShiroRealm extends AuthorizingRealm{
	
	@Autowired
	AuthorityService authorityService;
	/**
	 * 认证信息
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		
		//获取用户名
		String name = (String) token.getPrincipal();
		System.out.println(name);
		//根据用户名查相关信息
		UserInfo userInfo = authorityService.queryUserInfoByName(name);
		System.out.println(userInfo);
		//验证
		SimpleAuthenticationInfo simplt = new SimpleAuthenticationInfo(userInfo, userInfo.getPassword(), ByteSource.Util.bytes(userInfo.getCredentialsSalt()), getName());
		
		return simplt;
	}

	
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		
		
		return null;
	}

	
	
}

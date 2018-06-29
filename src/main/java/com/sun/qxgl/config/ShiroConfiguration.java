package com.sun.qxgl.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;

/**
 * 功能：
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年6月29日 下午5:28:01
 */
public class ShiroConfiguration {
	
	@Bean
	public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager){
		ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
		
		shiroFilter.setSecurityManager(securityManager);
		
		Map<String,String> filterMap = new LinkedHashMap<String, String>();
		filterMap.put("/logout", "logout");
		filterMap.put("/**", "authc");  
		shiroFilter.setLoginUrl("/login");  
		shiroFilter.setSuccessUrl("/index");  
		shiroFilter.setUnauthorizedUrl("/403");
		shiroFilter.setFilterChainDefinitionMap(filterMap);
		return shiroFilter;
	}

	@Bean
	public SecurityManager securityManager(){
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(myShiroRealm());
		return securityManager;
	}
	
	@Bean
	public MyShiroRealm myShiroRealm(){
		MyShiroRealm myShiroRealm = new MyShiroRealm();
		return myShiroRealm;
	}
}

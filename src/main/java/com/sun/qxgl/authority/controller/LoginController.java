package com.sun.qxgl.authority.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sun.qxgl.authority.service.AuthorityService;

/**
 * 功能：
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年6月29日 下午1:38:35
 */
@Controller
public class LoginController {
	
	@Autowired
	AuthorityService authorityService;

	@RequestMapping({"/","/index"})
	public String index(){
		authorityService.queryUserInfoByName("admin");
		return "/index";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(){
		return "/login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(HttpServletRequest request, Map<String, Object> map){
	       String exception = (String) request.getAttribute("shiroLoginFailure");  
	       System.out.println("exception=" + exception);  
	       String msg = "";  
	       if (exception != null) {  
	           if (UnknownAccountException.class.getName().equals(exception)) {  
	              System.out.println("UnknownAccountException -- > 账号不存在：");  
	              msg = "UnknownAccountException -- > 账号不存在：";  
	           } else if (IncorrectCredentialsException.class.getName().equals(exception)) {  
	              System.out.println("IncorrectCredentialsException -- > 密码不正确：");  
	              msg = "IncorrectCredentialsException -- > 密码不正确：";  
	           } else if ("kaptchaValidateFailed".equals(exception)) {  
	              System.out.println("kaptchaValidateFailed -- > 验证码错误");  
	              msg = "kaptchaValidateFailed -- > 验证码错误";  
	           } else {  
	              msg = "else >> "+exception;  
	              System.out.println("else -- >" + exception);  
	           }  
	       }  
	       map.put("msg", msg);  
	       // 此方法不处理登录成功,由shiro进行处理.  
	       return "/login";  
	}
}

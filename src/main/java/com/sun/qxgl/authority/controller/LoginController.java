package com.sun.qxgl.authority.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
	public String login(HttpServletRequest request, Map<String, Object> map){
		String exception = (String) request.getAttribute("shiroLoginFailure");  
	    System.out.println("exception=" + exception);  
		return "/login";
	}
}

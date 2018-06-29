package com.sun.qxgl.authority.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 功能：
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年6月29日 下午1:38:35
 */
@Controller
public class LoginController {

	@RequestMapping({"/","/index"})
	public String index(){
		return "/index";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(){
		return "/login";
	}
}

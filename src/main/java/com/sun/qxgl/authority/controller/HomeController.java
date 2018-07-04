package com.sun.qxgl.authority.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.qxgl.authority.entity.SysRole;
import com.sun.qxgl.authority.entity.UserInfo;
import com.sun.qxgl.authority.service.UserService;

/**
 * 功能： 说明：
 * 
 * @author 孙荆阁:
 * @Date 2018年7月4日 上午10:53:23
 */
@RestController
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	UserService userService;

	@RequestMapping("/")
	public UserInfo getUserInfo(HttpSession session) {

		UserInfo user = (UserInfo) SecurityUtils.getSubject().getPrincipal(); 
		return user;
	}
	
	@RequestMapping("/sysRole")
	public List<SysRole> listSysRole(){
		List<SysRole> list = userService.querySysRole("");
		return list;
	}
	
	@RequestMapping("/saveRole")
	public int saveRole(String name,String desc) {
		System.out.println(name+"---"+desc);
		int flag = 0;
		Map<String,Object> map = new HashMap<>();
		map.put("role", name);
		map.put("description", desc);
		map.put("available", 1);
		flag =  userService.saveRole(map);
		return flag;
	}
}

package com.sun.qxgl.authority.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 功能：
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年7月2日 下午5:02:40
 */
@Controller
@RequestMapping("/userInfo")
public class UserInfoController {

	
	
	@RequestMapping("/roleList")
	public String roleList(){
		System.out.println("roleList");
		return "user/roleList";
	}

	
	@RequestMapping("/userList")
	public String userList(){
		return "userList";
	}
	
	@RequestMapping("/userAdd")
	@RequiresPermissions("userInfo:add")//权限管理;
	public String userAdd(){
		return "userAdd";
	}
	@RequestMapping("/userDele")
	@RequiresPermissions("userInfo:del")//权限管理;
	public String userDele(){
		return "userDele";
	}
}

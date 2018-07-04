package com.sun.qxgl.authority.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.qxgl.authority.dao.AuthorityDao;
import com.sun.qxgl.authority.entity.SysPermission;
import com.sun.qxgl.authority.entity.SysRole;
import com.sun.qxgl.authority.entity.UserInfo;
import com.sun.qxgl.base.service.BaseService;
import com.sun.qxgl.utils.TransUtils;

/**
 * 功能：
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年6月30日 上午9:24:11
 */
@Service
public class AuthorityService extends BaseService{

	@Autowired
	AuthorityDao authorityDao;
	
	public UserInfo queryUserInfoByName(String name){
		UserInfo userInfo = new UserInfo();
		Map<String,Object> userMap = authorityDao.querySql("select * from userinfo where username='"+name+"'");
		try {
			userInfo = (UserInfo)TransUtils.mapToObject(userMap, com.sun.qxgl.authority.entity.UserInfo.class);
			if (userInfo != null){
				List<Map<String,Object>> userRole = authorityDao.queryList(("SELECT ro.id,ro.description,ro.role FROM sysrole ro LEFT JOIN sysuserrole ro_re ON ro_re.roleId = ro.id LEFT JOIN userinfo info ON info.uid = ro_re.uid where ro_re.uid=")+userInfo.getUid());
				List<SysRole> roleList = TransUtils.listMapToList(userRole, com.sun.qxgl.authority.entity.SysRole.class); 
				userInfo.setUserRole(roleList);
				for (SysRole s:roleList){
					List<Map<String,Object>> userPermission = authorityDao.queryList(("SELECT * FROM syspermission pe LEFT JOIN sysrolepermission pe_re ON pe_re.permissionId = pe.id WHERE pe_re.roleId=")+s.getId());
					List<SysPermission> permList = TransUtils.listMapToList(userPermission, com.sun.qxgl.authority.entity.SysPermission.class);
					s.setUserPermission(permList);
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userInfo;
	}
	
}

package com.sun.qxgl.authority.service;

import java.util.List;
import java.util.Map;

import org.mockito.internal.matchers.InstanceOf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.qxgl.authority.dao.UserDao;
import com.sun.qxgl.authority.entity.SysRole;
import com.sun.qxgl.base.service.BaseService;
import com.sun.qxgl.utils.TransUtils;

/**
 * 功能： 说明：
 * 
 * @author 孙荆阁:
 * @Date 2018年7月4日 下午1:56:30
 */
@Service
public class UserService extends BaseService {

	@Autowired
	UserDao userDao;

	public List<SysRole> querySysRole(String name) {
		List<Map<String, Object>> userRole = userDao.queryList("SELECT * from SysRole");
		List<SysRole> roleList = null;
		try {
			roleList = TransUtils.listMapToList(userRole, com.sun.qxgl.authority.entity.SysRole.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return roleList;
	}

	public int saveRole(Map<String, Object> map) {
		String sql = trans(map, "SysRole");
		return userDao.saveSql(sql);
	}

	public static String trans(Map<String, Object> map, String tb) {
		String str = "insert into " + tb + " (";
		for(String key : map.keySet()){
			str +=key+",";
		}
		str = str.substring(0, str.length()-1);
		str += ") VALUES ('";
		for(Object value : map.values()){
			if (value instanceof Integer) {
			}
			str += value +"','";
		}
		str = str.substring(0, str.length()-2);
		str += ")";
		return str;
	}
	
}

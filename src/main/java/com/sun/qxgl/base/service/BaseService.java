package com.sun.qxgl.base.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.qxgl.base.dao.BaseDao;

/**
 * 功能： 说明：
 * 
 * @author 孙荆阁:
 * @Date 2018年6月30日 上午9:14:38
 */
@Service
public class BaseService {

	@Autowired
	BaseDao baseDao;

	public List<Map<String, Object>> queryList(String sql) {
		return baseDao.queryList(sql);
	}
}

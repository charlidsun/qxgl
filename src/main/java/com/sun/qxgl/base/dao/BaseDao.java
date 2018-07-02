package com.sun.qxgl.base.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * 功能：
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年6月30日 上午9:10:14
 */
@Repository
public class BaseDao {

	@Autowired
	JdbcTemplate jdbc;
	
	public List<Map<String,Object>> queryList(String sql){
		return jdbc.queryForList(sql);
	}
	
	public Map<String,Object> querySql(String sql){
		return jdbc.queryForMap(sql);
	}
}

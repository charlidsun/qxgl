package com.sun.qxgl.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 功能： 说明：
 * 
 * @author 孙荆阁:
 * @Date 2018年6月30日 上午11:43:48
 */
public class TransUtils {

	public static Object mapToObject(Map<String, Object> map, Class<?> beanClass)
			throws Exception {
		if (map == null)
			return null;
		Object obj = beanClass.newInstance();
		org.apache.commons.beanutils.BeanUtils.populate(obj, map);
		return obj;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> List<T> listMapToList(List<Map<String, Object>> mapList, Class<?> beanClass) throws Exception{
		if (mapList == null){
			return null;
		}
		List<Object> list = new ArrayList<>();
		for (Map<String,Object> map : mapList){
			Object o = mapToObject(map, beanClass);
			list.add(o);
		}
		return (List<T>) list;
	}
}

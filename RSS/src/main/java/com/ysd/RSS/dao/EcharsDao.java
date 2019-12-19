package com.ysd.RSS.dao;

import java.util.List;
import java.util.Map;

public interface EcharsDao {
	/**
	 * 各个系的学生数量
	 * 
	 * @return
	 */
	List<Map<Object, Object>> SelectTuBiaoXiCount();

	/**
	 * 各个班的学生数量
	 * 
	 * @return
	 */
	List<Map<Object, Object>> SelectTuBiaoBanJiCount();
	/**
	 * 各个科室的老师
	 * 
	 * @return
	 */
	List<Map<Object, Object>> SelectTuBiaoKeShiCount();
	/**
	 * 各个阅览室什么的本月的总人数
	 * 
	 * @return
	 */
	List<Map<Object, Object>>  SelectTuBiaoBenYueCount();
	/**
	 * 各个学历总人数
	 * 
	 * @return
	 */
	List<Map<Object, Object>>   SelectTuBiaoXueLiCount();
	/**
	 * 各个时间段不同阅览室的人数
	 * @return
	 */
	List<Map<Object, Object>>   SelectTuBiaoDataYueLanShiCount();
	
}

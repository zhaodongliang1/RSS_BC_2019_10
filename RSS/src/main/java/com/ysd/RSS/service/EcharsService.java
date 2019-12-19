package com.ysd.RSS.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;

public interface EcharsService {
	  /**
     *  各个系的学生数量
 * @return
 */
List<Map<Object,Object>>  SelectTuBiaoXiCount();

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
List<List<String>>  SelectTuBiaoDataYueLanShiCount();
/**
 * 周一到周日阅览室人数
 */
List<List<String>>   SelectTuBiaoZhouYueLanShiCount();

/**
 * 各个系的数量
 */
List<Map<Object, Object>>   SelectTuBiaoMeiiGeXiCount();
/**
 * 各个系下专业的数量
 */
List<Map<Object, Object>>   SelectTuBiaoMeiiGeZhuanYeCount();

}

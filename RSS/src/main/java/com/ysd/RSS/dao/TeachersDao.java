package com.ysd.RSS.dao;

import java.util.List;

import com.ysd.RSS.entity.Fenye;
import com.ysd.RSS.entity.Students;
import com.ysd.RSS.entity.Teachers;
import com.ysd.RSS.entity.VO.BingTu;

public interface TeachersDao {
	List<Teachers> selectTeaByAll(Fenye fenye);
	Integer selectTeaCount(Fenye fenye);
	Teachers selectTeaById(Integer tea_id);
	/**
	 * 查询阅览室老师在线人数
	 * @return
	 */
	List<BingTu> selectTeaByRR_NameAndCount();
	/**
	 * 修改老师所在阅览室
	 * @param teachers
	 * @return
	 */
	Integer updateTea_status(Teachers teachers);
}

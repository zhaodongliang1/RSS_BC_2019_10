package com.ysd.RSS.service;

import java.util.List;

import com.ysd.RSS.entity.Fenye;
import com.ysd.RSS.entity.Teachers;
import com.ysd.RSS.entity.VO.BingTu;

public interface TeachersService {
	Fenye selectTeaByAll(Fenye fenye);
	Integer exportExcelChu(String teaIds,String datagridTitle,String filePath);
	/**
	 * 查询阅览室老师在线人数
	 * @return
	 */
	List<BingTu> selectTeaByRR_NameAndCount();
}

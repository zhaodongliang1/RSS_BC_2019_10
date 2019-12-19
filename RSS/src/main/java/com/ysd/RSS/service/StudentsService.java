package com.ysd.RSS.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import com.ysd.RSS.entity.Fenye;
import com.ysd.RSS.entity.Students;
import com.ysd.RSS.entity.VO.BingTu;


public interface StudentsService {
	Fenye selectStuByAll(Fenye fenye);
	/**
	 * 导出excel
	 * @param stuIds
	 * @param datagridTitle
	 * @param filePath
	 * @return
	 */
	Integer exportExcelChu(String stuIds,String datagridTitle,String filePath);
	/**
	 * 查询阅览室在线人数
	 * @return
	 */
	List<BingTu> selectStuByRR_NameAndCount();
	/**
	 * 导入  添加
	 * @param file
	 * @return
	 */
	String insertStudents(MultipartFile file);
	
}

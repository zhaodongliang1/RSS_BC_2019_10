package com.ysd.RSS.service;

import java.util.List;

import com.ysd.RSS.entity.Computers;
import com.ysd.RSS.entity.Readrooms;
import com.ysd.RSS.entity.Students;

public interface ShuaKaService {
	/**
	 * 根据id查询阅览室名称
	 * @param RR_Id
	 * @return
	 */
	List<Readrooms> selectRR_Name(Integer RR_Id);
	/**
	 * 根据阅览室id查询电脑ip
	 * @param RR_Com_ReadRoomId
	 * @return
	 */
	List<Computers> selectCom_NameByID(Integer RR_Com_ReadRoomId);
	/**
	 * 刷卡进入
	 * @param Stu_cardno
	 * @return
	 */
	Integer ShuaKa(String cardno,Integer RR_Id);
}

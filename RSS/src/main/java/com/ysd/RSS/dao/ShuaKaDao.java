package com.ysd.RSS.dao;

import java.util.List;

import com.sun.org.glassfish.external.statistics.Statistic;
import com.ysd.RSS.entity.Computers;
import com.ysd.RSS.entity.Consumelogs;
import com.ysd.RSS.entity.Readrooms;
import com.ysd.RSS.entity.Students;

public interface ShuaKaDao {
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
	 * 根据卡号查询学生是否存在
	 * @param Stu_cardno
	 * @return
	 */
	Students selectStuByStu_cardno(String Stu_cardno);
	/**
	 * 根据卡号查询老师是否存在
	 * @param Stu_cardno
	 * @return
	 */
	Students selectTeaByTea_cardno(String Tea_cardno);
	/**
	 * 向记录表里添加一条刷卡记录
	 * @param consumelogs
	 * @return
	 */
	Integer insertConsumelogs(Consumelogs consumelogs);
	/**
	 * 根据阅览室id添加使用人次
	 * @param statistic
	 * @return
	 */
	Integer updateSta_PerpleNums(Integer RR_Sta_ReadRoomId);
	/**
	 * 刷卡出去修改记录表
	 * @param consumelogs
	 * @return
	 */
	Integer updateConsumelogs(Consumelogs consumelogs);
	/**
	 * 查看在不在阅览室
	 */
	Integer selectCon_Status(String Con_CardNO);
}

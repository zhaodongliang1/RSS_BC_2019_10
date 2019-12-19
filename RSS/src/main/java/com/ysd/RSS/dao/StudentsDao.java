package com.ysd.RSS.dao;

import java.util.List;


import com.ysd.RSS.entity.Fenye;
import com.ysd.RSS.entity.Students;

import com.ysd.RSS.entity.VO.BingTu;


public interface StudentsDao {
	/**
	 * 查询所有学生
	 * @param fenye
	 * @return
	 */
	List<Students> selectStuByAll(Fenye fenye);
	/**
	 * 查询学生总条数
	 * @param fenye
	 * @return
	 */
	Integer selectStuCount(Fenye fenye);
	/**
	 * 根据id查询学生
	 */
	Students selectStuById(Integer stu_id);
	/**
	 * 查询阅览室学生在线人数
	 * @return
	 */
	List<BingTu> selectStuByRR_NameAndCount();
	/**
	 * 修改学生所在阅览室
	 * @param students
	 * @return
	 */
	Integer updateStu_status(Students students);
	/**
	 * 导入   添加
	 * @param students
	 * @return
	 */
	Integer insertStudent(Students students);
	/**
	 * 根据卡号查询
	 * @param stu_cardno
	 * @return
	 */
	Students selectStudentByCardno(String stu_cardno);
	/**
	 * 根据卡号修改
	 * @param stu_cardno
	 * @return
	 */
	Integer updateStudent(Students students);

}

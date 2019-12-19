package com.ysd.RSS.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysd.RSS.dao.ShuaKaDao;
import com.ysd.RSS.dao.StudentsDao;
import com.ysd.RSS.dao.TeachersDao;
import com.ysd.RSS.entity.Computers;
import com.ysd.RSS.entity.Consumelogs;
import com.ysd.RSS.entity.Readrooms;
import com.ysd.RSS.entity.Students;
import com.ysd.RSS.entity.Teachers;
import com.ysd.RSS.service.ShuaKaService;
@Service
public class ShuaKaImpl implements ShuaKaService {
	@Autowired
	private ShuaKaDao shuaKaDao;
	@Autowired
	private StudentsDao studentsDao;
	@Autowired
	private TeachersDao teachersDao;
	@Override
	public List<Readrooms> selectRR_Name(Integer RR_Id) {
		// TODO Auto-generated method stub
		System.out.println(RR_Id);
		
		return shuaKaDao.selectRR_Name(RR_Id);
	}

	@Override
	public List<Computers> selectCom_NameByID(Integer RR_Com_ReadRoomId) {
		// TODO Auto-generated method stub
		System.out.println(RR_Com_ReadRoomId);
		
		return shuaKaDao.selectCom_NameByID(RR_Com_ReadRoomId);
	}
	@Transactional
	@Override
	public Integer ShuaKa(String cardno,Integer RR_Id) {
		
		//1.查询卡号是否存在		
		Students selectStuByStu_cardno = shuaKaDao.selectStuByStu_cardno(cardno);
		Students selectTeaByTea_cardno = shuaKaDao.selectTeaByTea_cardno(cardno);
		System.out.println("11111111111");
		if(selectStuByStu_cardno!=null||selectTeaByTea_cardno!=null) {
			System.out.println("222222");
			Consumelogs consumelogs = new Consumelogs();
			//2.判断在不在阅览室
			if(shuaKaDao.selectCon_Status(cardno)!=null) {
				System.out.println("3333333333");
				//3.刷卡退出
				RR_Id=0;
				Integer updateStatus=0;
				//修改学生所在阅览室
				if(selectStuByStu_cardno!=null) {
					System.out.println("44444444444");
					Students students = new Students();
					students.setStu_cardno(cardno);
					students.setStu_status(RR_Id);
					updateStatus= studentsDao.updateStu_status(students);
				}
				//修改老师所在阅览室
				if(selectTeaByTea_cardno!=null) {
					Teachers teachers = new Teachers();
					teachers.setTea_status(RR_Id);
					teachers.setTea_cardno(cardno);
					updateStatus = teachersDao.updateTea_status(teachers);
				}
				//修改记录表
				consumelogs.setCon_CardNO(cardno);				
				String Con_OutTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());				
				consumelogs.setCon_OutTime(Con_OutTime);
				consumelogs.setCon_Status(0);				
				Integer updateConsumelogs = shuaKaDao.updateConsumelogs(consumelogs);
				System.out.println("55555555555"+updateConsumelogs+updateStatus);
				if(updateConsumelogs==1&&updateStatus==1) {
					System.out.println("66666666666666");
					return 2;
				}
			}
			Integer updateStatus=0;
			//2.修改学生所在阅览室
			if(selectStuByStu_cardno!=null) {
				Students students = new Students();
				students.setStu_cardno(cardno);
				students.setStu_status(RR_Id);
				updateStatus= studentsDao.updateStu_status(students);
			}
			//3.修改老师所在阅览室
			if(selectTeaByTea_cardno!=null) {
				Teachers teachers = new Teachers();
				teachers.setTea_status(RR_Id);
				teachers.setTea_cardno(cardno);
				updateStatus = teachersDao.updateTea_status(teachers);
			}
			//4.添加一条记录
			
			consumelogs.setCon_CardNO(cardno);
			consumelogs.setCon_Status(1);
			consumelogs.setRR_Con_ReadRoomId(RR_Id);
			Integer insertConsumelogs = shuaKaDao.insertConsumelogs(consumelogs);
			//5.阅览室使用人次+1
			Integer updateSta_PerpleNums = shuaKaDao.updateSta_PerpleNums(RR_Id);
			System.out.println("77777777777777");
			if(insertConsumelogs==1&&updateSta_PerpleNums==1&&updateStatus==1) {
				System.out.println("88888888888888");
				return 1;
			}
			return 0;
		}
		return 0;
	}

}

package com.ysd.RSS.Jpadao;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ysd.RSS.entity.Readrooms;

public interface EcharsJpaDao  extends JpaRepository<Readrooms, Integer>{
	/**
	 * 各个时间段不同阅览室的人数
	 * @return
	 */
	 @Query(value="select \r\n" + 
	 		"a.name,\r\n" + 
	 		"sum(case when a.shijian=1 then  a.countt  else 0 end) 一月,\r\n" + 
	 		"sum(case when a.shijian=2 then  a.countt  else 0 end) 二月,\r\n" + 
	 		"sum(case when a.shijian=3 then  a.countt  else 0 end) 三月,\r\n" + 
	 		"sum(case when a.shijian=4 then a.countt else 0 end) 四月,\r\n" + 
	 		"sum(case when a.shijian=5 then a.countt  else 0 end) 五月,\r\n" + 
	 		"sum(case when a.shijian=6 then  a.countt  else 0 end) 六月,\r\n" + 
	 		"sum(case when a.shijian=7 then  a.countt  else 0 end) 七月,\r\n" + 
	 		"sum(case when a.shijian=8 then  a.countt  else 0 end) 八月,\r\n" + 
	 		"sum(case when a.shijian=9 then  a.countt  else 0 end) 九月,\r\n" + 
	 		"sum(case when a.shijian=10 then  a.countt  else 0 end) 十月,\r\n" + 
	 		"sum(case when a.shijian=11 then  a.countt  else 0 end) 十一月,\r\n" + 
	 		"sum(case when a.shijian=12 then  a.countt  else 0 end) 十二月\r\n" + 
	 		"FROM  (SELECT  MONTH(s.Sta_Data) as 'shijian',R.RR_Name as 'name',sum(s.Sta_PerpleNums)  as 'countt' \r\n" + 
	 		"			from readrooms r \r\n" + 
	 		"			INNER JOIN statistics s on r.RR_Id=s.RR_Sta_ReadRoomId where YEAR(s.Sta_Data)=YEAR(NOW())\r\n" + 
	 		"			GROUP BY MONTH(s.Sta_Data),R.RR_Name  ORDER BY  MONTH(s.Sta_Data)) a\r\n" + 
	 		"GROUP BY a.name",nativeQuery = true)
	 List<List<String>>   SelectTuBiaoDataYueLanShiCount();
	 /**
	  * 周一到周日阅览室人数
	  */
	 @Query(value="select \r\n" + 
	 		"a.name,\r\n" + 
	 		"sum(case when a.shijian=0 then  a.countt  else 0 end) 周一,\r\n" + 
	 		"sum(case when a.shijian=1 then  a.countt  else 0 end) 周二,\r\n" + 
	 		"sum(case when a.shijian=2 then  a.countt  else 0 end) 周三,\r\n" + 
	 		"sum(case when a.shijian=3 then  a.countt  else 0 end) 周四,\r\n" + 
	 		"sum(case when a.shijian=4 then a.countt else 0 end) 周五,\r\n" + 
	 		"sum(case when a.shijian=5 then a.countt  else 0 end) 周六, \r\n" + 
	 		"sum(case when a.shijian=6 then  a.countt  else 0 end) 周日\r\n" + 
	 		"FROM  (SELECT  WEEKDAY(s.Sta_Data) as 'shijian',R.RR_Name as 'name',sum(s.Sta_PerpleNums)  as 'countt' \r\n" + 
	 		"			from readrooms r \r\n" + 
	 		"			INNER JOIN statistics s on r.RR_Id=s.RR_Sta_ReadRoomId where YEAR(s.Sta_Data)=YEAR(NOW())\r\n" + 
	 		"			GROUP BY WEEKDAY(s.Sta_Data),R.RR_Name  ORDER BY  WEEKDAY(s.Sta_Data)) a\r\n" + 
	 		"GROUP BY a.name",nativeQuery = true)
	 List<List<String>>   SelectTuBiaoZhouYueLanShiCount();
	 /**
	  * 各个系的数量
	  */
	 @Query(value="SELECT count(m.mem_department) as 'value',m.mem_department as 'name'  from memberships m  GROUP BY m.mem_department ",nativeQuery = true)
	 List<Map<Object, Object>>   SelectTuBiaoMeiiGeXiCount();
	 /**
	  * 各个系下专业人数的数量
	  */
	 @Query(value="SELECT count(s.stu_mem_id) as 'value',m.mem_specialty as 'name'  from memberships m INNER JOIN students s on m.mem_id=s.stu_mem_id GROUP BY m.mem_specialty  ",nativeQuery = true)
	 List<Map<Object, Object>>   SelectTuBiaoMeiiGeZhuanYeCount();
	 
}

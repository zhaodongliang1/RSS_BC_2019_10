package com.ysd.RSS.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ysd.RSS.entity.Fenye;
import com.ysd.RSS.entity.Students;
import com.ysd.RSS.entity.VO.BingTu;
import com.ysd.RSS.service.StudentsService;
import com.ysd.RSS.service.TeachersService;

@RestController
@CrossOrigin
public class StudentsController {
	@Autowired
	private StudentsService studentsService;
	@Autowired
	private TeachersService teachersService;
	@PostMapping("/findAllStu")
	public Fenye findAllStu(@RequestParam(value="rows") Integer pageSize,Fenye fenye) {
		fenye.setPageSize(pageSize);
		fenye.setPage((fenye.getPage()-1)*pageSize);
		
		return studentsService.selectStuByAll(fenye);
	}
	@PostMapping("/exportExcelStuChu")
	public Integer exportExcelStuChu(String stuIds,String datagridTitle,String filePath) {		
		return studentsService.exportExcelChu(stuIds,datagridTitle, filePath);
	}
	@PostMapping("/selectStuByRR_NameAndCount")
	public List<BingTu> selectStuByRR_NameAndCount() {		
		return studentsService.selectStuByRR_NameAndCount();
	}
	
	
	@PostMapping("/selectByRR_NameAndCount")
	public List<BingTu> selectByRR_NameAndCount() {	
		List<BingTu> selectStuByRR_NameAndCount = studentsService.selectStuByRR_NameAndCount();
		List<BingTu> selectTeaByRR_NameAndCount = teachersService.selectTeaByRR_NameAndCount();
		System.out.println(selectStuByRR_NameAndCount+"111111111111111111111111111111");
		System.out.println(selectTeaByRR_NameAndCount+"22222222222222222222222222222222");
		
		if(selectStuByRR_NameAndCount.size()>selectTeaByRR_NameAndCount.size()) {
			for(int i=0;i<selectStuByRR_NameAndCount.size();i++) {//3			
				for(int j=0;j<selectTeaByRR_NameAndCount.size();j++) {//2				
					if(selectStuByRR_NameAndCount.get(i).getName().equals(selectTeaByRR_NameAndCount.get(j).getName())) {					
						selectStuByRR_NameAndCount.get(i).setValue((selectStuByRR_NameAndCount.get(i).getValue()+selectTeaByRR_NameAndCount.get(i).getValue()));				
					}					
				}				
			}
			return selectStuByRR_NameAndCount;
		}else {
			for(int i=0;i<selectTeaByRR_NameAndCount.size();i++) {//3			
				for(int j=0;j<selectStuByRR_NameAndCount.size();j++) {//2				
					if(selectTeaByRR_NameAndCount.get(i).getName().equals(selectStuByRR_NameAndCount.get(j).getName())) {					
						selectTeaByRR_NameAndCount.get(i).setValue((selectStuByRR_NameAndCount.get(i).getValue()+selectTeaByRR_NameAndCount.get(i).getValue()));				
					}					
				}				
			}
			return selectTeaByRR_NameAndCount;
		}
	}
	/**
	 * 导入  添加
	 * @param file
	 * @param request
	 * @param response
	 * @return
	 */
	@PostMapping(value="/insertStudents")
	@ResponseBody
	public String insertStudents(@RequestParam(value="file")MultipartFile file,HttpServletRequest request, HttpServletResponse response){
		String insertStudents = studentsService.insertStudents(file);
		return insertStudents;
	}
}

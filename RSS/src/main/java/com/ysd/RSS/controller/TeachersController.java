package com.ysd.RSS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.RSS.entity.Fenye;
import com.ysd.RSS.entity.VO.BingTu;
import com.ysd.RSS.service.StudentsService;
import com.ysd.RSS.service.TeachersService;

@RestController
@CrossOrigin
public class TeachersController {
	@Autowired
	private TeachersService teachersService;

	@PostMapping("/findAllTea")
	public Fenye findAllTea(@RequestParam(value = "rows") Integer pageSize, Fenye fenye) {
		fenye.setPageSize(pageSize);
		fenye.setPage((fenye.getPage() - 1) * pageSize);

		return teachersService.selectTeaByAll(fenye);
	}

	@PostMapping("/exportExcelTeaChu")
	public Integer exportExcelTeaChu(String teaIds,String datagridTitle,String filePath) {		
		return teachersService.exportExcelChu(teaIds,datagridTitle, filePath);
	}
	@PostMapping("/selectTeaByRR_NameAndCount")
	public List<BingTu> selectTeaByRR_NameAndCount() {		
		return teachersService.selectTeaByRR_NameAndCount();
	}
}
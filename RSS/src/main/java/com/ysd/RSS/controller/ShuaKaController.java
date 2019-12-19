package com.ysd.RSS.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;

import com.ysd.RSS.entity.Computers;
import com.ysd.RSS.entity.Readrooms;
import com.ysd.RSS.service.ShuaKaService;

@RestController
@CrossOrigin
public class ShuaKaController {
	@Autowired
	private ShuaKaService shuaKaService;
	@PostMapping("/selectRR_Name")
	public List<Readrooms> selectRR_Name(@Param(value="RR_Id") Integer RR_Id) {
		
		return shuaKaService.selectRR_Name(RR_Id);
	}
	@PostMapping("/selectCom_NameByID")
	public List<Computers> selectCom_NameByID(Integer RR_Com_ReadRoomId) {
		
		return shuaKaService.selectCom_NameByID(RR_Com_ReadRoomId);
	}
	@PostMapping("/ShuaKa")
	public Integer ShuaKa(String cardno,Integer RR_Id) {
		System.out.println(cardno+" "+RR_Id);
		return shuaKaService.ShuaKa(cardno, RR_Id);
	}
}

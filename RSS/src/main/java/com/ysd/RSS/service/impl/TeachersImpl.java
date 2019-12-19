package com.ysd.RSS.service.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ysd.RSS.dao.TeachersDao;
import com.ysd.RSS.entity.Fenye;
import com.ysd.RSS.entity.Teachers;
import com.ysd.RSS.entity.VO.BingTu;
import com.ysd.RSS.service.TeachersService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@Service
public class TeachersImpl implements TeachersService {
	@Autowired
	private TeachersDao teachersDao;
	@Override
	public Fenye selectTeaByAll(Fenye fenye) {
		// TODO Auto-generated method stub
		fenye.setRows(teachersDao.selectTeaByAll(fenye));
		fenye.setTotal(teachersDao.selectTeaCount(fenye));
		return fenye;
	}
	
	public Integer exportExcelChu(String teaIds,String datagridTitle,String filePath) {
		String[] tea_ids = teaIds.split(",");
		
		
		String[] Titles = datagridTitle.split(",");
/* String filePath="sample.xls";文件路径 */
			// 第一步，创建一个workbook，对应一个Excel文件
         HSSFWorkbook workbook = new HSSFWorkbook();
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
         HSSFSheet hssfSheet = workbook.createSheet("sheet1");
         // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
         HSSFRow hssfRow = hssfSheet.createRow(0);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle hssfCellStyle = workbook.createCellStyle();
        //居中样式
        hssfCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		HSSFCell hssfCell = null;		           

for(int i = 0; i < Titles.length-2; i++) { 
  hssfCell = hssfRow.createCell(i);//列索引从0开始 
  hssfCell.setCellValue(Titles[i+2]);//列名1
  hssfCell.setCellStyle(hssfCellStyle);//列居中显示
}
for(int i=0;i<tea_ids.length;i++) {
	Teachers selectTeaById=teachersDao.selectTeaById(Integer.parseInt(tea_ids[i]));
	 if(selectTeaById != null){    	
     		 HSSFRow createRow = hssfSheet.createRow(i+1);
     		 createRow.createCell(0).setCellValue(selectTeaById.getTea_id());
     		 createRow.createCell(1).setCellValue(selectTeaById.getTea_cardno());
     		 createRow.createCell(2).setCellValue(selectTeaById.getTea_name());		
     		 createRow.createCell(3).setCellValue(selectTeaById.getTea_sex());       		 
     		 createRow.createCell(4).setCellValue(selectTeaById.getReadrooms().getRR_Name());
     		 createRow.createCell(5).setCellValue(selectTeaById.getTea_remark());
     		 createRow.createCell(6).setCellValue(selectTeaById.getSections().getSec_name());			      	
  }
}            
        try {
        	FileOutputStream out = new FileOutputStream(filePath);		            	 
        	workbook.write(out);//保存Excel文件       	
        	out.close();//关闭文件流 
             return 1;
		} catch (IOException e) {
			e.printStackTrace();
			 return -1;
		}					 
}

	@Override
	public List<BingTu> selectTeaByRR_NameAndCount() {
		// TODO Auto-generated method stub
		return teachersDao.selectTeaByRR_NameAndCount();
	}

}

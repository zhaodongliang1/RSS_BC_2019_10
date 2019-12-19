package com.ysd.RSS.service.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ysd.RSS.dao.MembershipsDao;
import com.ysd.RSS.dao.StudentsDao;
import com.ysd.RSS.entity.Fenye;
import com.ysd.RSS.entity.Memberships;
import com.ysd.RSS.entity.Students;

import com.ysd.RSS.entity.VO.BingTu;

import com.ysd.RSS.service.StudentsService;
import com.ysd.RSS.util.StudentsExcelUtil;
@Service
public class StudentsImpl implements StudentsService {
	@Autowired
	private StudentsDao studentsDao;
	@Autowired
	private MembershipsDao membershipsDao;
	@Autowired
	private HttpServletRequest request;

	@Autowired
	private HttpServletResponse response;
	
	@Override
	public Fenye selectStuByAll(Fenye fenye) {
		// TODO Auto-generated method stub
		
		fenye.setRows(studentsDao.selectStuByAll(fenye));
		fenye.setTotal(studentsDao.selectStuCount(fenye));
		
		return fenye;
	}
	public Integer exportExcelChu(String stuIds,String datagridTitle,String filePath) {
		String[] stu_ids = stuIds.split(",");
		
		
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
for(int i=0;i<stu_ids.length;i++) {
	Students selectStuById=studentsDao.selectStuById(Integer.parseInt(stu_ids[i]));
	 if(selectStuById != null){    	
     		 HSSFRow createRow = hssfSheet.createRow(i+1);
     		 createRow.createCell(0).setCellValue(selectStuById.getStu_id());
     		 createRow.createCell(1).setCellValue(selectStuById.getStu_cardno());
     		 createRow.createCell(2).setCellValue(selectStuById.getStu_name());		
     		 createRow.createCell(3).setCellValue(selectStuById.getStu_sex());       		 
     		 createRow.createCell(4).setCellValue(selectStuById.getReadrooms().getRR_Name());
     		 createRow.createCell(5).setCellValue(selectStuById.getStu_remark());
     		 createRow.createCell(6).setCellValue(selectStuById.getStu_no());
     		 createRow.createCell(7).setCellValue(selectStuById.getMemberships().getMem_department());		
     		createRow.createCell(8).setCellValue(selectStuById.getMemberships().getMem_specialty());			
     		createRow.createCell(9).setCellValue(selectStuById.getMemberships().getMem_degree());			
     		
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
	public List<BingTu> selectStuByRR_NameAndCount() {
		// TODO Auto-generated method stub
		
		return studentsDao.selectStuByRR_NameAndCount();
	}
		@Override
		@Transactional
		public String insertStudents(MultipartFile file) {
			// 专业错误的list集合
			List<Students> ZhuanYeErrorList = new ArrayList<Students>();
			// excel需要的实体类
			Students students = new Students();
			//提示信息
			String res="";
			// 工具类
			StudentsExcelUtil excel = new StudentsExcelUtil();
			// 所有excel数据 的 对象集合
			List<Students> excelList = excel.getExcelInfo(file);
			//判断excel是否为空
			if (excelList != null && !excelList.isEmpty()) {
				//循环遍历excelList集合中的数据
				for (int i = 0; i < excelList.size(); i++) {
					// 判断专业是否存在
					Memberships selectMembershipsBySpecialty = membershipsDao.selectMembershipsBySpecialty(excelList.get(i).getStu_mem_id());
					//如果专业存在就获取专业编号   否则执行导出错误信息
					if (selectMembershipsBySpecialty != null) {
						// 根据卡号查询数据是否存在
						Students selectStudentByCardno = studentsDao.selectStudentByCardno(excelList.get(i).getStu_cardno());
						//如果不为空   执行修改  否则   执行添加
						if (selectStudentByCardno != null) {
							int mem_id = selectMembershipsBySpecialty.getMem_id();
							System.out.println("(修改)查询专业：" + selectMembershipsBySpecialty.toString());
							students.setStu_cardno(excelList.get(i).getStu_cardno());
							students.setStu_name(excelList.get(i).getStu_name());
							students.setStu_sex(excelList.get(i).getStu_sex());
							students.setStu_remark(excelList.get(i).getStu_remark());
							students.setStu_no(excelList.get(i).getStu_no());
							students.setStu_mem_id(String.valueOf(mem_id));
							studentsDao.updateStudent(students);
						}else {
							int mem_id = selectMembershipsBySpecialty.getMem_id();
							students.setStu_cardno(excelList.get(i).getStu_cardno());
							students.setStu_name(excelList.get(i).getStu_name());
							students.setStu_sex(excelList.get(i).getStu_sex());
							students.setStu_remark(excelList.get(i).getStu_remark());
							students.setStu_no(excelList.get(i).getStu_no());
							students.setStu_mem_id(String.valueOf(mem_id));
							studentsDao.insertStudent(students);
							
						}
					}else {
						//专业不存在
						ZhuanYeErrorList.add(excelList.get(i));
						res="专业填写错误";
					}
				}
				//判断是否有错误信息
				if(ZhuanYeErrorList.size()>1) {
					try {
						System.out.println(ZhuanYeErrorList);
						ErrorContent("卡号有重复", ZhuanYeErrorList);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			return res;
		}
		private HSSFWorkbook ErrorContent(String name, List<Students> list) throws Exception {
			String[] execlHeader = { "卡号", "姓名", "性别", "备注", "学号", "专业" };
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet(name);
			HSSFRow row = sheet.createRow((int) 0);
			HSSFCellStyle style = wb.createCellStyle();
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			for (short i = 0; i < execlHeader.length; i++) {
				HSSFCell cell = row.createCell(i);
				cell.setCellValue(execlHeader[i]);
				cell.setCellStyle(style);
				sheet.autoSizeColumn(i);
				sheet.setColumnWidth(i, 40 * 80);
			}

			for (int i = 0; i < list.size(); i++) {
				row = sheet.createRow(i + 1);
				Students students = list.get(i);
				if (students != null) {
					row.createCell(0).setCellValue(students.getStu_cardno());
					row.createCell(1).setCellValue(students.getStu_name());
					row.createCell(2).setCellValue(students.getStu_sex());
					row.createCell(3).setCellValue(students.getStu_remark());
					row.createCell(4).setCellValue(students.getStu_no());
					row.createCell(5).setCellValue(students.getStu_mem_id());
				}
			}
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-disposition", "attachment;filename=" + name + ".xls");
			OutputStream ouputStream = response.getOutputStream();
			wb.write(ouputStream);
			ouputStream.flush();
			ouputStream.close();
			return wb;
		}

}

package com.ysd.RSS.entity;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@DynamicUpdate
public class Students {
	@Id
	@GeneratedValue
	private Integer stu_id;
	private String stu_cardno;
	private String stu_name;
	private String stu_sex;
	private String stu_mem_id;
	private Integer stu_status;
	private String stu_remark;
	private String stu_no;	 
	private Memberships memberships;
	
	private Readrooms readrooms;
}

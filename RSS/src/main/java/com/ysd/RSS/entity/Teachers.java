package com.ysd.RSS.entity;


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
public class Teachers {
	@Id
	@GeneratedValue
	private Integer tea_id;
	private String tea_cardno;
	private String tea_name;
	private String tea_sex;
	private Integer tea_sec_id;
	private Integer tea_status;
	private String tea_remark;
	
	private Sections sections;
	private Readrooms readrooms;
}

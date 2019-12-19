package com.ysd.RSS.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Entity
@DynamicUpdate
@Component
public class Readrooms {
	@Id
	@GeneratedValue
	private Integer RR_Id;
	private String RR_Name;
	private String RR_Remark;
	private Integer RR_Ext1;
	private String RR_Ext2;
}

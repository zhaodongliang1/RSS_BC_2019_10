package com.ysd.RSS.entity;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@DynamicUpdate
@Component
public class Statistics {
	@Id
	@GeneratedValue
	private Integer Sta_Id;
	private Integer RR_Sta_ReadRoomId;
	private Integer Sta_PerpleNums;
	private String Sta_Data;
	private Integer Sta_Ext1;
	private String Sta_Ext2;
}

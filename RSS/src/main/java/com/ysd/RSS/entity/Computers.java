package com.ysd.RSS.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data

@Component
public class Computers {
	@Id
	@GeneratedValue
	private Integer Com_Id;
	private String Com_Name;
	private Integer RR_Com_ReadRoomId;
	private String Com_Ip;
	private Integer Com_Ext1;
	private String Com_Remark;
	private String Com_Ext2;
}

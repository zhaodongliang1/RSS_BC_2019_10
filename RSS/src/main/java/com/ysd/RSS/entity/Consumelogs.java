package com.ysd.RSS.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@DynamicUpdate
@Component
public class Consumelogs {
	@Id
	@GeneratedValue
	private Integer Con_Id;
	private String Con_CardNO;
	private Integer RR_Con_ReadRoomId;
	private String Con_InTime;
	private Integer Con_Status;
	private String Con_OutTime;
	private Integer Con_Ext1;
	private String Con_Ext2;
}

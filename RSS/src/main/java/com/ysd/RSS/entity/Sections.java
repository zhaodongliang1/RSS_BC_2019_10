package com.ysd.RSS.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@DynamicUpdate
@Component
public class Sections {
	@Id
	@GeneratedValue
	private Integer sec_id;
	private String sec_name;
	private String sec_remark;
}

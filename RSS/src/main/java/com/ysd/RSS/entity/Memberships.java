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
public class Memberships {
	@Id
	@GeneratedValue
	private Integer mem_id;
	private String mem_department;
	private String mem_specialty;
	private String mem_degree;
}

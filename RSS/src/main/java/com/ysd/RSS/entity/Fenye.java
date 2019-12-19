package com.ysd.RSS.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Fenye<T> {
	private Integer total;
	private Integer page;
	private Integer pageSize;
	private List<T> rows;

}

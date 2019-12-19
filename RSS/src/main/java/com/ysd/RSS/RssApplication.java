package com.ysd.RSS;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@MapperScan("com.ysd.RSS.dao")
@EnableJpaRepositories("com.ysd.RSS.Jpadao")
public class RssApplication {
	public static void main(String[] args) {
		SpringApplication.run(RssApplication.class, args);
	}
}
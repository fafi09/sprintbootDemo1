package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;


@ComponentScan(basePackages= {"com.example.controller","com.example.handler","com.example.service","com.example.test.datasource","com.example.test1.datasource"})
@MapperScan(basePackages= {"com.example.mapper","com.example.test1.mapper","com.example.test.mapper"})
@EnableJpaRepositories(basePackages= {"com.example.dao"})
@EntityScan(basePackages= {"com.example.entity"})
@EnableAutoConfiguration
//两个数据源设定
/*@ComponentScan(basePackages= {"com.example"})
@EnableAutoConfiguration*/
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

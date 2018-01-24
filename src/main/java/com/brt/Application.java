package com.brt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Import;

import com.brt.config.CasConfig;

@SpringBootApplication
@ServletComponentScan   //扫描Servlet 
@Import(CasConfig.class)
@MapperScan("com.brt.mapper")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

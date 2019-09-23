package com.jialei.myspringboot;

import com.jialei.myspringboot.bean.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SpringBootApplication
public class MyspringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyspringbootApplication.class, args);
		Logger logger = LoggerFactory.getLogger(MyspringbootApplication.class);
		logger.info("run application");
	}


	@Bean
	public Person getPerson(){
		return new Person();
	}
}

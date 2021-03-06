package com.jialei.myspringboot;

import com.jialei.myspringboot.demoreadconfig.bean.Person;
import com.jialei.myspringboot.util.LoggerUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@MapperScan("com.jialei.myspringboot.demomybatis.Dao")
@SpringBootApplication
@EnableCaching
@EnableRabbit
public class MyspringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyspringbootApplication.class, args);
		Logger logger = LoggerFactory.getLogger(MyspringbootApplication.class);
		logger.trace("run application");
		logger.debug("run application");
		logger.info("run application");
		logger.warn("run application");
		logger.error("run application");

		LoggerUtil.error(logger, "different error log");
	}



	@Bean
	public Person getPerson(){
		return new Person();
	}
}

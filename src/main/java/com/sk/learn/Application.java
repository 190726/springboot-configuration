package com.sk.learn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sk.learn.config.ExternalApiConfig.ExternalApi;

//@Import(MyDataSourceConfig.class) //설정파일이 다른 패키지에 존재한다면, 직접 import
@SpringBootApplication
public class Application {
	
	@Autowired ExternalApi api;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	ApplicationRunner applicationRunner() {
		return args ->{
			api.call();
		};
	}
}
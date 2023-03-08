package com.sk.learn.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(MyDataSourceProperties.class)
public class MyDataSourceConfig {

	private final MyDataSourceProperties properties;

	public MyDataSourceConfig(MyDataSourceProperties properties) {
		this.properties = properties;
	}

	@Bean
	public MyDataSource myDataSource() {
		return new MyDataSource(properties.getUrl(), 
				properties.getUsername(), 
				properties.getPassword(),
				properties.getEtc().getMaxConnection(),
				properties.getEtc().getTimeout(),
				properties.getEtc().getOptions());
	}
}
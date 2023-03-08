package com.sk.learn.config;

import java.time.Duration;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.time.DurationMax;
import org.hibernate.validator.constraints.time.DurationMin;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.validation.annotation.Validated;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ConstructorBinding // setter 가 아닌 생성자 매핑시  springboot 3.0 이전버전에서는 @ConstructorBinding을 선언해줘야 한다. 
@Getter
@ConfigurationProperties("my.datasource")
@Validated //검증기 적용
public class MyDataSourceProperties {
	
	@NotEmpty
	private String url;
	@NotEmpty
	private String username;
	@NotEmpty
	private String password;
	private Etc etc;

	public MyDataSourceProperties(String url, String username, String password, @DefaultValue Etc etc) {
		this.url = url;
		this.username = username;
		this.password = password;
		this.etc = etc;
	}

	@Getter
	public static class Etc {
		@Min(1)
		@Max(100)
		private int maxConnection;
		@DurationMin(seconds = 1)
		@DurationMax(seconds = 5)
		private Duration timeout;
		private List<String> options;

		public Etc(int maxConnection, Duration timeout, @DefaultValue("DEFAULT") List<String> options) {
			this.maxConnection = maxConnection;
			this.timeout = timeout;
			this.options = options;
		}
	}
}
package com.sk.learn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * program arguments(spring.profiles.active)값에 따라, 빈 생성을 다르게 한다.
 *
 */
@Configuration
public class ExternalApiConfig {
	
	@Profile({"default", "dev"})
	@Bean
	public ExternalApiDev externalApiDev() {
		return new ExternalApiDev();
	}
	
	@Profile("prod")
	@Bean
	public ExternalApiProd externalApiProd() {
		return new ExternalApiProd();
	}
	
	public static interface ExternalApi{
		void call();
	}
	
	public static class ExternalApiDev implements ExternalApi{
		@Override
		public void call() {
			System.out.println("dev api called");
		}
	}
	
	public static class ExternalApiProd implements ExternalApi{
		@Override
		public void call() {
			System.out.println("prod api called");
		}
	}
}

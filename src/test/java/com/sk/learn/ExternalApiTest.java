package com.sk.learn;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.sk.learn.config.ExternalApiConfig.ExternalApi;

@SpringBootTest
@ActiveProfiles("dev") // test에서 profile 설정가능, 또는 src/test/resources에 프로포티로 profile 설정 가능
public class ExternalApiTest {
	
	@Autowired ExternalApi api;
	
	@Test
	void apiTest() throws Exception {
		api.call();
	}
}
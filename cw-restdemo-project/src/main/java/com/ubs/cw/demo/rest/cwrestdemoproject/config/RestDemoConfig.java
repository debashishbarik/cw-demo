package com.ubs.cw.demo.rest.cwrestdemoproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestDemoConfig {

	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}

}

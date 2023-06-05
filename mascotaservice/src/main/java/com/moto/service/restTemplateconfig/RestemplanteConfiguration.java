package com.moto.service.restTemplateconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestemplanteConfiguration {
	
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

}

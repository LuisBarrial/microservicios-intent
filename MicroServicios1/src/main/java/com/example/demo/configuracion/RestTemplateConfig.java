package com.example.demo.configuracion;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import feign.Capability;
import feign.micrometer.MicrometerCapability;
import io.micrometer.core.instrument.MeterRegistry;

@Configuration
public class RestTemplateConfig {
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate(); 
	}
	@Bean
	public Capability capability(final MeterRegistry registry) {
	    return new MicrometerCapability(registry);
	}

}

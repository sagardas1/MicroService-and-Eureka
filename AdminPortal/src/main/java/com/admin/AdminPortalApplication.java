package com.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientAutoConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableEurekaClient
public class AdminPortalApplication {
	
	@Bean
	@LoadBalanced
	RestTemplate getRestTemplate() {
//		HttpComponentsClientHttpRequestFactory  clientHttpRequestFactory=new HttpComponentsClientHttpRequestFactory();
//		clientHttpRequestFactory.setConnectTimeout(3000);
		return new RestTemplate();
	}
	@Bean
	@LoadBalanced
	WebClient.Builder getBuilder(){
		return WebClient.builder();
	}


	public static void main(String[] args) {
		SpringApplication.run(AdminPortalApplication.class, args);
		
	}

}

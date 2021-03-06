package com.shopingCart;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;


import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@SpringBootApplication
@EnableEurekaClient
public class ShoppingCartProjectApplication {
	
	@Bean
	
	 public ModelMapper maper() {
		 return new ModelMapper();
	 }
	
	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartProjectApplication.class, args);
	}
	
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiDetails());
		
	}
	
	@SuppressWarnings("deprecation")
	@Bean
	private static ApiInfo apiDetails() {
		return new ApiInfo("Shopping Application", "Apis for Shopping-Cart. Copyright by Sagar Das", "Team", "sdbfhsd", "jsdbfj", "@void", "hsdbf");
	}
}

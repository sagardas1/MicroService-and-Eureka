package com.shopingCart.DemoPractice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleControllerClass {

	@GetMapping(value = "/sendHello", headers = "Accepts=application/json")
	public String sendHello(@RequestParam(name = "hello", required = false,
	defaultValue = "hello") String hello) {
		return hello;
	}

}

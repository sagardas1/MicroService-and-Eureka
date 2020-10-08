package com.shopingCart.demoServiceLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/abc")
public class MyController {
	@Qualifier("myServiceImpli")
	@Autowired
	private MyService myService;

	@Qualifier("otherServiceImpli")
	@Autowired
	private MyService myService1;

	@GetMapping(value = "/getname", headers = "Accept=application/json")
	public String getName() {
		System.out.println("dfghj");
		return myService1.getName("");
	}
	

	@GetMapping(value = "/name", headers = "Accept=application/json")
	public String name() {
		System.out.println("dfghj");
		return "sagar";
	}

	@GetMapping(value = "/param/{name}", headers = "Accept=application/json")
	public String param(@PathVariable String name) {

		return name;
	}

}

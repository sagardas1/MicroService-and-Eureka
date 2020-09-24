package com.shopingCart.demoServiceLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("myServiceImpli")
public class MyServiceImpli implements MyService {
	@SuppressWarnings("unused")
	@Autowired
	private Reposi reposi;

	public String getName(String name) {
		return "myServiceImpli";
	}

}

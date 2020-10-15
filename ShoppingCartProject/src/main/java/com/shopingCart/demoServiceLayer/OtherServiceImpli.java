package com.shopingCart.demoServiceLayer;

import org.springframework.stereotype.Service;

@Service("otherServiceImpli")
public class OtherServiceImpli implements MyService {

	@Override
	public String getName(String name) {
		return "otherServiceImpli";
	}

}

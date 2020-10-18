package com.shopingCart.revinewPack;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/revenue")
public class RevinewController {

	@GetMapping(value = "/getrevenue")
	public int getAllRevinew() {
		return 10;
	}

}

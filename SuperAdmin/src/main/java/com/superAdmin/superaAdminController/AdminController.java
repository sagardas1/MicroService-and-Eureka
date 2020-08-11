package com.superAdmin.superaAdminController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.superAdmin.adminService.AdminService;
import com.superAdmin.productVo.ProductPriceDetails;

@RestController
@RequestMapping("/superadmin")
public class AdminController {
	@Autowired
	public AdminService adminService;

	
	@GetMapping(value = "/getPriceOfProduct", headers = "Accept=application/json")
	public List<ProductPriceDetails> getPriceOfProduct() {
		List<ProductPriceDetails> productList = adminService.getPriceOfProduct();

		return productList;
	}

	@GetMapping(value = "/getName/{name}", headers = "Accept=application/json")
	public String name(@PathVariable(value="name")String name) {
		

		return name;
	}
}

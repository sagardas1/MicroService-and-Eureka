package com.superAdmin.adminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.superAdmin.productVo.ProductPriceDetails;

@Service
public class ProductPriceService {
	@Autowired
	RestTemplate getRestTemplate;

	// get price for product
	@HystrixCommand(fallbackMethod = "getPricedetailsFallback")
	public ProductPriceDetails getPricedetails(String name) {
		ProductPriceDetails productPriceDetails = null;
		productPriceDetails = getRestTemplate.getForObject("http://localhost:8080/product/viewproduct?name=" + name,
				ProductPriceDetails.class);
		return productPriceDetails;
	}

	// fall back method for getPriceOfProduct
	public ProductPriceDetails getPricedetailsFallback(String name) {
		ProductPriceDetails productPriceDetails = new ProductPriceDetails();
		productPriceDetails.setPrice(0.00);
		productPriceDetails.setProductName(name);

		return productPriceDetails;
	}

}

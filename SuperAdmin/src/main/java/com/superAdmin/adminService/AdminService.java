package com.superAdmin.adminService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.superAdmin.productVo.ProductList;
import com.superAdmin.productVo.ProductPriceDetails;
import com.superAdmin.productVo.ProductVo;

@Service
public class AdminService {
	@Autowired
	private RestTemplate getRestTemplate;

	public List<ProductPriceDetails> getPriceOfProduct() {

		ProductList listOfProduct = getRestTemplate
				.getForObject("http://localhost:8081/admin/allProducthavingQuantitygreaterThan5", ProductList.class);

		List<ProductPriceDetails> productPriceDetailsList = new ArrayList<>();

		for (ProductVo productVo : listOfProduct.getProductList()) {
			System.out.println("name:" + productVo.getProductName());
			ProductPriceDetails productPriceDetails = getRestTemplate.getForObject(
					"http://localhost:8080/product/viewproduct?name=" + productVo.getProductName(),
					ProductPriceDetails.class);
			productPriceDetailsList.add(productPriceDetails);
		}
		return productPriceDetailsList;
	}

}

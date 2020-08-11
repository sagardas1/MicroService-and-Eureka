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
	@SuppressWarnings("unused")
	@Autowired
	private RestTemplate getRestTemplate;
	@Autowired
	private ProductListService productListService;
	@Autowired
	private ProductPriceService productPriceService;

	public List<ProductPriceDetails> getPriceOfProduct() {

		ProductList listOfProduct = productListService.getListOfProduct();
		List<ProductPriceDetails> productPriceDetailsList = new ArrayList<>();

		for (ProductVo productVo : listOfProduct.getProductList()) {
			System.out.println("name:" + productVo.getProductName());
			ProductPriceDetails productPriceDetails = productPriceService.getPricedetails(productVo.getProductName());
			productPriceDetailsList.add(productPriceDetails);
		}
		return productPriceDetailsList;
	}


	


	// fallback method
	public List<ProductPriceDetails> getFallBackMethod() {
		List<ProductPriceDetails> list = new ArrayList<>();
		ProductPriceDetails details = new ProductPriceDetails();
		details.setPrice(0.00);
		details.setProductId(0);
		details.setProductName("");
		list.add(details);
		return list;
	}

}

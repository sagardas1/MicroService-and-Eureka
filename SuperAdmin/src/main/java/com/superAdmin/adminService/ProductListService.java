package com.superAdmin.adminService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.superAdmin.productVo.ProductList;
import com.superAdmin.productVo.ProductVo;

@Service
public class ProductListService {
	@Autowired
	RestTemplate getRestTemplate;
	
	
	// getting list of products
	@HystrixCommand(fallbackMethod = "getListOfProductFallBack")
	public ProductList getListOfProduct() {
		ProductList listOfProduct = null;

		listOfProduct = getRestTemplate.getForObject("http://localhost:8081/admin/allProducthavingQuantitygreaterThan5",
				ProductList.class);
		return listOfProduct;

	}
	
	
	// fall back method for getListOfProduct
		public ProductList getListOfProductFallBack() {
			ProductList list = new ProductList();
			List<ProductVo> productVos = new ArrayList<>();
			ProductVo productVo = new ProductVo();
			productVo.setProductName("Cake");
			productVos.add(productVo);
			list.setProductList(productVos);
			return list;
		}


}

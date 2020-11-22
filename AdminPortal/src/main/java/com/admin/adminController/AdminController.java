package com.admin.adminController;

import java.util.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.admin.adminService.AdminService;
import com.admin.baseResponce.BaseResponce;
import com.admin.productVo.ProductList;
import com.admin.productVo.ProductVo;
import com.admin.userVo.RegistrationBulk;
import com.admin.userVo.RegistrationVo;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired(required = true)
	public AdminService adminService;

	@ResponseBody
	@GetMapping(value = "/getallUsers", headers = "Accept=application/json")
	public RegistrationBulk getAllCostumers() {
		RegistrationBulk registrationBulk = adminService.getAllCostumers();

		return registrationBulk;

	}

	@ResponseBody
	@GetMapping(value = "/allProduct", headers = "Accept=application/json")
	public ProductList allProduct() {
		ProductList productList = adminService.allProduct();

		return productList;

	}
	

	@ResponseBody
	@PostMapping(value = "/insertProduct", headers = "Accept=application/json")
	public BaseResponce<Void> insertProduct(@RequestBody ProductVo product) {
		BaseResponce<Void> baseResponce = adminService.insertProduct(product);
		baseResponce.setTimeStamp(System.currentTimeMillis());

		return baseResponce;

	}

	@ResponseBody
	@DeleteMapping(value = "/deleteUser", headers = "Accept=application/json")
	public BaseResponce<Void> deleteUser(@RequestBody RegistrationVo registrationVo) {

		Map<String, Integer> map1 = new HashMap<String, Integer>();
		@SuppressWarnings("unused")
		BaseResponce<Void> baseResponce = adminService.deleteUser(registrationVo);
		baseResponce.setTimeStamp(System.currentTimeMillis());

		return null;

	}

	@ResponseBody
	@GetMapping(value = "/allProducthavingQuantitygreaterThan5", headers = "Accept=application/json")
	public ProductList allProducthavingQuantitygreaterThan5() {
		ProductList productList = new ProductList();
		List<ProductVo> product = adminService.allProducthavingQuantitygreaterThan5();
		productList.setProductList(product);
		return productList;
	}

	@GetMapping(value = "/{name}")
	public String getLastName(@PathVariable String name) {
		System.out.println(name);
		return name;
	}

	@ResponseBody
	@GetMapping(value = "/deleteproduct", headers = "Accept=application/json")
	public int deletePoduct(@RequestParam int productId) {

		@SuppressWarnings("unused")
		int i = adminService.deletePoduct(productId);

		return 0;
	}

}

package com.admin.adminController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.admin.adminService.AdminService;
import com.admin.baseResponce.BaseResponce;
import com.admin.productVo.ProductList;
import com.admin.productVo.ProductVo;
import com.admin.userVo.RegistrationBulk;
import com.admin.userVo.RegistrationVo;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired(required=true)
	public AdminService adminService;
	
	
	@GetMapping(value="/getallUsers",headers="Accept=application/json")
	public RegistrationBulk getAllCostumers(){
		RegistrationBulk registrationBulk=adminService.getAllCostumers();
		
		return registrationBulk;
		
	}
	
	@GetMapping(value="/allProduct",headers="Accept=application/json")
	public ProductList allProduct(){
		ProductList productList=adminService.allProduct();
		
		return productList;
		
	}
	@PostMapping(value="/insertProduct",headers="Accept=application/json")
	public BaseResponce insertProduct(@RequestBody ProductVo product){
		BaseResponce baseResponce=adminService.insertProduct(product);
		
		return baseResponce;
		
	}
	
	@DeleteMapping(value="/deleteUser",headers="Accept=application/json")
	public BaseResponce deleteUser(@RequestBody RegistrationVo registrationVo){
		BaseResponce baseResponce=adminService.deleteUser(registrationVo);
		
		return null;
		
	}
	@GetMapping(value="/allProducthavingQuantitygreaterThan5",headers="Accept=application/json")
	public ProductList allProducthavingQuantitygreaterThan5(){
		ProductList productList=new ProductList();
		List<ProductVo> product=adminService.allProducthavingQuantitygreaterThan5();
		productList.setProductList(product);
		return productList;}

}

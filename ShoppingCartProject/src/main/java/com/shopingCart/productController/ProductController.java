package com.shopingCart.productController;

import java.util.List;

import javax.validation.constraints.Past;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shopingCart.baseResponce.BaseResponce;
import com.shopingCart.productService.ProductService;
import com.shopingCart.productVo.BasketInfo;
import com.shopingCart.productVo.ProductList;
import com.shopingCart.productVo.ProductPriceDetails;
import com.shopingCart.productVo.ProductVo;
import com.shopingCart.userVo.UserBasket;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	public ProductService productService;

	@PostMapping(value = "/insertProduct", headers = "Accept=application/json")
	public BaseResponce insertProduct(@RequestBody ProductVo productVo) {

		BaseResponce baseResponce = null;
		try {
			baseResponce=productService. insertProduct(productVo);
		} catch (Exception e) {
			System.out.println(e);
		}
		return baseResponce;
	}
	@GetMapping(value = "/viewallproduct", headers = "Accept=application/json")
	public ProductList viewAllProduct() {
		ProductList proList=new ProductList();
		List<ProductVo> productList = null;
		try {
			productList=productService.viewAllProduct();
			proList.setProductList(productList);
		} catch (Exception e) {
			System.out.println(e);
		}
		return proList;
	}
	
	@PostMapping(value = "/addToCart", headers = "Accept=application/json")
	public BaseResponce addToCart(@RequestBody UserBasket userBasket) {

		BaseResponce baseResponce = null;
		try {
			baseResponce=productService.addToCart(userBasket);
		} catch (Exception e) {
			System.out.println(e);
		}
		return baseResponce;
	}
	
	@GetMapping(value = "/viewcart", headers = "Accept=application/json")
	public BasketInfo viewCart(@RequestParam String email) {

		BasketInfo basketInfo = null;
		try {
			basketInfo=productService.viewCart(email);
		} catch (Exception e) {
			System.out.println(e);
		}
		return basketInfo;
	}
	
	@PostMapping(value = "/payment", headers = "Accept=application/json")
	public BasketInfo payment(@RequestBody BasketInfo basketInfo) {

		try {
			basketInfo=productService.payment(basketInfo);
		} catch (Exception e) {
			System.out.println(e);
		}
		return basketInfo;
	}
	@DeleteMapping(value = "/payment", headers = "Accept=application/json")
	public BaseResponce removeProductFromCart(@RequestBody UserBasket userBasket) {

		BaseResponce baseResponce = null;
		try {
			baseResponce=productService. removeProductFromCart(userBasket);
		} catch (Exception e) {
			System.out.println(e);
		}
		return baseResponce;
	
	}
	
	@GetMapping(value = "/viewproduct", headers = "Accept=application/json")
	public ProductPriceDetails viewProduct(@RequestParam String name) {
		ProductPriceDetails product=null;
		try {
			product=productService .viewProduct(name);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return product;
	}
	
	@GetMapping(value="/name",headers="Accept=application/json")
	public String getName(@RequestParam(value="name",required=false,defaultValue="sdfg") String name) {
		return name;
	}
	
	
	
}

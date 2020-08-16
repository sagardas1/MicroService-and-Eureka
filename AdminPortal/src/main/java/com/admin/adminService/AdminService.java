package com.admin.adminService;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.admin.baseResponce.BaseResponce;
import com.admin.productDao.ProductRepository;
import com.admin.productVo.ProductList;
import com.admin.productVo.ProductVo;
import com.admin.userVo.RegistrationBulk;
import com.admin.userVo.RegistrationVo;

@Service
public class AdminService {
	@Autowired
	private RestTemplate getRestTemplate;
	@Autowired
	private WebClient.Builder getBuilder;

	@Autowired
	private ProductRepository productRepository;

	public RegistrationBulk getAllCostumers() {
		RegistrationBulk registrationBulk=null;
	//	registrationBulk=	getRestTemplate.getForObject("http://SHOPPING-CART/user/getAllRegistration", RegistrationBulk.class);
		registrationBulk=	getBuilder.build()//WebClient
				  .get()//depens on which rest-method u r calling
		          .uri("http://SHOPPING-CART/user/getAllRegistration")//Url which you need to access	
		          .retrieve()//fetch data according to url.
		          .bodyToMono(RegistrationBulk.class)//whatever body you get,convert it into this class
		          .block();
		return registrationBulk;
	}

	public ProductList allProduct() {
		ProductList list=getRestTemplate.getForObject("http://SHOPPING-CART/product/viewallproduct", ProductList.class);
	//	getRestTemplate.po
		@SuppressWarnings("unused")
		ProductList s=getBuilder
				.build()
				.get()
				.uri("",ProductList.class)
				.retrieve()
				.bodyToMono(ProductList.class)
				.block();
		return list;
	}

	public BaseResponce insertProduct(ProductVo product) {
		try {
		BaseResponce baseResponce=
				getRestTemplate.postForObject("http://SHOPPING-CART/product/insertProduct", product, BaseResponce.class);
		return baseResponce;
		}catch(ArithmeticException | NullPointerException ee) {
			ee.printStackTrace();
		}
		return null;
	}

	public BaseResponce deleteUser(RegistrationVo registrationVo) {
		getRestTemplate.delete("http://SHOPPING-CART/user/deleteRegistation", registrationVo);
		return null;
	}

	public List<ProductVo> allProducthavingQuantitygreaterThan5() {
		List<ProductVo> list=	productRepository.allProducthavingQuantitygreaterThan5();
		
		return list;
	}
	@PostConstruct
	public void init() {
		int a=20;
		int b=30;
		System.out.println(a+b);
		
	}
	@PreDestroy
	public void destroy() {}

	public int deletePoduct(int productId) {
		// TODO Auto-generated method stub
		return 0;
	}

}

package com.admin.adminService;


import org.springframework.web.bind.annotation.GetMapping;

import com.admin.userVo.RegistrationBulk;

//@FeignClient(name= "sagar" ,url="http://localhost:8080/")
public interface AdminDao {

	
	
	@GetMapping("ShoppingCartProject/user/userregistration")
	RegistrationBulk getAll();
	
}

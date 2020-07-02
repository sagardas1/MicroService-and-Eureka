package com.shopingCart.userController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shopingCart.baseResponce.BaseResponce;
import com.shopingCart.userService.UserService;
import com.shopingCart.userVo.RegistrationBulk;
import com.shopingCart.userVo.RegistrationVo;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	public UserService userService;
	
	
	@PostMapping(value="/userregistration",headers="Accept=application/json")
	public BaseResponce userRegistration(@RequestBody RegistrationVo registration) {
		BaseResponce baseResponce=null;
		
		baseResponce=	userService.userRegistration(registration);
		return baseResponce;
	}
	
	@GetMapping(value="/login",headers="Accept=application/json")
	public BaseResponce login( @RequestParam String email,@RequestParam String password ) {
		BaseResponce baseResponce=null;
		
		baseResponce=	userService.login(email,password);
		return baseResponce;
	}
	@GetMapping(value="/getAllRegistration",headers="Accept=application/json")
	public RegistrationBulk getAllRegistration( ) {
		
		RegistrationBulk list=	userService.getAllRegistration();
		return list;
	}
	
	@DeleteMapping(value="/deleteRegistation",headers="Accept=application/json")
	public BaseResponce deleteRegistation(@RequestBody RegistrationVo registrationVo) {
		
		BaseResponce baseResponce=	userService.deleteRegistation(registrationVo);
		return baseResponce;
	}
	@GetMapping(value="/sendOtP",headers="Accept=application/json")
	public String sendOtP( ) {
		
		
		return userService.sendOtP();
	}
	
	@GetMapping(value="/checkOtp",headers="Accept=application/json")
	public BaseResponce checkOtp(@RequestParam String otp ) {
		
		BaseResponce baseResponce=new BaseResponce();
		baseResponce= userService.checkOtp(otp);
		return baseResponce;
	}

}

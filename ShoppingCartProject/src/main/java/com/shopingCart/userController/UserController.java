package com.shopingCart.userController;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shopingCart.baseResponce.BaseResponce;
import com.shopingCart.responceConstants.ResponceConstants;
import com.shopingCart.userService.UserService;
import com.shopingCart.userVo.RegistrationBulk;
import com.shopingCart.userVo.RegistrationVo;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	public UserService userService;
	@Autowired
	private ModelMapper mapper;

	@Transactional
	@PostMapping(value = "/userregistration", headers = "Accept=application/json")
	public BaseResponce<Void> userRegistration1(@RequestBody Object registration) {
		BaseResponce<Void> baseResponce = null;
		RegistrationVo registrationVo = mapper.map(registration, RegistrationVo.class);

		// baseResponce = userService.userRegistration(registration);
		baseResponce.setTimeStamp(System.currentTimeMillis());
		return baseResponce;
	}
	
	
	
	

	@Transactional
	@PostMapping(value = "/userregistration", headers = "Accept=application/json")
	public BaseResponce<Void> userRegistration(@RequestBody RegistrationVo registration) {
		BaseResponce<Void> baseResponce = null;

		baseResponce = userService.userRegistration(registration);
		baseResponce.setTimeStamp(System.currentTimeMillis());
		return baseResponce;
	}

	@PostMapping(value = "/updateuserregistration", headers = "Accept=application/json")
	public BaseResponce<Void> updateUserRegistration(@RequestBody RegistrationVo registration) {
		BaseResponce<Void> baseResponce = null;

		baseResponce = userService.updateUserRegistration(registration);
		baseResponce.setTimeStamp(System.currentTimeMillis());
		return baseResponce;
	}

	@GetMapping(value = "/login", headers = "Accept=application/json")
	public BaseResponce<Void> login(@RequestParam String email, @RequestParam String password) {
		BaseResponce<Void> baseResponce = null;

		baseResponce = userService.login(email, password);
		baseResponce.setTimeStamp(System.currentTimeMillis());
		return baseResponce;
	}

	@GetMapping(value = "/getAllRegistration", headers = "Accept=application/json")
	public RegistrationBulk getAllRegistration() {

		RegistrationBulk list = userService.getAllRegistration();
		return list;
	}

	@DeleteMapping(value = "/deleteRegistation", headers = "Accept=application/json")
	public BaseResponce<Void> deleteRegistation(@RequestBody RegistrationVo registrationVo) {

		BaseResponce<Void> baseResponce = userService.deleteRegistation(registrationVo);
		baseResponce.setTimeStamp(System.currentTimeMillis());
		return baseResponce;
	}

	@GetMapping(value = "/sendOtP", headers = "Accept=application/json")
	public BaseResponce<Void> sendOtP(@RequestParam String email) {
		BaseResponce<Void> baseResponce = userService.sendOtP(email);
		baseResponce.setTimeStamp(System.currentTimeMillis());
		return baseResponce;
	}

	@GetMapping(value = "/checkOtp", headers = "Accept=application/json")
	public BaseResponce<Void> checkOtp(@RequestParam String otp) {

		BaseResponce<Void> baseResponce = new BaseResponce<Void>();
		baseResponce = userService.checkOtp(otp);
		baseResponce.setTimeStamp(System.currentTimeMillis());
		return baseResponce;
	}

	@GetMapping(value = "/namecheck/{name}", headers = "Accept=application/json")
	public BaseResponce<Void> nameCheck(@PathVariable(value = "name") String name) {
		BaseResponce<Void> baseResponce = new BaseResponce<Void>();
		baseResponce.setTimeStamp(System.currentTimeMillis());
		baseResponce.setStatusCode(ResponceConstants.SUCCESS_CREATED);
		baseResponce.setStatusMessage(name);
		return baseResponce;

	}

}

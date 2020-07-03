package com.shopingCart.userService;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopingCart.baseResponce.BaseResponce;
import com.shopingCart.purchasseMessagingService.PurchaseMessageingService;
import com.shopingCart.responceConstants.ResponceConstants;
import com.shopingCart.userDao.LoginDAO;
import com.shopingCart.userDao.UserDoa;
import com.shopingCart.userVo.LoginVo;
import com.shopingCart.userVo.RegistrationBulk;
import com.shopingCart.userVo.RegistrationVo;

@Service
public class UserService {

	@Autowired
	public UserDoa userDao;
	@Autowired(required = true)
	public LoginDAO loginDAO;
	@Autowired
	PurchaseMessageingService purchaseMessageingService;
	
	public static String OTP=null;
	public BaseResponce userRegistration(RegistrationVo registration) {
		BaseResponce baseResponce = new BaseResponce();
		

		try {
			if (registration.getPassword().equals(registration.getConfirmPassword())) {
				RegistrationVo regis = userDao.getUserRegistrationByEmail(registration.getEmail());
				if (regis == null) {

					// roleId=1//users
					// roleId=2 ,admin
					registration.setRoleId(2);
					userDao.save(registration);
					userDao.insertIntoLogin(registration.getEmail(), registration.getPassword());
					baseResponce.setStatusCode(ResponceConstants.SUCCESS_CREATED);
					baseResponce.setStatusMessage(ResponceConstants.SUCESS_MESSAGE);
				} else {
					baseResponce.setStatusCode(ResponceConstants.FAILED);
					baseResponce.setStatusMessage(ResponceConstants.FAIL_MESSAGE);
				}
			} else {
				baseResponce.setStatusCode(ResponceConstants.FAILED);
				baseResponce.setStatusMessage(ResponceConstants.PASSWORD_DIDNT_MATCH);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return baseResponce;
	}

	public BaseResponce login(String email, String password) {
		BaseResponce baseResponce = null;
		try {
			LoginVo loginCrendetial = loginDAO.findUserLogin(email, password);
			// System.out.println(new Gson().toJson(loginCrendetial));
			baseResponce = new BaseResponce();
			if (loginCrendetial != null) {
				baseResponce.setStatusCode(ResponceConstants.SUCCESS_CREATED);
				baseResponce.setStatusMessage(ResponceConstants.SUCESS_MESSAGE_LOGIN);

			} else {
				baseResponce.setStatusCode(ResponceConstants.FAILED);
				baseResponce.setStatusMessage(ResponceConstants.FAILED_MESSAGE_LOGIN);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return baseResponce;
	}

	public RegistrationBulk getAllRegistration() {
		RegistrationBulk bulk = new RegistrationBulk();
		List<RegistrationVo> registrationVos = null;
		registrationVos = userDao.getAllRegistration();
		bulk.setRegistrationList(registrationVos);
		return bulk;
	}

	public BaseResponce deleteRegistation(RegistrationVo registrationVo) {
		BaseResponce baseResponce = null;
		int deleteRegistration = userDao.deleteRegistation(registrationVo.getEmail());
		int deleteLogin = loginDAO.deleteLogin(registrationVo.getEmail());
		baseResponce = new BaseResponce();
		if (deleteRegistration > 0 && deleteLogin > 0) {
			baseResponce.setStatusCode(ResponceConstants.SUCCESS_CREATED);
			baseResponce.setStatusMessage(ResponceConstants.DELETE_MESSAGE);
		} else {
			baseResponce.setStatusCode(ResponceConstants.FAILED);
			baseResponce.setStatusMessage(ResponceConstants.FAIL_MESSAGE);
		}
		return baseResponce;
	}

	public BaseResponce sendOtP(String email) {
		LoginVo loginVo=null;
		BaseResponce baseResponce=new BaseResponce();
		loginVo=	loginDAO.findUser(email);
	if(loginVo!=null) {
		 Random rand = new Random(); 
		 double arandom=rand.nextDouble();
		 String stringRaandom=Double.toString(arandom);
		 stringRaandom=stringRaandom.substring(2, 8);
		 OTP=stringRaandom;	
		 purchaseMessageingService.sendOTPinEmail(email, OTP);
		 baseResponce.setStatusCode(ResponceConstants.SUCCESS_CREATED);
			baseResponce.setStatusMessage(ResponceConstants.DELETE_MESSAGE);
			return baseResponce;
	}else {
		baseResponce.setStatusCode(ResponceConstants.FAILED);
		baseResponce.setStatusMessage(ResponceConstants.FAIL_MESSAGE);
		return baseResponce;
	}
	
	}
	
	public static void main(String[] args) {

		String baseResponce=null;
		baseResponce="please insert valid price for this test";
		try {
			String a = "122";
			a = (a.trim()).replace(",", "");
			double b = Double.parseDouble(a);
			
			 Random rand = new Random(); 
			 double arandom=rand.nextDouble();
			 String stringRaandom=Double.toString(arandom);
			 stringRaandom=stringRaandom.substring(2, 8);
			 OTP=stringRaandom;	
			 System.out.println(stringRaandom);
			
			
			
			}catch(Exception e) {
			e.printStackTrace();
			}
	}

	public BaseResponce checkOtp(String otp) {
		BaseResponce baseResponce=new BaseResponce();
		if(otp.equals(OTP)) {
			baseResponce.setStatusCode(ResponceConstants.SUCCESS_CREATED);
			baseResponce.setStatusMessage(ResponceConstants.SUCESS_MESSAGE);
		}else {
			baseResponce.setStatusCode(ResponceConstants.FAILED);
			baseResponce.setStatusMessage(ResponceConstants.FAIL_MESSAGE);
		}
		return baseResponce;
	}

}

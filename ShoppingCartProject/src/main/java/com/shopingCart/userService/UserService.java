package com.shopingCart.userService;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shopingCart.baseResponce.BaseResponce;
import com.shopingCart.purchasseMessagingService.PurchaseMessageingService;
import com.shopingCart.responceConstants.ResponceConstants;
import com.shopingCart.userDao.LoginDAO;
import com.shopingCart.userDao.UserDoa;
import com.shopingCart.userVo.LoginVo;
import com.shopingCart.userVo.RegistrationBulk;
import com.shopingCart.userVo.RegistrationVo;

@Transactional
@Service
public class UserService {

	@Autowired
	public UserDoa userDao;
	@Autowired(required = true)
	public LoginDAO loginDAO;
	@Autowired
	PurchaseMessageingService purchaseMessageingService;

	public static String OTP = null;

	@Transactional
	public BaseResponce<Void> userRegistration(RegistrationVo registration) {
		BaseResponce<Void> baseResponce = new BaseResponce<Void>();

		try {
			if (registration.getPassword().equals(registration.getConfirmPassword())) {
		
				registration.setRoleId(2);
				userDao.save(registration);

				baseResponce.setStatusCode(ResponceConstants.SUCCESS_CREATED);
				baseResponce.setStatusMessage(ResponceConstants.SUCESS_MESSAGE);
//				} else {
//					baseResponce.setStatusCode(ResponceConstants.FAILED);
//					baseResponce.setStatusMessage(ResponceConstants.FAIL_MESSAGE);
//				}
			} else {
				baseResponce.setStatusCode(ResponceConstants.FAILED);
				baseResponce.setStatusMessage(ResponceConstants.PASSWORD_DIDNT_MATCH);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return baseResponce;
	}

	public BaseResponce<Void> login(String email, String password) {
		BaseResponce<Void> baseResponce = null;
		try {
			LoginVo loginCrendetial = loginDAO.findUserLogin(email, password);
			baseResponce = new BaseResponce<Void>();
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

	public BaseResponce<Void> deleteRegistation(RegistrationVo registrationVo) {
		BaseResponce<Void> baseResponce = null;
		int deleteRegistration = userDao.deleteRegistation(registrationVo.getEmail());
		LoginVo loginVo = new LoginVo();
		loginVo.setEmail(registrationVo.getEmail());
		loginDAO.deleteLongin(loginVo.getEmail());
		baseResponce = new BaseResponce<Void>();
		if (deleteRegistration > 0) {
			baseResponce.setStatusCode(ResponceConstants.SUCCESS_CREATED);
			baseResponce.setStatusMessage(ResponceConstants.DELETE_MESSAGE);
		} else {
			baseResponce.setStatusCode(ResponceConstants.FAILED);
			baseResponce.setStatusMessage(ResponceConstants.FAIL_MESSAGE);
		}
		return baseResponce;
	}

	public BaseResponce<Void> sendOtP(String email) {
		LoginVo loginVo = null;
		BaseResponce<Void> baseResponce = new BaseResponce<Void>();
		loginVo = loginDAO.findUser(email);
		if (loginVo != null) {
			Random rand = new Random();
			double arandom = rand.nextDouble();
			String stringRaandom = Double.toString(arandom);
			stringRaandom = stringRaandom.substring(2, 8);
			OTP = stringRaandom;
			purchaseMessageingService.sendOTPinEmail(email, OTP);
			baseResponce.setStatusCode(ResponceConstants.SUCCESS_CREATED);
			baseResponce.setStatusMessage(ResponceConstants.DELETE_MESSAGE);
			return baseResponce;
		} else {
			baseResponce.setStatusCode(ResponceConstants.FAILED);
			baseResponce.setStatusMessage(ResponceConstants.FAIL_MESSAGE);
			return baseResponce;
		}

	}

	public static void main(String[] args) {

		@SuppressWarnings("unused")
		String baseResponce = null;
		baseResponce = "please insert valid price for this test";
		try {
			String a = "122";
			a = (a.trim()).replace(",", "");
			@SuppressWarnings("unused")
			double b = Double.parseDouble(a);

			Random rand = new Random();
			double arandom = rand.nextDouble();
			String stringRaandom = Double.toString(arandom);
			stringRaandom = stringRaandom.substring(2, 8);
			OTP = stringRaandom;
			System.out.println(stringRaandom);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public BaseResponce<Void> checkOtp(String otp) {
		BaseResponce<Void> baseResponce = new BaseResponce<Void>();
		if (otp.equals(OTP)) {
			baseResponce.setStatusCode(ResponceConstants.SUCCESS_CREATED);
			baseResponce.setStatusMessage(ResponceConstants.SUCESS_MESSAGE);
		} else {
			baseResponce.setStatusCode(ResponceConstants.FAILED);
			baseResponce.setStatusMessage(ResponceConstants.FAIL_MESSAGE);
		}
		return baseResponce;
	}

	public BaseResponce<Void> deleteUserPermanently(RegistrationVo registration) {
		BaseResponce<Void> baseResponce = new BaseResponce<Void>();
		userDao.delete(registration);
		baseResponce.setStatusCode(ResponceConstants.SUCCESS_CREATED);
		baseResponce.setStatusMessage(ResponceConstants.DELETE_MESSAGE);

		return baseResponce;
	}

	public BaseResponce<Void> updateUserRegistration(RegistrationVo registration) {
		BaseResponce<Void> baseResponce = new BaseResponce<Void>();

		try {

			RegistrationVo regis = userDao.getUserRegistrationByEmail(registration.getEmail());
			RegistrationVo update = new RegistrationVo();
			update = regis;
			if (regis != null) {

				// roleId=1//users
				// roleId=2 ,admin
				regis.setRoleId(2);
				regis.setConfirmPassword(registration.getConfirmPassword());
				regis.setPassword(registration.getPassword());

				userDao.delete(regis);
				userDao.save(update);

				baseResponce.setStatusCode(ResponceConstants.SUCCESS_CREATED);
				baseResponce.setStatusMessage(ResponceConstants.SUCESS_MESSAGE);
			} else {
				baseResponce.setStatusCode(ResponceConstants.FAILED);
				baseResponce.setStatusMessage(ResponceConstants.FAIL_MESSAGE);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return baseResponce;

	}

}

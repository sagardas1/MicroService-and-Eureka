package com.shopingCart.userService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopingCart.baseResponce.BaseResponce;
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

}

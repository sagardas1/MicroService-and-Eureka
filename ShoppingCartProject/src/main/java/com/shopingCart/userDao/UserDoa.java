package com.shopingCart.userDao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shopingCart.userVo.LoginVo;
import com.shopingCart.userVo.RegistrationVo;
@Transactional
@Repository
public interface UserDoa extends CrudRepository<RegistrationVo,Long>{
	
	@Transactional
	@Query(value="select * from registration where email = :email",nativeQuery=true)
	RegistrationVo getUserRegistrationByEmail(@Param("email") String email);

	@Transactional
	@Modifying
	@Query(value="insert into login (email,password) values(:email,:password)",nativeQuery=true)
	void insertIntoLogin(String email, String password);

	@Transactional
	@Query(value="select * from login where email = :email AND password = :password",nativeQuery=true)
	List<LoginVo> findUserLogin(@Param("email") String email, @Param("password") String password);

	
	@Transactional
	@Query(value="select * from registration",nativeQuery=true)
	List<RegistrationVo> getAllRegistration();

	@Transactional
	@Modifying
	@Query(value="DELETE FROM registration WHERE email=:email",nativeQuery=true)
	int deleteRegistation(@Param("email")String email);

}

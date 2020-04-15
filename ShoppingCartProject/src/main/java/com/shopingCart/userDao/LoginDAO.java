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


@Repository
@Transactional
public interface LoginDAO  extends CrudRepository<LoginVo,Long>{
	
	@Transactional
	@Query(value="select * from login where email = :email AND password = :password",nativeQuery=true)
	LoginVo findUserLogin(@Param("email") String email, @Param("password") String password);
	
	@Transactional
	@Modifying
	@Query(value="DELETE FROM login WHERE  email=:email",nativeQuery=true)
	int deleteLogin(@Param("email")String email);


}

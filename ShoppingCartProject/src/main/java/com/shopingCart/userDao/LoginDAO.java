package com.shopingCart.userDao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shopingCart.userVo.LoginVo;


@Repository
@Transactional
public interface LoginDAO  extends CrudRepository<LoginVo,Long>{
	
	@Transactional
	@Query(value="select * from login where email = :email AND password = :password",nativeQuery=true)
	LoginVo findUserLogin(@Param("email") String email, @Param("password") String password);
	
	
	
	@Transactional
	@Query(value="select * from login where email = :email",nativeQuery=true)
	LoginVo findUser(@Param("email") String email);

	@Modifying
	@Transactional
	@Query(value="delete from login where email=:email",nativeQuery=true)
	void deleteLongin(String email);


}

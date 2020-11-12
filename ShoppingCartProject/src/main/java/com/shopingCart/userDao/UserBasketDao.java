package com.shopingCart.userDao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shopingCart.userVo.UserBasket;

@Repository
@Transactional
public interface UserBasketDao extends CrudRepository<UserBasket, Long> {
//.gtfybhgybybyby

	@Transactional
	@Query(value = "select * from userbasket where productName = :productName AND email = :email", nativeQuery = true)
	public UserBasket getUserProduct(@Param("productName") String productName,@Param("email")String email);

	@Modifying
	@Transactional
	@Query(value = "update userbasket set quantity=:quantity where productName=:productName AND email=:email", nativeQuery = true)
	public int updateUserBasket(@Param("productName")String productName, @Param("quantity")long quantity,@Param("email")String email);

	
	
	
	
	@Transactional
	@Query(value = "select * from userbasket where email = :email", nativeQuery = true)
	public List<UserBasket> getUserBasketList(String email);

	@Modifying
	@Transactional
	@Query(value="delete from userbasket where productName=:productName AND email=:email",nativeQuery=true)
	public void removeItems(@Param("productName")String productName, @Param("email")String email);

}

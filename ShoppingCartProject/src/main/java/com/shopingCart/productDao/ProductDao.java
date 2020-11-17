package com.shopingCart.productDao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shopingCart.productVo.ProductVo;

@Repository
@Transactional
public interface ProductDao extends CrudRepository<ProductVo, Long> {
	

	@Transactional
	@Query(value = "select * from productBaseDate where productName=:productName", nativeQuery = true)
	ProductVo getproductFromdb(@Param("productName") String productName);

	
	
	@Modifying
	@Transactional
	@Query(value = "update productBaseDate set quantity=:quantity "
			+ "where productName=:productName", nativeQuery = true)
	int updateProductsQuantity(@Param("productName") String productName, @Param("quantity") long quantity);

	@Transactional
	@Query(value = "select * from productBaseDate where quantity>0", nativeQuery = true)
	List<ProductVo> viewAllProduct();

	@Modifying
	@Transactional
	@Query(value = "update productBaseDate set quantity=:quantity where productName=:productName", nativeQuery = true)
	void updateRecord(@Param("productName") String productName, @Param("quantity") long quantity);

}

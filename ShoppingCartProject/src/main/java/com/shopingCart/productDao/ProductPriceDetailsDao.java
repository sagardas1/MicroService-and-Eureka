package com.shopingCart.productDao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shopingCart.productVo.ProductPriceDetails;
import com.shopingCart.productVo.ProductVo;
import com.shopingCart.userVo.LoginVo;
@Repository
@Transactional
public interface ProductPriceDetailsDao  extends CrudRepository<ProductPriceDetails,Long>{

	@Transactional
	@Query(value="select * from productPriceDetails where productName=:name",nativeQuery=true)
	ProductPriceDetails getProductPrice(@Param("name")String name);


	
	

}

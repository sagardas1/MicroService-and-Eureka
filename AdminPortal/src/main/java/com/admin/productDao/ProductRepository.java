package com.admin.productDao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.admin.productVo.ProductVo;

@Repository
@Transactional
public interface ProductRepository extends CrudRepository<ProductVo,Long>{

	@Transactional
	@Query(value="select * from productBaseDate where quantity >5",nativeQuery=true)
	List<ProductVo> allProducthavingQuantitygreaterThan5();
	
	
	

}

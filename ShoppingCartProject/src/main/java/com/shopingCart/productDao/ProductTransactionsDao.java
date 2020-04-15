package com.shopingCart.productDao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shopingCart.productVo.ProductTransactions;

@Repository
@Transactional
public interface ProductTransactionsDao extends CrudRepository<ProductTransactions,Long>{

	
	

}

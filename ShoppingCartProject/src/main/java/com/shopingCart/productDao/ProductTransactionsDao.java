package com.shopingCart.productDao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shopingCart.productVo.ProductTransactions;

@Repository
@Transactional
public interface ProductTransactionsDao extends CrudRepository<ProductTransactions, Long> {

	@Transactional
	@Query(value = "select * from productTransactions", nativeQuery = true)
	public List<ProductTransactions> getAll();

}

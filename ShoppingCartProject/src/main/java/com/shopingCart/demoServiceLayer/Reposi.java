package com.shopingCart.demoServiceLayer;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shopingCart.productVo.ProductVo;

@Repository
@Transactional
public interface Reposi extends CrudRepository<ImmunisationVo,Long>{

}

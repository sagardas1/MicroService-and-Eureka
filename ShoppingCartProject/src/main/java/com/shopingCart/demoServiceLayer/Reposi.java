package com.shopingCart.demoServiceLayer;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface Reposi extends CrudRepository<ImmunisationVo,Long>{

}

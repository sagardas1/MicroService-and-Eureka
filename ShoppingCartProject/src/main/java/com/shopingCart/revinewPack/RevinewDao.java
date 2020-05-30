package com.shopingCart.revinewPack;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shopingCart.revinewVo.RevinewVo;
@Repository
@Transactional
public interface RevinewDao extends CrudRepository<RevinewVo,Long>{
	
	
	

}

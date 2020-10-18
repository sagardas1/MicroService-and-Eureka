package com.shopingCart.revinewPack;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopingCart.productDao.ProductTransactionsDao;
import com.shopingCart.productVo.ProductTransactions;
import com.shopingCart.revinewVo.RevinewVo;

@Service
public class RevinewService {

	@Autowired
	public ProductTransactionsDao productTransactionsDao;
	@Autowired
	public RevinewDao revinewDao;

	public void updateRevinew() {
		RevinewVo revinewVo = null;

		List<ProductTransactions> productTransactionsList = productTransactionsDao.getAll();

		for (int i = 0; i < productTransactionsList.size(); i++) {
			ProductTransactions productTransactions = productTransactionsList.get(i);
			revinewVo = new RevinewVo();
			revinewVo.setAmount(productTransactions.getAmountPaid());
			revinewVo.setEmail(productTransactions.getEmail());
			revinewDao.save(revinewVo);
		}

	}

}

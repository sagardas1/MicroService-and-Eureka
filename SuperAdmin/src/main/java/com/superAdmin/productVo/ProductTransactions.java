package com.superAdmin.productVo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductTransactions {

	private long id;

	private double amountPaid;
	private double finalAmount;
	private double paymentStatus;
	private String email;

	
}

package com.superAdmin.productVo;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ProductTransactions  {

	private long id;
	private double amountPaid;
	private double finalAmount;
	private double paymentStatus;
	private String email;

}

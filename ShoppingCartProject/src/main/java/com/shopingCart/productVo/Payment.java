package com.shopingCart.productVo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Payment {
	private double finalAmount;
	private long paymentStatus;
	private double amountPaid;
	private double amountToBePaid;

	
	

}

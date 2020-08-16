package com.admin.productVo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ProductPriceDetails {

	private long productId;
	private String productName;
	private double price;

}

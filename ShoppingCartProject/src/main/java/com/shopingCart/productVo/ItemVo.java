package com.shopingCart.productVo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ItemVo {
	private String productName;
	private long quantity;
	private double price;

}

package com.superAdmin.productVo;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ProductVo {
	
	private long productId;
	private String productName;
	private long quantity;


}

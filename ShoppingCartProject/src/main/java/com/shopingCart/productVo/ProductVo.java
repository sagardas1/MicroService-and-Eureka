package com.shopingCart.productVo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="productBaseDate")
public class ProductVo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long productId;
	private String productName;
	private long quantity;

	

}

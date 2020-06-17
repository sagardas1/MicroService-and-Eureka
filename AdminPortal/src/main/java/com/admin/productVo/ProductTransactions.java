package com.admin.productVo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter
@Entity
@Table(name="productTransactions")
public class ProductTransactions  {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private double amountPaid;
	private double finalAmount;
	private double paymentStatus;
	private String email;
	
	

}

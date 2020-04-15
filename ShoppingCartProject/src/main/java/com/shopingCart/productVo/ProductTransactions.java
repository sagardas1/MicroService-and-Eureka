package com.shopingCart.productVo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.shopingCart.userVo.RegistrationVo;

@Entity
@Table(name="productTransactions")
public class ProductTransactions  {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private double amountPaid;
	private double finalAmount;
	private double paymentStatus;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private String email;
	public double getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}
	public double getFinalAmount() {
		return finalAmount;
	}
	public void setFinalAmount(double finalAmount) {
		this.finalAmount = finalAmount;
	}
	public double getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(double paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	
	

}

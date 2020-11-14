package com.admin.productVo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




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
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}

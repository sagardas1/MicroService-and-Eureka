package com.superAdmin.productVo;

public class ProductTransactions  {

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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	
	

}

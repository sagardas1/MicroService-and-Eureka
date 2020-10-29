package com.shopingCart.productVo;

public class Payment {
	private double finalAmount;
	private long paymentStatus;
	private double amountPaid;
	private double amountToBePaid;

	public double getFinalAmount() {
		return finalAmount;
	}

	public void setFinalAmount(double finalAmount) {
		this.finalAmount = finalAmount;
	}

	public long getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(long paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public double getAmountToBePaid() {
		return amountToBePaid;
	}

	public void setAmountToBePaid(double amountToBePaid) {
		this.amountToBePaid = amountToBePaid;
	}

}

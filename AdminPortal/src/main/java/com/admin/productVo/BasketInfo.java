package com.admin.productVo;

import java.util.List;

import com.admin.userVo.RegistrationVo;

public class BasketInfo extends RegistrationVo {
	
	
	private List<ItemVo> itemList;
	private double totalPrice;
	private Payment payment;

	public List<ItemVo> getItemList() {
		return itemList;
	}

	public void setItemList(List<ItemVo> itemList) {
		this.itemList = itemList;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

}

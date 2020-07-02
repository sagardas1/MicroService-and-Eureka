package com.shopingCart.productVo;

import java.util.List;

import com.shopingCart.baseResponce.BaseResponce;
import com.shopingCart.userVo.RegistrationVo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Getter
@Setter
public class BasketInfo extends RegistrationVo{
private	List<ItemVo> itemList;
private double totalPrice;
private Payment payment;
	

}

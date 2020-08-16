package com.admin.productVo;

import java.util.List;

import com.admin.userVo.RegistrationVo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BasketInfo extends RegistrationVo{
private	List<ItemVo> itemList;
private double totalPrice;
private Payment payment;

}

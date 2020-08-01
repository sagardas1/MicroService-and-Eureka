package com.shopingCart.demoServiceLayer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ImmunisationVo {
	
	private String name;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int immId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getImmId() {
		return immId;
	}
	public void setImmId(int immId) {
		this.immId = immId;
	}
	

}

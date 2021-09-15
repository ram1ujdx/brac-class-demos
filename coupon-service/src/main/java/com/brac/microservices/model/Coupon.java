package com.brac.microservices.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Coupon {

	@Id
	private String couponCode;
	private float couponDiscount;
	private float maxDiscount;
	private float minCartValue;
	private int couponServicePort;
	
	
}

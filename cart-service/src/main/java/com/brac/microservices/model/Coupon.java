package com.brac.microservices.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Coupon {

	private String couponCode;
	private float couponDiscount;
	private float maxDiscount;
	private float minCartValue;
	private int couponServicePort;
	
}

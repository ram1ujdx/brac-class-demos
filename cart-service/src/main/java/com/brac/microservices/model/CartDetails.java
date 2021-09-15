package com.brac.microservices.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDetails {

	private Product product;
	private Coupon coupon;
	private float amount;
	private float discounts;
	
	
}

package com.brac.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brac.microservices.model.CartDetails;
import com.brac.microservices.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@GetMapping("/product-id/{product-id}/coupon-code/{coupon-code}")
	public CartDetails getCartDetails(@PathVariable("product-id") long productId,
													@PathVariable("coupon-code") String couponCode) {
		
		return cartService.getCartInfo(productId, couponCode);
		
	}
	
	
}

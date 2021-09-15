package com.brac.microservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.brac.microservices.model.CartDetails;
import com.brac.microservices.model.Coupon;
import com.brac.microservices.model.Product;

@Service
public class CartService {
	@Autowired
	private RestTemplate restTemplate;

	
	public CartDetails getCartInfo(long productId, String couponCode) {
		
		Product product=restTemplate.getForObject("http://product-service/products/product-id/"+productId, Product.class);
		
		Coupon coupon=restTemplate.getForObject("http://coupon-service/coupons/coupon-code/"+couponCode, Coupon.class);
		
		float price=product.getPrice();
		float discounts=0;
		float maxDiscount=coupon.getMaxDiscount();
		if(price>coupon.getMinCartValue()) {
			discounts=price*(coupon.getCouponDiscount()/100);
			discounts=maxDiscount<discounts?maxDiscount:discounts;
		}
		float amount=price-discounts;
		CartDetails cartDetails=new CartDetails(product, coupon, amount, discounts);
		return cartDetails;
		
	}
	
	
}

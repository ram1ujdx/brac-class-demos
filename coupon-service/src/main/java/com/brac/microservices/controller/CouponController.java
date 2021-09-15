package com.brac.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brac.microservices.dao.CouponDao;
import com.brac.microservices.model.Coupon;

@RestController
@RequestMapping("/coupons")
public class CouponController {

	@Autowired
	private CouponDao dao;
	
	@Autowired
	Environment env;
	
	@GetMapping("/coupon-code/{coupon-code}")
	public Coupon getCouponByCode(@PathVariable("coupon-code") String couponCode) {
		Coupon coupon=dao.findById(couponCode).get();
		
		int port=Integer.parseInt(env.getProperty("local.server.port"));
		coupon.setCouponServicePort(port);
		return coupon;
	}
	
}

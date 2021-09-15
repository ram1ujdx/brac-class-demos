package com.brac.microservices.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brac.microservices.model.Coupon;

public interface CouponDao extends JpaRepository<Coupon, String> {

}

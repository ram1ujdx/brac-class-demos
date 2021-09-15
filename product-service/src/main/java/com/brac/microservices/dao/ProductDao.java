package com.brac.microservices.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.brac.microservices.model.Product;

public interface ProductDao extends JpaRepository<Product, Long> {

	@Query(value="from Product where productName=:productName")
	Product findByProductName(String productName);
	
}

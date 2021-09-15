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
public class Product {

	@Id
	private long productId;
	
	private String productName;
	
	private float price;
	
	private int productServicePort;
	
}

package com.brac.microservices.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Product {

	
	private long productId;
	
	private String productName;
	
	private float price;
	
	private int productServicePort;
	
}

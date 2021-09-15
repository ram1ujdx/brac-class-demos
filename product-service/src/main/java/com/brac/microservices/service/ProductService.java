package com.brac.microservices.service;

import java.util.List;

import com.brac.microservices.model.Product;

public interface ProductService {

	public Product getProductById(long productId);
	
	public void deleteProductById(long productId);
	
	public Product addProduct(Product product);
	
	public List<Product> getAllProducts();
	
}

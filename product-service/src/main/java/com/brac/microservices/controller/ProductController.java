package com.brac.microservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brac.microservices.model.Product;
import com.brac.microservices.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService service;
	@Autowired
	private Environment env;

	@GetMapping("/product-id/{product-id}")
	public Product getProductById(@PathVariable("product-id") long productId) {
		int port=Integer.parseInt(env.getProperty("local.server.port"));
		
		
		Product product= service.getProductById(productId);
		product.setProductServicePort(port);
		return product;
	}
	
	
	@PostMapping
	public Product addProduct(@RequestBody Product product) {
		return service.addProduct(product);
	}
	
	@GetMapping
	public List<Product> getAllProducts(){
		return service.getAllProducts();
	}
}

package com.brac.microservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brac.microservices.dao.ProductDao;
import com.brac.microservices.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao dao;
	
	@Override
	public Product getProductById(long productId) {
		return dao.findById(productId).get();
	}

	@Override
	public void deleteProductById(long productId) {
		dao.deleteById(productId);

	}

	@Override
	public Product addProduct(Product product) {
		
		return dao.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return dao.findAll();
	}

}

package com.balaji.dao;

import java.util.List;

import com.balaji.model.Product;

public interface ProductDAO {
	
	int add(Product product);
	void update(Product product);
	void deleteById(int pid);
	Product findById(int pid);
	List<Product> findAll();
	

}

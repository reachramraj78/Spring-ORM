package com.balaji.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.balaji.model.Product;

@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public int add(Product product) {
		return (int) hibernateTemplate.save(product);
	}

	@Override
	public void update(Product product) {
		hibernateTemplate.update(product);
		
	}

	@Override
	public void deleteById(int pid) {
		Product product = new Product();
		product.setPid(pid);
		hibernateTemplate.delete(product);
		
	}

	@Override
	public Product findById(int pid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

package com.balaji.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.balaji.model.Product;

@Repository("productDAO")
@Transactional
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
		return hibernateTemplate.get(Product.class, pid);
	}

	@Override
	public List<Product> findAll() {
		
		
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
        hibernateTemplate.findByCriteria(criteria);
		
		return hibernateTemplate.loadAll(Product.class);
	}

	@Override
	public List<String> findAllPnames() {
		
		
        
        
		return (List<String>) hibernateTemplate.find("select pname from Product",new Object[] {});
	}
	
	
	
}

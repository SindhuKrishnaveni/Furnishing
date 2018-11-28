package com.niit.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.ProductDao;
import com.niit.model.Product;


@Repository("productDao")
@Transactional
public class ProductDaoImpl implements ProductDao {
	@Autowired
	SessionFactory sessionFactory;
	public Product addProduct(Product product)
	{
		sessionFactory.getCurrentSession().save(product);
		return product;
	}
	public Product updateProduct(Product product)
	{
	   sessionFactory.getCurrentSession().update(product);
	return product;
	}
	public void deleteProduct(int id)
	{
	   Session session=sessionFactory.getCurrentSession();
	   Product product=(Product)session.get(Product.class,id);
	   session.delete(product);
	
	
	}
	public Product selectProduct(int id)
	{
		Object obj=sessionFactory.getCurrentSession().get(Product.class,id);
		Product p=(Product)obj;
		return p;
	}
public List<Product> getAllProduct() {
		
		// TODO Auto-generated method stub
		return  sessionFactory.getCurrentSession().createQuery("from Product").list();
	}




}

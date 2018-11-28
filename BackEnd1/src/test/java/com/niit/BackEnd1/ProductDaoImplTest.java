package com.niit.BackEnd1;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.config.DBConfig;
import com.niit.dao.ProductDao;
import com.niit.daoimpl.ProductDaoImpl;
import com.niit.model.Product;

import junit.framework.TestCase;

public class ProductDaoImplTest extends TestCase {
	ApplicationContext context=new AnnotationConfigApplicationContext(DBConfig.class,ProductDaoImpl.class);
	   ProductDao productDao=(ProductDao)context.getBean("productDao");
	public void testSaveProduct() {
		Product product =new Product();
		product.setPrice(20000);
		product.setQuantity(5);
		product.setProductname("samsung");
		product.setProductdesc("4GB android mobiles");
		product=productDao.addProduct(product);
		assertTrue(product.getId()>0); 
		
	}

	public void testGetProduct() {
		  Product product1=productDao.selectProduct(4);
		   Product product2=productDao.selectProduct(3);
		   Product product3=productDao.selectProduct(6);
		   assertNotNull(product1);
		   assertNotNull(product2);
		   assertNull(product3);
		   double expectedPrice=13000.0;
		   double actualPrice=product1.getPrice();
		   assertTrue(expectedPrice==actualPrice);
	}

	public void testUpdateProduct() {
		Product product=productDao.selectProduct(3);
		product.setPrice(2000);
		product.setQuantity(25);
		productDao.updateProduct(product);
		assertTrue(product.getPrice()==2000);
		assertTrue(product.getQuantity()==25);
	}
	public void testDeleteProduct() {
	
		productDao.deleteProduct(46);
		assertNull(productDao.selectProduct(46));
	}
	public void testGetAllProducts() {
		List<Product> product=productDao.getAllProduct();
		assertNotNull(product.isEmpty());
		
	}	

}

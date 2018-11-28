package com.niit.BackEnd1;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.config.DBConfig;
import com.niit.dao.SupplierDao;
import com.niit.daoimpl.SupplierDaoImpl;
import com.niit.model.Supplier;

import junit.framework.TestCase;

public class SupplierDaoImplTest extends TestCase {
	ApplicationContext context=new AnnotationConfigApplicationContext(DBConfig.class,SupplierDaoImpl.class);
	   SupplierDao supplierDao=(SupplierDao)context.getBean("supplierDao");
	public void testSaveSupplier() {
		Supplier supplier =new Supplier();
		supplier.setSuppliername("Electrical suppliers");
		supplier.setSupplierdescp("from calicut");
		supplier=supplierDao.addSupplier(supplier);
		assertTrue(supplier.getSupplierid()>0); 
		}
	public void testGetSupplier() {
		  Supplier supplier1=supplierDao.selectSupplier(2);
		   Supplier supplier2=supplierDao.selectSupplier(74);
		   Supplier supplier3=supplierDao.selectSupplier(6);
		   assertNotNull(supplier1);
		   assertNotNull(supplier2);
		   assertNull(supplier3);
		   String expectedSupplierdescp="from hyderabad";
		   String actualSupplierdescp=supplier1.getSupplierdescp();
		   assertTrue(expectedSupplierdescp.equals(actualSupplierdescp));
	}
	public void testUpdateSupplier() {
		Supplier supplier=supplierDao.selectSupplier(72);
		supplier.setSuppliername("Electrics");
		supplier.setSupplierdescp("from jharkhand");
		supplierDao.updateSupplier(supplier);
		assertTrue(supplier.getSuppliername()=="Electrics");
		assertTrue(supplier.getSupplierdescp()=="from jharkhand");
	}
public void testDeleteSupplier() {
		
		supplierDao.deleteSupplier(77);
		assertNull(supplierDao.selectSupplier(77));
	}
public void testGetAllSupplier() {
	List<Supplier> supplier=supplierDao.getAllSupplier();
	assertNotNull(supplier.isEmpty());
	
}

}

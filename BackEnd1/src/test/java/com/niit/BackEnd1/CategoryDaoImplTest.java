package com.niit.BackEnd1;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.config.DBConfig;
import com.niit.dao.CategoryDao;
import com.niit.daoimpl.CategoryDaoImpl;
import com.niit.model.Category;

import junit.framework.TestCase;

public class CategoryDaoImplTest extends TestCase {
	ApplicationContext context=new AnnotationConfigApplicationContext(DBConfig.class,CategoryDaoImpl.class);
	   CategoryDao categoryDao=(CategoryDao)context.getBean("categoryDao");
	public void testSaveCategory() {
		Category category =new Category();
		category.setCategoryname("Mobiles");
		category.setCategorydescp("Latest Designs");
		category=categoryDao.addCategory(category);
		assertTrue(category.getCategoryid()>0); 
		
	}
	public void testGetCategory() {
		  Category category1=categoryDao.selectCategory(64);
		   Category category2=categoryDao.selectCategory(3);
		   Category category3=categoryDao.selectCategory(10);
		   assertNotNull(category1);
		   assertNotNull(category2);
		   assertNull(category3);
		   String expectedCategoryname="Mobiles";
		   String actualCategoryname=category1.getCategoryname();
		   assertTrue(expectedCategoryname.equals(actualCategoryname));
	}
	public void testUpdateCategory() {
		Category category=categoryDao.selectCategory(63);
		category.setCategoryname("tab");
		category.setCategorydescp("latest tab designs");
		categoryDao.updateCategory(category);
		assertTrue(category.getCategoryname()=="tab");
		assertTrue(category.getCategorydescp()=="latest tab designs");
	}
	public void testDeleteCategory() {
		
		categoryDao.deleteCategory(101);
		assertNull(categoryDao.selectCategory(101));
	}
	public void testGetAllCategory() {
		List<Category> category=categoryDao.getAllCategory();
		assertNotNull(category.isEmpty());
		
	}

}

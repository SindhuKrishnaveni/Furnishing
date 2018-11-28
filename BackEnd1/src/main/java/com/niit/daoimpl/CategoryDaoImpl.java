package com.niit.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.CategoryDao;
import com.niit.model.Category;

@Repository("categoryDao")
@Transactional
public class CategoryDaoImpl implements CategoryDao {
	@Autowired
	SessionFactory sessionFactory;
	public Category addCategory(Category category)
	{
		sessionFactory.getCurrentSession().save(category);
		return category;
	}

public void updateCategory(Category category)
{
   sessionFactory.getCurrentSession().update(category);
}

public void deleteCategory(int id)
{
	
   Session session=sessionFactory.getCurrentSession();
   Category category=(Category)session.get(Category.class,id);
   session.delete(category);
}
public Category selectCategory(int id)
{
	Object obj=sessionFactory.getCurrentSession().get(Category.class,id);
	Category c=(Category)obj;
	return c;
}

public List<Category> getAllCategory() {
	
	// TODO Auto-generated method stub
	return  sessionFactory.getCurrentSession().createQuery("from Category").list();
}



}

package com.niit.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.SupplierDao;
import com.niit.model.Supplier;

@Repository("supplierDao")
@Transactional

public class SupplierDaoImpl implements SupplierDao {
	@Autowired
	SessionFactory sessionFactory;
	public Supplier addSupplier(Supplier supplier)
	{
		sessionFactory.getCurrentSession().save(supplier);
		return supplier;
	}

public void updateSupplier(Supplier supplier)
{
   sessionFactory.getCurrentSession().update(supplier);
}

public void deleteSupplier(int id)
{
   Session session=sessionFactory.getCurrentSession();
   Supplier supplier=(Supplier)session.get(Supplier.class,id);
   session.delete(supplier);
}
public Supplier selectSupplier(int id)
{
	Object obj=sessionFactory.getCurrentSession().get(Supplier.class,id);
	Supplier s=(Supplier)obj;
	return s;
}

public List<Supplier> getAllSupplier() {
	
	// TODO Auto-generated method stub
	return  sessionFactory.getCurrentSession().createQuery("from Supplier").list();
}

}

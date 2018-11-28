package com.niit.daoimpl;

import java.util.List;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.CartItemDao;
import com.niit.model.CartItem;
import com.niit.model.CustomerOrder;

@Repository("cartItemDao")
@Transactional
public class CartItemDaoImpl implements CartItemDao{
	@Autowired
    private SessionFactory sessionFactory;
	public void addToCart(CartItem cartItem)
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(cartItem);
	}

	public void removeCartItem(int cartItemId) 
	{
		Session session=sessionFactory.getCurrentSession();
		CartItem cartItem=(CartItem)session.get(CartItem.class,cartItemId);
		session.delete(cartItem);
	}

	public List<CartItem> getCart(String email) 
	{
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from CartItem where user.emailid=:emailid");
		query.setString("emailid", email);
		return query.list();
	}

	public CustomerOrder createCustomerOrder(CustomerOrder customerOrder) {
		Session session=sessionFactory.getCurrentSession();
		session.save(customerOrder);
		return customerOrder;
	}

}

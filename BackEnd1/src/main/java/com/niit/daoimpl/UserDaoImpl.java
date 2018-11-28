package com.niit.daoimpl;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.UserDao;
import com.niit.model.Product;
import com.niit.model.User;
@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao 
{
	@Autowired 
	SessionFactory sessionFactory;
	public User addUser(User user)
	{
		sessionFactory.getCurrentSession().save(user);
		return user;
	}
public List<User> getUser() {
		
		// TODO Auto-generated method stub
		return  sessionFactory.getCurrentSession().createQuery("from User").list();
	}
public void updateUser(User user)
{
   sessionFactory.getCurrentSession().update(user);
}
public void deleteUser(int id)
{
	Session session=sessionFactory.getCurrentSession();
	   User user=(User)session.get(User.class,id);
	   session.delete(user);
}
public User selectUser(int id)
{
	Object obj=sessionFactory.getCurrentSession().get(User.class,id);
	User u=(User)obj;
	return u;
	
}


}
		
	 
		
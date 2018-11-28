package com.niit.BackEnd1;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.config.DBConfig;
import com.niit.dao.UserDao;
import com.niit.daoimpl.UserDaoImpl;
import com.niit.model.User;

import junit.framework.TestCase;

public class UserDaoImplTest extends TestCase {
	ApplicationContext context=new AnnotationConfigApplicationContext(DBConfig.class,UserDaoImpl.class);
	   UserDao userDao=(UserDao)context.getBean("userDao");
	public void testSaveUser() {
		User user =new User();
		
		user.setPassword("654");
		user.setEmailid("asdfkujkhkj@gmail.com");
		user.setMobno("977548588");
		user=userDao.addUser(user);
	//	assertTrue(user.getMobno()>0); 
		}
	
	public void testUpdateUser()
	{
		User user=userDao.selectUser(100);
		user.setEmailid("ram@gmail.com");
		user.setMobno("258475");
		userDao.updateUser(user);
		assertTrue(user.getEmailid()=="ram@gmail.com");
		assertTrue(user.getMobno()=="258475");
	}
	public void testGetUser()
	 {
	  User user1=userDao.selectUser(100);
	  User user2=userDao.selectUser(101);
	  User user3=userDao.selectUser(15);
	  assertNotNull(user1);
	  assertNotNull(user2);
	  assertNull(user3);
	  String expectedmailId="asdfkujkhkj@gmail.com";
	  String actualmailId=user1.getEmailid();
	  assertTrue(expectedmailId.equals(actualmailId));
	 }
	public void testDeleteUser()
	 {
	  userDao.deleteUser(97);  
	  assertNull(userDao.selectUser(97));	 
	 }
	 public void testGetAllUsers()
	 {
	  List<User> userList=userDao.getUser(); 
	  assertNotNull(userList.isEmpty());
	 }
	

}

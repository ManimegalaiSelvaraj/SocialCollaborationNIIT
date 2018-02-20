package com.facechat.facechatbackend.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

//import javax.persistence.Query;

import org.hibernate.Session;
//import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.facechat.facechatbackend.model.Friend;
import com.facechat.facechatbackend.model.UserDetail;

@Repository("userDAO")
public class UserDAOImpl  implements UserDAO{
    
	@Autowired
	SessionFactory sessionFactory;
	
	public UserDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public boolean addUser(UserDetail user) 
	{
		try
		{
		sessionFactory.getCurrentSession().save(user);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
	}
   
	
	@Transactional
	public boolean updateOnlineStatus(String status, UserDetail user) {
		try
		{
			user.setIsOnline(status);;
			sessionFactory.getCurrentSession().saveOrUpdate(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception occured:"+e);
			return false;
		}
	

	}

    	
	public List<UserDetail> getAllUsers() {
		Session session = sessionFactory.openSession();
		List<UserDetail> userlist=(List<UserDetail>)session.createQuery("from UserDetail").list();
		session.close();
		return userlist;
	}

	@Transactional
	public boolean deleteUser(UserDetail user) {
		try
		{
			sessionFactory.getCurrentSession().delete(user);
			return true;
			
		}
		catch( Exception e)
		{
			System.out.println("Exception occured"+e);
			return false;
		}
	}
    @Transactional
	public boolean updateUser(UserDetail user) {
		try{
			sessionFactory.getCurrentSession().saveOrUpdate(user);
			return true;
			}
			catch(Exception e)
			{
			e.printStackTrace();
			return false;
			}

	}
    @Transactional
	public boolean checkLogin(UserDetail user) {
	Session session=sessionFactory.openSession();
	Query query=session.createQuery("from UserDetail where username= :uname and password= :pwd");
	query.setParameter("uname", user.getUsername());
	query.setParameter("pwd", user.getPassword());
	
	UserDetail userDetail=(UserDetail)query.list().get(0);
	if(userDetail!=null)
	{
		return true;
	}
	else
	{
		return false;
	}
	}

    @Transactional
	public UserDetail getUser(String username)
	   {
		   Session session=sessionFactory.openSession();
		   UserDetail user=(UserDetail)session.get(UserDetail.class,username);
		   session.close();
		    return user;
	   }
  

	
	@Transactional
	public List<UserDetail> getalluser1(UserDetail u) 
	{
		System.out.println(u.getUsername());
		Session session=sessionFactory.openSession();
		String hql="from UserDetail where role!=:admin and username!=:user";
		Query query=session.createQuery(hql);
		query.setParameter("admin","ADMIN");
		query.setParameter("user",u.getUsername());
		
		return query.list();

	}
}


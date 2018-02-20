package com.facechat.facechatbackend.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.facechat.facechatbackend.model.Forum;

public class ForumDAOImpl implements ForumDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public ForumDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	@Transactional
	public boolean addForum(Forum forum) {
		try
		{
		sessionFactory.getCurrentSession().save(forum);
			return true;
			
		}
		catch(Exception e)
		{
			return false;
		}
	}
	@Transactional
	public boolean updateForum(Forum forum) {

   try
   {
	   sessionFactory.getCurrentSession().saveOrUpdate(forum);
	   return true;
	  
   }
   catch(Exception e)
   {
	   System.out.println("Exception occured:"+e);
   }
		return false;
	}

	@Transactional
	public boolean deleteForum(Forum  forum) {
		{
			try
			{
				sessionFactory.getCurrentSession().delete(forum);
				return true;
				
			}
			catch( Exception e)
			{
				System.out.println("Exception occured"+e);
				return false;
			}
		}
	}
	@Transactional
	public Forum getForum(int forumId)
	  {
     Session session=sessionFactory.openSession();
     Forum forum=session.get(Forum.class,forumId);
     session.close();
     
		return forum;
	}

	public List<Forum> getAllForums() 
	{
		Session session = sessionFactory.openSession();
		List<Forum> forumList=(List<Forum>)session.createQuery("from Forum").list();
		session.close();
		return forumList;
	}
	
	@Transactional
	public boolean approveForum(Forum forum) {
		try
		{
			forum.setStatus("A");
			sessionFactory.getCurrentSession().saveOrUpdate(forum);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception occured:"+e);
			return false;
		}
	
	}

	@Transactional
	public boolean rejectForum(Forum forum) {
		try
		{
			forum.setStatus("N");
			sessionFactory.getCurrentSession().update(forum);
			return true;
		}
		catch (Exception e)
		{
			System.out.println("Exception occured"+e);
			
		}
		return false;
	}
}
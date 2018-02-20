package com.facechat.facechatbackend.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.facechat.facechatbackend.model.Friend;


@Repository("friendDAO")
public class FriendDAOimpl implements FriendDAO 
{
	
	@Autowired
	SessionFactory sessionFactory;
	

	public FriendDAOimpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;

	}

	
	@Transactional
	public List<Friend> getAllFriendRequest(String username)
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Friend where username=:uname");
		query.setParameter("uname", username);
		List<Friend> listfriends=query.list();
		return listfriends;
	}
	@Transactional
	public List<Friend> getApprovedFriends(String username) 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Friend where username=:uname and status='A'");
		query.setParameter("uname", username);
		List<Friend> listfriends=query.list();
		return listfriends;
	}



	@Transactional
	public boolean createFriend(Friend friend) {
		try
		{
			sessionFactory.getCurrentSession().save(friend);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception"+e);
			return false;
		}
		}

	@Transactional
	public Friend getFriend(int friendId) {
		Session session=sessionFactory.openSession();
		Friend friend=(Friend) session.get(Friend.class, friendId);
		return friend;

	}

	@Transactional
	public boolean rejectFriendRequest(Friend friend) {
		try
		{
			friend.setStatus("R");
			sessionFactory.getCurrentSession().update(friend);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception arised"+e);
			return false;
		}	}

@Transactional
	public boolean approveFriendRequest(Friend friend) {
		try
		{
			friend.setStatus("A");
			sessionFactory.getCurrentSession().update(friend);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception arised"+e);
			return false;
		}
			}


public Friend getfriendbyid(int friendid) {
	 Session session=sessionFactory.openSession();
	    Friend f=(Friend) session.get(Friend.class,new Integer(friendid));
	    session.flush();
	    session.close();
		return f;
}


@Transactional
public boolean deletefriend(Friend f)
{
try
	{
	sessionFactory.getCurrentSession().delete(f);
	 System.out.println("friend deleted successfully");
	return true;
	}
	catch(Exception e)
	{
	System.out.println(e);
	return false;	
}
}


}//class close

package com.facechat.facechatbackend.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.facechat.facechatbackend.dao.FriendDAO;
import com.facechat.facechatbackend.model.Friend;


public class FriendDAOTest
{

static FriendDAO friendDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.facechat.facechatbackend");
	    context.refresh();
	    
	    friendDAO=(FriendDAO) context.getBean("friendDAO");
	}
	
@Test
public void CreateFriendTest()
{
	Friend friend=new Friend();
	friend.setUsername("shaheer");
	friend.setFriendname("rohit");
	friend.setStatus("R");
	
	assertTrue("problem in Adding",friendDAO.createFriend(friend));
	}


@Ignore	
@Test
public void getAllFriendRequest()
{
	System.out.println("get All friend Request");

List<Friend> listfriends=friendDAO.getAllFriendRequest("shaheer");
assertNotNull("problem in get all friend",listfriends);

for(Friend friend:listfriends)
{
	System.out.println("Username:----"+friend.getUsername());
	System.out.println("Friend Name:---"+friend.getFriendname());
	System.out.println("status----"+friend.getStatus());
}

}

@Ignore
@Test
public void getFriendId()
{
	Friend friend = (Friend) friendDAO.getFriend(224);
	assertNotNull("error", friend);
	System.out.println("Username:----"+friend.getUsername());
	System.out.println("Friend Name:---"+friend.getFriendname());
	System.out.println("friend status::::" + friend.getStatus());
}


@Ignore
@Test
public void getAllApprovedFriendTest()
{
	List<Friend> listfriends=friendDAO.getApprovedFriends("suresh");
	
	assertNotNull("problem in List friends", listfriends);
	
	for(Friend friend:listfriends)
	{
		System.out.println("Username:----"+friend.getUsername());
		System.out.println("Friend Name:---"+friend.getFriendname());
		System.out.println("Friend Name----"+friend.getStatus());
	}
}
@Ignore
@Test
public void approvedFriendrequest()
{
	Friend friend=friendDAO.getFriend(204);
	assertTrue("Problem in Approving",friendDAO.approveFriendRequest(friend));
}

@Ignore
@Test
public void rejectfriendrequest()
{
	Friend friend=friendDAO.getFriend(221);
	assertTrue("rejecting in problem",friendDAO.rejectFriendRequest(friend));
}

}//class close

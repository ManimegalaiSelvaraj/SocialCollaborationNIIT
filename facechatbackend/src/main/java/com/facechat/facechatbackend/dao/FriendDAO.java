package com.facechat.facechatbackend.dao;

import java.util.List;

import com.facechat.facechatbackend.model.Friend;


public interface FriendDAO 
{
public boolean createFriend(Friend friend);
public List<Friend> getAllFriendRequest(String username);
public List<Friend> getApprovedFriends(String username);
public Friend getFriend(int friendId);
public boolean rejectFriendRequest(Friend friend);
public boolean approveFriendRequest(Friend friend);
public Friend getfriendbyid(int friendid);
public boolean deletefriend(Friend f);

}

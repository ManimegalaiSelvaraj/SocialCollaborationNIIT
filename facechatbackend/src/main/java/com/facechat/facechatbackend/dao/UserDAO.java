package com.facechat.facechatbackend.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.facechat.facechatbackend.model.Blog;
import com.facechat.facechatbackend.model.UserDetail;

//import java.util.List;


@Service
public interface UserDAO {

   public boolean addUser(UserDetail user);
   public boolean updateOnlineStatus(String status,UserDetail user);
   public boolean updateUser(UserDetail user);
   public boolean checkLogin(UserDetail user);
   public List<UserDetail> getAllUsers();
public boolean deleteUser(UserDetail user);
public UserDetail getUser(String username);

public List<UserDetail> getalluser1(UserDetail u);
}

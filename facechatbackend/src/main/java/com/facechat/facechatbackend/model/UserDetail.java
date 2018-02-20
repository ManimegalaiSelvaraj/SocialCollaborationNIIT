package com.facechat.facechatbackend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class UserDetail
{
	
@Id
String username;

String password;
String role;

String EmailID;
String isOnline;


//setter and getter method
public String getEmailID()
{
	return EmailID;
}
public void setEmailID(String emailID)
{
	EmailID = emailID;
}
public String getUsername() 
{
	return username;
}
public void setUsername(String username) 
{
	this.username = username;
}
public String getPassword()
{
	return password;
}
public void setPassword(String password) 
{
	this.password = password;
}
public String getRole()
{
	return role;
}
public void setRole(String role) 
{
	this.role = role;
}
public String getIsOnline()
{
	return isOnline;
}
public void setIsOnline(String isOnline) 
{
	this.isOnline = isOnline;
}


}//class close
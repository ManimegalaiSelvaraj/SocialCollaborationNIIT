package com.facechat.facechatbackend.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class BlogComments {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCE1")
	@SequenceGenerator(name="SEQUENCE1", sequenceName="SEQUENCE1", allocationSize=1)
	int blogCommentsId;
	int blogId;
	String blogcomment;
	private Date commentDate;
	int userId;
	String username;
	public int getBlogCommentsId() {
		return blogCommentsId;
		
}
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	
	
	public String getBlogcomment() {
		return blogcomment;
	}
	public void setBlogcomment(String blogcomment) {
		this.blogcomment = blogcomment;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setBlogCommentsId(int blogCommentsId) {
		this.blogCommentsId = blogCommentsId;
	}
}
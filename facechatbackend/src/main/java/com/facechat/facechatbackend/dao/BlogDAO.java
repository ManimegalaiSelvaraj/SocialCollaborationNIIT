package com.facechat.facechatbackend.dao;

import java.util.List;

import com.facechat.facechatbackend.model.Blog;;

public interface BlogDAO 
{
	public boolean addBlog(Blog blog);
	public boolean updateBlog(Blog blog);
	public boolean deleteBlog(Blog blog);
	public Blog getBlog(int blogId);
	public List<Blog> getAllBlogs();
	public boolean approveBlog(Blog blog);
	boolean rejectBlog(Blog blog);
	public boolean incrementLike(Blog tempblog);
}



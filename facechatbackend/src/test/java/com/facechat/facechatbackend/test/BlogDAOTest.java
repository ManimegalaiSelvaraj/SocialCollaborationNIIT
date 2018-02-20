package com.facechat.facechatbackend.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.facechat.facechatbackend.dao.BlogDAO;
import com.facechat.facechatbackend.model.Blog;

public class BlogDAOTest 
{

static BlogDAO blogDAO;
	


@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.facechat.facechatbackend");
		context.refresh();
		
		blogDAO=(BlogDAO)context.getBean("blogDAO");
	}

@Test
	public void addBlogTest()
	{
		Blog blog=new Blog();
		
		
		blog.setBlogName("Angular jsJava");
		blog.setBlogContent("It is based on Simple Java Concept");
		blog.setUsername("sunil");
		blog.setStatus("A");
		blog.setLikes(3);
		blog.setCreateDate(new java.util.Date());
		
		assertTrue("Problem in Inserting Blog",blogDAO.addBlog(blog));
	
	
	
	}
@Ignore
	@Test
	public void getAllBlogTest()
	{
		List<Blog> blogList=(List<Blog>)blogDAO.getAllBlogs();
		assertNotNull("Blog List not found",blogList.get(0));
		for(Blog blog:blogList)
		{
			System.out.println("Blog Id:"+ blog.getBlogId()+":::"+ "Blog Name"+blog.getBlogName());
		}
		
	}
@Ignore
	@Test
	public void deleteBlogTest()
	{
		Blog blog=(Blog)blogDAO.getBlog(3);
	
		assertTrue("Problem in deletion", blogDAO.deleteBlog(blog));
	}

	@Ignore
	@Test
	public void UpdateBlogTest()
	{
		Blog blog=(Blog)blogDAO.getBlog(7);
		blog.setBlogContent("OOPS, Exception");
		blog.setBlogName("Jav");
		assertTrue("Problem in updating", blogDAO.updateBlog(blog));
	}
	
    @Ignore
	@Test 
	public void approveBlog()
	{
		Blog blog=(Blog)blogDAO.getBlog(101);
		assertTrue("Problem in Approving", blogDAO.approveBlog(blog));
		
	}

	@Ignore
	@Test 
	public void rejectBlog()
	{
		Blog blog=(Blog)blogDAO.getBlog(64);
		assertTrue("Problem in Approving", blogDAO.rejectBlog(blog));
		
		}
}

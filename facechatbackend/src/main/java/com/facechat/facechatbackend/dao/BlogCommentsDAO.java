package com.facechat.facechatbackend.dao;


import java.util.List;

import com.facechat.facechatbackend.model.BlogComments;

public interface BlogCommentsDAO {
	public boolean saveBlogComments(BlogComments blogComments);

	public boolean deleteBlogComments(BlogComments blogComments);

	public boolean updateBlogComments(BlogComments blogComments);

	public BlogComments getBlogComments(int blogCommentsId);

	public List<BlogComments> getAllBlogComments();


}
package com.facechat.facechatbackend.dao;

import java.util.List;

import com.facechat.facechatbackend.model.ForumComments;

public interface ForumCommentsDAO {
	public boolean saveForumComments(ForumComments forumComments);

	public boolean deleteForumComments(ForumComments forumComments);

	public boolean updateForumComments(ForumComments forumComments);

	public ForumComments getForumComments(int fComments);

	public List<ForumComments> getAllForumComments();

}

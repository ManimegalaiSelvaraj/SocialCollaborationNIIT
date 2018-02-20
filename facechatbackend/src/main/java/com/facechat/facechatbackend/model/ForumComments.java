package com.facechat.facechatbackend.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "forumcomments")
@Component
public class ForumComments {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCE1")
	@SequenceGenerator(name="SEQUENCE1", sequenceName="SEQUENCE1", allocationSize=1)
	private int forumId;
	private int forumComment;
	private String comments;
	private Date commentDate;
	private int userId;
	private String username;

	public int getForumId() {
		return forumId;
	}

	public void setForumId(int forumId) {
		this.forumId = forumId;
	}

	public String getComments() {
		return comments;
	}

	public void setComment(String comments) {
		this.comments = comments;
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

	public int getForumComment() {
		return forumComment;
	}

	public void setForumComment(int forumComment) {
		this.forumComment = forumComment;
	};

}

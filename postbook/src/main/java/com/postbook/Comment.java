package com.postbook;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "comments")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer commentId;
	private String txt;
	private Integer userId;
	private Integer postId;

	public Comment() {
		// TODO Auto-generated constructor stub
	}

	public Comment(Integer commentId, String txt, Integer userId, Integer postId) {
		super();
		this.commentId = commentId;
		this.txt = txt;
		this.userId = userId;
		this.postId = postId;
	}

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", txt=" + txt + ", userId=" + userId + ", postId=" + postId + "]";
	}

}

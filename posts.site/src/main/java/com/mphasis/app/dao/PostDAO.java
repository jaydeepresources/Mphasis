package com.mphasis.app.dao;

import java.util.List;

import com.mphasis.app.crud.Post;
import com.mphasis.app.crud.Status;

public interface PostDAO {

	Post insert(Post post);

	Post update(Post post);

	Status delete(Post post);

	List<Post> view();

}
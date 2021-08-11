package com.postbook;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PostsRepository extends CrudRepository<Post, Integer> {

	// Find posts by a postId
	List<Post> findByUserId(int userId);
	
	// Join posts and users
	
	@Query(nativeQuery = true, value = "SELECT post_id,title,body,u.name,p.user_id FROM posts p join users u on p.user_id = u.user_id;")
	Object[][] joinPostsAndUsers();

	@Query(nativeQuery = true, value = "SELECT post_id,title,body,u.name,p.user_id FROM posts p join users u on p.user_id = u.user_id where u.user_id = ?1")
	Object[][] joinPostsAndUsersByUserId(int userId);
	
}

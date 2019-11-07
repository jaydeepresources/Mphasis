package com.posts;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PostsRepository extends CrudRepository<Post, Integer> {

	List<Post> findByTitle(String title);

	@Query("select p from posts p where p.title like %:title%") 
	List<Post> findByPlaceContaining(@Param("title") String title);

}
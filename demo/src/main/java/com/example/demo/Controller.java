package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.posts.Post;
import com.posts.PostsRepository;
import com.posts.Status;

@RestController
public class Controller {

	@Autowired
	private PostsRepository repo;

	@GetMapping("/all")
	public List<Post> getPosts() {

//		 System.out.println(repo.findByPlaceContaining("a"));
		List<Post> posts = new ArrayList<Post>();
		Iterable<Post> iterable = repo.findAll();
		for (Post post : iterable) {
			posts.add(post);
		}
		return posts;
	}

	@GetMapping("/all/{title}")
	public List<Post> getPostsByTitle(@PathVariable String title) {

		List<Post> posts = new ArrayList<Post>();
		Iterable<Post> iterable = repo.findByTitle(title);
		for (Post post : iterable) {
			posts.add(post);
		}
		return posts;
	}

	@GetMapping("/all/contains/{title}")
	public List<Post> getPostsByContainsTitle(@PathVariable String title) {

		List<Post> posts = new ArrayList<Post>();
		Iterable<Post> iterable = repo.findByPlaceContaining(title);
		for (Post post : iterable) {
			posts.add(post);
		}
		return posts;
	}

	@PostMapping("/add")
	public Post savePost(@RequestBody Post post) {
		post = repo.save(post);
		return post;
	}

	@DeleteMapping("/delete/{id}")
	public Status deletePost(@PathVariable Integer id) {
		repo.deleteById(id);
		return new Status(true);
	}

	@PutMapping("/edit")
	public Post editPost(@RequestBody Post post) {
		post = repo.save(post);
		return post;
	}

}
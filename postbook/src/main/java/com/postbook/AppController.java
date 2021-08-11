package com.postbook;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	@Autowired
	UsersRepository usersRepository;

	@Autowired
	PostsRepository postsRepository;

	@Autowired
	CommentsRepository commentsRepository;

	// Sign Up
	@PostMapping("/signup")
	public User addUser(@RequestBody User user) {
		return usersRepository.save(user);
	}

	// Sign In
	@PostMapping("/signin")
	public User searchUser(@RequestBody User user) {
		return usersRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
	}

	// Get All Users
	@GetMapping("/users/all")
	public List<User> getUsers() {
		return (List<User>) usersRepository.findAll();
	}

	// Get All Posts
	@GetMapping("/posts/all")
	public List<Post> getPosts() {
		return (List<Post>) postsRepository.findAll();
	}
	
	// Get All Posts by postId
	@GetMapping("/posts/all/{userId}")
	public List<Post> getPostsById(@PathVariable int userId) {
		return (List<Post>) postsRepository.findByUserId(userId);
	}
	
	// Join Posts and Users
	@GetMapping("/posts/all/join")
	public Object joinPostsAndUsers() {
		Object[][] o = postsRepository.joinPostsAndUsers();
		return o;
	}
	
	// Get All Posts by postId and name
	@GetMapping("/posts/all/join/{userId}")
	public Object getPostsAndUsersByUserId(@PathVariable int userId) {
		Object[][] o = postsRepository.joinPostsAndUsersByUserId(userId);
		return o;
	}

	// Add a Post

	@PostMapping("/posts/add")
	public Post addPost(@RequestBody Post post) {
		return postsRepository.save(post);
	}

	// Update a Post

	@PutMapping("/posts/update")
	public Post updatePost(@RequestBody Post post) {
		Optional<Post> option = postsRepository.findById(post.getPostId());
		return (option.isPresent()) ? postsRepository.save(post) : null;
	}
	
	// Delete a Post
	@DeleteMapping("/posts/delete/{id}")
	public boolean deletePost(@PathVariable int id) {
		try {
			postsRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}

















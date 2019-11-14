package com.nested;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
@RequestMapping("postbook")
public class AppController {

	@Autowired
	PostRepository postsRepo;

	@Autowired
	CommentRepository commentsRepo;

	@Autowired
	UsersRepository usersRepo;

	// Sign In
	@PostMapping("/signin")
	public User signIn(HttpServletRequest req, @RequestBody User user) {
		User temp = new User();
		temp = usersRepo.findByUserNameAndPassword(user.getUserName(), user.getPassword());

		if (temp.getId() > 0 && temp.getPassword().equals(user.getPassword())) {
			HttpSession session = req.getSession(true);
			session.setAttribute("userName", temp.getUserName());
		}

		return temp;
	}

	// Sign Up
	@PostMapping("/signup")
	public User signUp(HttpServletRequest req, @RequestBody User user) {

		User result = null;
		try {
			result = usersRepo.save(user);

			if (result == null)
				return null;

			HttpSession session = req.getSession(true);
			session.setAttribute("userName", result.getUserName());
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// Sign Out
	@PostMapping("/signout")
	public Status logout(HttpServletRequest req) {
		HttpSession session = req.getSession(false);

		if (session != null && session.getAttribute("userName") != null) {
			session.invalidate();
			return new Status(true);
		}
		return new Status(false);
	}

	// Check if user has signed in already
	public boolean validate(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		if (session == null || session.getAttribute("userName") == null)
			return false;
		return true;
	}

	// Get All Users
	@GetMapping("/users/all")
	public List<User> findAllUsers(HttpServletRequest req) {
		if (!validate(req))
			return null;

		List<User> users = new ArrayList<User>();
		Iterable<User> iterable = usersRepo.findAll();
		for (User user : iterable) {
			users.add(user);
		}
		return users;
	}

	// Get All Posts
	@GetMapping("/posts/all")
	public List<Post> getPosts(HttpServletRequest req) {
		if (!validate(req))
			return null;

		List<Post> posts = new ArrayList<Post>();
		Iterable<Post> iterable = postsRepo.findAll();
		for (Post post : iterable) {
			posts.add(post);
		}
		return posts;
	}

	// Save a Post
	@PostMapping("/posts/save")
	public Post savePost(@RequestBody Post post, HttpServletRequest req) {
		if (!validate(req))
			return null;

		post.setUser(new User());
		post.getUser().setId(post.getUfk());
		return postsRepo.save(post);
	}

	// Edit a Post
	@PutMapping("/posts/edit")
	public Post editPost(@RequestBody Post post, HttpServletRequest req) {
		if (!validate(req))
			return null;

		post = postsRepo.save(post);
		return post;
	}

	// Delete a Post
	@DeleteMapping("/posts/delete/{id}")
	public Status deletePost(@PathVariable Integer id, HttpServletRequest req) {
		if (!validate(req))
			return null;

		postsRepo.deleteById(id);
		return new Status(true);
	}

	// Get all comments by post
	@GetMapping("/comments/{postId}")
	public List<Comment> getCommentsByPost(@PathVariable Integer postId, HttpServletRequest req) {
		if (!validate(req))
			return null;

		List<Comment> comments = new ArrayList<Comment>();
		Post post = new Post();
		post.setId(postId);
		Iterable<Comment> iterable = commentsRepo.findByPost(post);
		for (Comment comment : iterable) {
			comments.add(comment);
		}
		return comments;
	}

	// Save a Comment
	@PostMapping("/comments/save")
	public Comment saveComment(@RequestBody Comment comment, HttpServletRequest req) {
		if (!validate(req))
			return null;

		comment.setPost(new Post());
		comment.getPost().setId(comment.getFk());
		comment.setUser(new User());
		comment.getUser().setId(comment.getUfk());
		return commentsRepo.save(comment);
	}

	// Edit a Comment
	@PostMapping("/comments/edit")
	public Comment editComment(@RequestBody Comment comment, HttpServletRequest req) {
		if (!validate(req))
			return null;

		comment.setPost(new Post());
		comment.getPost().setId(comment.getFk());
		comment.setUser(new User());
		comment.getUser().setId(comment.getUfk());
		return commentsRepo.save(comment);
	}

	// Delete a Comment
	@DeleteMapping("/comments/delete/{id}")
	public Status deleteComment(@PathVariable Integer id, HttpServletRequest req) {
		if (!validate(req))
			return null;

		commentsRepo.deleteById(id);
		return new Status(true);
	}

}

package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

import com.posts.Post;
import com.posts.PostsRepository;
import com.posts.Status;
import com.posts.User;
import com.posts.UsersRepository;

@RestController
@CrossOrigin(origins = { "*" }, methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })

@RequestMapping("posts")
public class Controller {

	@Autowired
	private UsersRepository userRepo;

	@Autowired
	private PostsRepository repo;

	@PostMapping("/signup")
	public User signUp(HttpServletRequest req, @RequestBody User user) {

		User result = null;
		try {
			result = userRepo.save(user);
			HttpSession session = req.getSession();
			session.setAttribute("userName", result.getUserName());
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}

	}

	@PostMapping("/signin")
	public Status signIn(HttpServletRequest req, @RequestBody User user) {
		User temp = userRepo.findByUserName(user.getUserName());

		if (temp.getPassword().equals(user.getPassword())) {
			HttpSession session = req.getSession();
			session.setAttribute("userName", temp.getUserName());
			return new Status(true);
		}
		return new Status(false);
	}

	@PostMapping("/signout")
	public Status logout(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("userName") != null) {
			session.invalidate();
			return new Status(true);
		}
		return new Status(false);
	}

	@GetMapping("/all")
	public List<Post> getPosts(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		if (session == null || session.getAttribute("userName") == null)
			return null;
		List<Post> posts = new ArrayList<Post>();
		Iterable<Post> iterable = repo.findAll();
		for (Post post : iterable) {
			posts.add(post);
		}
		return posts;
	}

	@PostMapping("/add")
	public Post savePost(HttpServletRequest req, @RequestBody Post post) {
		HttpSession session = req.getSession(false);
		if (session == null || session.getAttribute("userName") == null)
			return null;
		post = repo.save(post);
		return post;
	}

	@DeleteMapping("/delete/{id}")
	public Status deletePost(HttpServletRequest req, @PathVariable Integer id) {
		HttpSession session = req.getSession(false);
		if (session == null || session.getAttribute("userName") == null)
			return null;
		repo.deleteById(id);
		return new Status(true);
	}

	@PutMapping("/edit")
	public Post editPost(HttpServletRequest req, @RequestBody Post post) {
		HttpSession session = req.getSession(false);
		if (session == null || session.getAttribute("userName") == null)
			return null;
		post = repo.save(post);
		return post;
	}

}
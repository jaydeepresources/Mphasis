package com.example.postbook;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
public class AppController {

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private PostsRepository postsRepository;

	@Autowired
	private HttpSession httpSession;

	public UsersRepository getUsersRepository() {
		return usersRepository;
	}

	public void setUsersRepository(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	public boolean validate() {
		return (httpSession.getAttribute("userId") == null) ? false : true;
	}

	@PostMapping("/signup")
	public User signUp(@RequestBody User user) {
		try {
			user = usersRepository.save(user);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		if (user.getUserId() != 0) {
			return user;
		}
		return null;
	}

	@PostMapping("/signin")
	public User signIn(@RequestBody User user) {
		User dbUser = usersRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());

		if (dbUser != null && dbUser.getUsername().equals(user.getUsername())
				&& dbUser.getPassword().equals(user.getPassword())) {
			httpSession.setAttribute("userId", dbUser.getUserId());
			return dbUser;
		}
		return null;
	}

	@GetMapping("/posts")
	public List<Post> getPosts() {
		return (validate()) ? (List<Post>) postsRepository.findAll() : null;
	}

	@PostMapping("/posts/add")
	public Post addPost(@RequestBody Post post) {
		return (validate()) ? postsRepository.save(post) : null;
	}

	@PutMapping("/posts/update")
	public Post updatePost(@RequestBody Post post) {
		return (validate()) ? postsRepository.save(post) : null;
	}

	@DeleteMapping("/posts/delete/{id}")
	public Status deletePost(@PathVariable Integer id) {
		if (!validate()) {
			return null;
		}
		try {
			postsRepository.deleteById(id);
			return new Status(true);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new Status(false);
		}
	}

}

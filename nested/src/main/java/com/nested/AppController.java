package com.nested;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = { "*" }, methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
public class AppController {

	@Autowired
	PostRepository postRepo;

	@Autowired
	CommentRepository commentRepo;
	
	@Autowired
	UsersRepository userRepo;

	@PostMapping("/user/save")
	public User saveUser(@RequestBody User user) {
		return userRepo.save(user);
	}

	@PostMapping("/post/save")
	public Post savePost(@RequestBody Post post) {
		post.setUser(new User());
		post.getUser().setId(post.getUfk());
		return postRepo.save(post);
	}

	@PostMapping("/comment/save")
	public Comment saveComment(@RequestBody Comment comment) {
		comment.setPost(new Post());
		comment.getPost().setId(comment.getFk());
		return commentRepo.save(comment);
	}
	
}

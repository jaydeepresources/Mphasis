package com.posts;

import java.util.List;

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

import dao.PostDAOImpl;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT })
@RequestMapping("posts")
public class PostsController {

	PostDAOImpl impl = new PostDAOImpl();

	@GetMapping("/all")
	public List<Post> getPosts() {
		return impl.view();
	}

	@PostMapping("/add")
	public Post insert(@RequestBody Post post) {
		return impl.insert(post);
	}

	@PutMapping("/update")
	public Post updatePost(@RequestBody Post post) {
		return impl.update(post);
	}

	@DeleteMapping("/delete/{id}")
	public Status deletePost(@PathVariable int id) {
		return impl.delete(new Post(id, "", ""));
	}
}

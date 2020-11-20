package com.example.postbook;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private HttpSession httpSession;

	public UsersRepository getUsersRepository() {
		return usersRepository;
	}

	public void setUsersRepository(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	@PostMapping("/signup")
	public User signUp(@RequestBody User user) {
		user = usersRepository.save(user);
		if (user.getUserId() != 0) {
			httpSession.setAttribute("userId", user.getUserId());
			return user;
		}
		return null;
	}

	@PostMapping("/signin")
	public User signIn(@RequestBody User user) {
		User dbUser = usersRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());

		if (dbUser != null && dbUser.getUsername().equals(user.getUsername()) && dbUser.getPassword().equals(user.getPassword())) {
			httpSession.setAttribute("userId", user.getUserId());
			return dbUser;
		}
		return null;
	}

}

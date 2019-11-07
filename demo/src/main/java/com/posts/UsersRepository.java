package com.posts;

import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<User, String>{

	User findByUserName(String userName);
}

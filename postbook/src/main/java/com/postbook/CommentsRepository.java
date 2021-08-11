package com.postbook;

import org.springframework.data.repository.CrudRepository;

public interface CommentsRepository extends CrudRepository<Comment, Integer> {

}

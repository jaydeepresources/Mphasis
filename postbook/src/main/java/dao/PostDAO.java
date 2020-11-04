package dao;

import java.util.List;

import com.crud.Post;
import com.crud.Status;

public interface PostDAO {
	
	Post insert(Post post);
	Post update(Post post);
	Status delete(Post post);
	List<Post> view();

}
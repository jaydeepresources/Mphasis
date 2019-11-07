package dao;

import java.util.List;

import com.posts.Post;
import com.posts.Status;

public interface PostDAO {
	
	Post insert(Post post);
	Post update(Post post);
	Status delete(Post post);
	List<Post> view();

}

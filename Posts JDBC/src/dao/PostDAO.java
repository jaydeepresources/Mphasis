package dao;

import java.util.List;

import model.Post;

public interface PostDAO {
	
	int insert(Post post);
	int update(Post post);
	int delete(int id);
	List<Post> view();
	Post view(int id);

}

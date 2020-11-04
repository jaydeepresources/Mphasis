package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.crud.Post;
import com.crud.Status;

public class PostDAOImpl implements PostDAO {

	private static SessionFactory factory;
	private Session session;
	private Transaction transaction;

	static {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		factory = config.buildSessionFactory();
	}

	public PostDAOImpl() {

	}

	public Post insert(Post post) {
		session = factory.openSession();
		transaction = session.beginTransaction();
		session.save(post);
		transaction.commit();
		session.close();
		return post;
	}

	public Post update(Post post) {
		session = factory.openSession();
		transaction = session.beginTransaction();
		Post temp = session.get(Post.class, post.getId());
		temp.setTitle(post.getTitle());
		temp.setBody(post.getBody());
		session.update(temp);
		transaction.commit();
		session.close();
		return temp;
	}

	public Status delete(Post post) {
		session = factory.openSession();
		transaction = session.beginTransaction();
		Post temp = session.get(Post.class, post.getId());
		session.delete(temp);
		transaction.commit();
		session.close();
		return new Status(true);
	}

	public List<Post> view() {
		session = factory.openSession();
		transaction = session.beginTransaction();
		Query query = session.createQuery("from Post");
		List<Post> list = query.list();
		transaction.commit();
		session.close();
		return list;
	}

}

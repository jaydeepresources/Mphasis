package model;

public class Post {

	int id;
	String title;
	String body;
	int uid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public Post() {
		
	}

	public Post(int id, String title, String body, int uid) {
		super();
		this.id = id;
		this.title = title;
		this.body = body;
		this.uid = uid;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", body=" + body + ", uid=" + uid + "]";
	}

}

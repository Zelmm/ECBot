package users;

public class User {
	
	private final int uid;
	private boolean news = false;
	
	public User(int uid) {
		this.uid = uid;
	}
	
	public int getUid() {
		return uid;
	}
	
	public boolean isNews() {
		return news;
	}
	
	public void setNews(boolean news) {
		this.news = news;
	}
}

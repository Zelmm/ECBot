package main.config.users;

public class User {
	
	private final int uid;
	private boolean news = false;
	private Status status;
	
	public User(int uid) {
		this.uid = uid;
		status = new Status();
	}
	
	public User(int uid, boolean news) {
		this.uid = uid;
		this.news = news;
		status = new Status();
	}
	
	public Status getStatus() {
		return status;
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

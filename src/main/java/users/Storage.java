package users;

import java.util.HashMap;

public class Storage {
	private HashMap<Integer, User> usersMap = new HashMap<Integer, User>();
	
	public void addUser (User user){
		usersMap.put(user.getUid(), user);
	}
}

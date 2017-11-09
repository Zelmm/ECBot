package main.config.users;

import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Storage {
	private HashMap<Integer, User> usersMap = new HashMap<Integer, User>();
	
	public Storage(JSONObject usersJson) {
		if (usersJson == null)throw new NullPointerException("UserJson is not create.");
		JSONArray userArray = (JSONArray)usersJson.get("users");
		if (userArray == null) throw new NullPointerException("User array in userJson is not create.");
		if (userArray.isEmpty()) throw new NullPointerException("User array not contains any user.");
		for (int i = 0; i < userArray.size(); i++) {
			JSONObject oneUser = (JSONObject) userArray.get(i);
			usersMap.put((int)oneUser.get("uid"), new User((int)oneUser.get("uid"), (boolean)oneUser.get("news")));
		}
	}
	
	public void addUser (User user){
		usersMap.put(user.getUid(), user);
	}
	
	public HashMap<Integer, User> getUsersMap() {
		return usersMap;
	}
	
	public User getUser (int id) {
		return usersMap.get(id);
	}
}

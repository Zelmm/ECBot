package main.config.content;

import java.util.TreeMap;

import org.json.simple.JSONObject;

public class ContentPart {
	
	private TreeMap<Integer, Action> actionMap = new TreeMap<Integer, Action>();
	
	public ContentPart(JSONObject actionPart) {
		for (Object key : actionPart.keySet()) {
			actionMap.put(Integer.parseInt(key.toString()), new Action((JSONObject)actionPart.get(key)));
		}
	}
	
	public TreeMap<Integer, Action> getActionMap() {
		return actionMap;
	}

}

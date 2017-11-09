package main.config.content;

import java.util.HashMap;

import org.json.simple.JSONObject;

public class Content {
	
	private HashMap<String, ContentPart> contentMap = new HashMap<String, ContentPart>();
	
	public Content(JSONObject jsonContent) {
		for (Object key : jsonContent.keySet()) {
			contentMap.put(key.toString(), new ContentPart((JSONObject)jsonContent.get(key)));
		}
	}
	
	public HashMap<String, ContentPart> getContentMap() {
		return contentMap;
	}
}

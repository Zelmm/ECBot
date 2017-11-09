package main.config.content;

import org.json.simple.JSONObject;

public class Action {
	
	private String photoTitle;
	private String photoLink;
	private String text;
	
	public Action(JSONObject jsonAction) {
		if (jsonAction == null) throw new NullPointerException("JsonAction is null");
		if (jsonAction.get("photo") == null) throw new NullPointerException("Photo in action is null");
		if (jsonAction.get("text") == null) throw new NullPointerException("Text in action is null");
		
		JSONObject photo = (JSONObject) jsonAction.get("photo");
		photoLink = photo.get("link").toString().length() == 0 ? null : photo.get("link").toString();
		photoTitle = photo.get("title").toString().length() == 0 ? null : photo.get("title").toString();
		text = jsonAction.get("text").toString().length() == 0 ? null : jsonAction.get("text").toString();
	}
	
	public String getPhotoLink() {
		return photoLink;
	}
	
	public String getPhotoTitle() {
		return photoTitle;
	}
	
	public String getText() {
		return text;
	}
}


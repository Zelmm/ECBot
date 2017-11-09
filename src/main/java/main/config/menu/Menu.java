package main.config.menu;

import java.util.HashMap;

import org.json.simple.JSONObject;

public class Menu {
	
	private HashMap<String, MenuPart> menuMap = new HashMap<String, MenuPart>();
	
	public Menu(JSONObject jsonMenu) {
		for (Object jsonKey : jsonMenu.keySet()) {
			menuMap.put(jsonKey.toString(), new MenuPart((JSONObject)jsonMenu.get(jsonKey)));
		}
	}
	
	public HashMap<String, MenuPart> getMenuMap() {
		return menuMap;
	}
	
	public MenuPart getMPart (String mPartId) {
		return menuMap.get(mPartId);
	}
}

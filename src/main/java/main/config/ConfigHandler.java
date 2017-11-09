package main.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import main.config.content.Content;
import main.config.menu.Menu;
import main.config.users.Storage;

public class ConfigHandler {
	
	private JSONParser parser = new JSONParser();
	private Menu menu;
	private Content content; 
	private Storage storage;
	public static HashMap<String, String> actionCheckMap = new HashMap<String, String>();
	public static HashMap<String, String> gotoCheckMap = new HashMap<String, String>();
//	public static HashMap<String, String> buttonStatusMap = new HashMap<>();
//	public static HashMap<String, String> buttonActionMap = new HashMap<>();
	
	
	public void loadFiles() throws IOException{
		
		JSONObject jsonMenu = null;
		JSONObject jsonContent = null;
		JSONObject jsonUsers = null;
		
		try {
			jsonMenu = (JSONObject) parser.parse(new InputStreamReader(new FileInputStream(new File("menu.json")), StandardCharsets.UTF_8));
			jsonContent = (JSONObject) parser.parse(new InputStreamReader(new FileInputStream(new File("content.json")), StandardCharsets.UTF_8));
			jsonUsers = (JSONObject) parser.parse(new InputStreamReader(new FileInputStream(new File("content.json")), StandardCharsets.UTF_8));
		} catch (IOException | ParseException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		for (Object menuKey : jsonMenu.keySet()) {
			gotoCheckMap.put(menuKey.toString(), null);
		}
		
		for (Object contentKey : jsonContent.keySet()) {
			actionCheckMap.put(contentKey.toString(), null);
		}
		
		menu = new Menu(jsonMenu);
		content = new Content(jsonContent);
		storage = new Storage(jsonUsers);
		
		if (menu.getMenuMap().size() != gotoCheckMap.size()) {
			System.out.println(menu.getMenuMap().keySet());
			System.out.println(gotoCheckMap.keySet());
			throw new IOException("Wrong goto list.");
		}
		
		if (content.getContentMap().size() != actionCheckMap.size()) {
			System.out.println(content.getContentMap().keySet());
			System.out.println(actionCheckMap.keySet());
			throw new IOException("Wrong action list.");
		}
	}
	
	public Menu getMenu() {
		return menu;
	}
	
	public Content getContent() {
		return content;
	}
	
	public Storage getStorage() {
		return storage;
	}
}

package main.config.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.pengrad.telegrambot.model.request.KeyboardButton;
import com.pengrad.telegrambot.model.request.ReplyKeyboardMarkup;

import main.config.ConfigHandler;

public class MenuPart {
	
	private String text; 
	private String action;
	private TreeMap<Integer, Row> rowsMap = new TreeMap<Integer, MenuPart.Row>();
	private HashMap<String, Button> buttonMap = new HashMap<>();
	
	public MenuPart(JSONObject menuPart) {
		if (menuPart.containsKey("text")) text = menuPart.get("text").toString();
		if (menuPart.containsKey("action")) action = menuPart.get("action").toString();
		createRows((JSONObject)menuPart.get("buttons"));
	}
	
	public Button getButtonMap(String buttonText) {
		return buttonMap.get(buttonText);
	}
	
	public String getText() {
		return text;
	}
	
	public String getAction() {
		return action;
	}
	
	public TreeMap<Integer, Row> getRowsMap() {
		return rowsMap;
	}
	
	private void createRows (JSONObject buttons) {
		if (buttons == null) throw new NullPointerException("Empty buttons object.");
		if (!buttons.containsKey("1")) throw new NullPointerException("Buttons object not contains any row.");
		for (Object oneRowKey : buttons.keySet()) {
			JSONArray row = (JSONArray) buttons.get(oneRowKey);
			if (row.isEmpty()) throw new NullPointerException("Row " + oneRowKey + " is empty");
			rowsMap.put(Integer.parseInt((String)oneRowKey), new Row(row));
		}
	}
	
	public ReplyKeyboardMarkup replyKeyboardMarkupBuilder () {
		KeyboardButton[][] kbba = new KeyboardButton[rowsMap.size()][];
		
		for (Integer rowNumber : rowsMap.keySet()) {
			KeyboardButton[] innerKbba = new KeyboardButton[rowsMap.get(rowNumber).buttons.size()];
			for (int i = 0; i < innerKbba.length; i++) {
				innerKbba[i] = new KeyboardButton(rowsMap.get(rowNumber).buttons.get(i).getText());
			}
		}
		return new ReplyKeyboardMarkup(kbba).resizeKeyboard(true).selective(true);		
	}
	
	private class Row {
		private ArrayList<Button> buttons = new ArrayList<Button>();
		
		public Row(JSONArray rowButtons) {
			for (int i = 0; i < rowButtons.size(); i++) {
				JSONObject oneJsonButton = (JSONObject) rowButtons.get(i);
				Button oneButton = new Button(oneJsonButton.get("text").toString());
				if (oneJsonButton.get("goto") != null) {
					oneButton.setMove(oneJsonButton.get("goto").toString());
					ConfigHandler.gotoCheckMap.put(oneJsonButton.get("goto").toString(), oneJsonButton.get("goto").toString());
				}
				if (oneJsonButton.get("action") != null) {
					oneButton.setAction(oneJsonButton.get("action").toString());
					ConfigHandler.actionCheckMap.put(oneJsonButton.get("action").toString(), oneJsonButton.get("action").toString());
				}
				buttons.add(oneButton);
				buttonMap.put(oneJsonButton.get("text").toString(), oneButton);
			}
		}
	}
}

package main;

import java.io.IOException;

import bot.Bot;
import main.config.ConfigHandler;

public class Main {
	
	public static Bot bot = new Bot(); 
	public static ConfigHandler configHandler = new ConfigHandler();
	
	public static void main(String[] args) {
		try {
			configHandler.loadFiles();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void reloadFIles() {
		try {
			configHandler.loadFiles();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

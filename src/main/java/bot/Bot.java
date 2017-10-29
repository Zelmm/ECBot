package bot;

import java.util.List;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;

import comands.ComandHandler;

public class Bot {
	TelegramBot bot = new TelegramBot("462265163:AAG2Tgr8ULYDGZKgn8dPmM1oRJx3KpJRlAA");
	
	public Bot() {
		bot.setUpdatesListener(new UpdatesListener() {
			public int process(List<Update> updates) {
				for (Update update : updates){
					ComandHandler.Handler(update);
				}
				return CONFIRMED_UPDATES_ALL;
			}
		});
	}
}

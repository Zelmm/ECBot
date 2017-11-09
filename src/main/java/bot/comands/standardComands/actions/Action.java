package bot.comands.standardComands.actions;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.Keyboard;
import com.pengrad.telegrambot.request.SendMessage;

import main.Main;
import main.config.menu.MenuPart;
import main.config.users.User;

public class Action {

	public static void action(Update update, String buttonAct) {
		User user = Main.configHandler.getStorage().getUsersMap().get(update.message().from().id());
		
		if (user.getStatus().getStatusString().equals("main.subscribe")){
			CustomActions.subscribe(update, buttonAct);
		} 
		
		MenuPart mPart = Main.configHandler.getMenu().getMenuMap().get(user.getStatus().getStatusString());
				
		Keyboard keyboard = mPart.replyKeyboardMarkupBuilder(); 
		
		SendMessage sm = new SendMessage(user.getUid(), mPart.getText()).replyMarkup(keyboard);
		
		Main.bot.sendMessage(sm);
	}
	
}

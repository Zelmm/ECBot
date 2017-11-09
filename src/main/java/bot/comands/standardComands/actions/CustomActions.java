package bot.comands.standardComands.actions;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.Keyboard;
import com.pengrad.telegrambot.request.SendMessage;

import main.Main;
import main.config.menu.MenuPart;
import main.config.users.User;

public class CustomActions {
	
	public static void backAction (Update update){
		User user = Main.configHandler.getStorage().getUser(update.message().from().id());
		user.getStatus().downgradeStatus();
		MenuPart mPart = Main.configHandler.getMenu().getMPart(user.getStatus().getStatusString());
		
		Keyboard keyboard = mPart.replyKeyboardMarkupBuilder(); 
		
		SendMessage sm = new SendMessage(user.getUid(), mPart.getText()).replyMarkup(keyboard);
		
		Main.bot.sendMessage(sm);
	}
	
	public static void subscribe(Update update, String buttonAct) {
		
	}

}

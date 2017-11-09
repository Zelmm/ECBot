package bot.comands.standardComands.moves;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.Keyboard;
import com.pengrad.telegrambot.request.SendMessage;

import main.Main;
import main.config.menu.MenuPart;
import main.config.users.User;

public class CustomMoves {

	public static void mainMove(Update update) {
		User user = Main.configHandler.getStorage().getUser(update.message().from().id());
		user.getStatus().mainStatus();
		MenuPart mPart = Main.configHandler.getMenu().getMPart(user.getStatus().getStatusString());
		
		Keyboard keyboard = mPart.replyKeyboardMarkupBuilder(); 
		
		SendMessage sm = new SendMessage(user.getUid(), mPart.getText()).replyMarkup(keyboard);
		
		Main.bot.sendMessage(sm);
	}
	
}

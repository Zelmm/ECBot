package bot.comands;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.Keyboard;
import com.pengrad.telegrambot.request.SendMessage;

import bot.comands.standardComands.actions.Action;
import bot.comands.standardComands.actions.CustomActions;
import bot.comands.standardComands.moves.CustomMoves;
import bot.comands.standardComands.moves.Move;
import main.Main;
import main.config.menu.Button;
import main.config.menu.MenuPart;
import main.config.users.User;

public class ComandHandler {
	
	public static void toHandle(Update update){
		
		switch (update.message().text()){
			case "/start" : {
				if (!Main.configHandler.getStorage().getUsersMap().containsKey(update.message().from().id())){
					Main.configHandler.getStorage().addUser(new User(update.message().from().id()));
					Move.move(update, "main");
				}
			}
			break;
			case "/reload" : {
				if (update.message().from().id() == 303901151) Main.reloadFIles();
			}
			break;
			case "Назад" : {
				CustomActions.backAction(update);
			}
			break;
			case "Главное меню" : {
				CustomMoves.mainMove(update);
			}
			break;
			default : {
				choseAct(update);
			}
			break;
		}
	}
	
	private static void choseAct(Update update) {
		User user = Main.configHandler.getStorage().getUser(update.message().from().id());
		MenuPart mPart = Main.configHandler.getMenu().getMPart(user.getStatus().getStatusString());
		Button button = mPart.getButtonMap(update.message().text());
		
		if (button.isMove()) Move.move(update, button.getAct());
		else Action.action(update, button.getAct());
	}
}
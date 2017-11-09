package main.config.menu;

public class Button {
	
	private String text;
	private boolean isMove = false;
	private String move = null;
	private String action = null;

	public Button(String text) {
		this.text = text;
	}
	
	public void setAction(String action) {
		this.action = action;
	}
	
	public void setMove(String move) {
		this.move = move;
		isMove = true;
	}
	
	public boolean isMove() {
		return isMove;
	}
	
	public String getAct(){
		if (move != null) return move;
		else return action;
	}
	
	public String getText() {
		return text;
	}
}

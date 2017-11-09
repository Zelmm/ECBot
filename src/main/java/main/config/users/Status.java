package main.config.users;

public class Status {
	
	private String status;
	
	public Status() {
		status = "main";
	}
	
	public String getStatusString() {
		return status;
	}
	
	public void upgradeStatus(String status) {
		this.status = this.status + "." + status;
	}
	
	public void downgradeStatus() {
		String [] statusArray = this.status.split(".");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < statusArray.length-1; i++) {
			sb.append(statusArray[i] + ".");
		}
		
		this.status = sb.delete(sb.length()-1, sb.length()).toString();
	}
	
	public void mainStatus(){
		status = "main";
	}
}
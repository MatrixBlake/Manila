
public class Player {
	private int blackNumber;
	private int blueNumber;
	private int yellowNumber;
	private int greenNumber;
	private int money;
	
	public Player(String s1, String s2) {
		buyStock(s1);
		buyStock(s2);
		money=30;
	}
	
	public void buyStock(String s) {
		if(s.equals("black")) {blackNumber++;}
		if(s.equals("blue")) {blueNumber++;}
		if(s.equals("yellow")) {yellowNumber++;}
		if(s.equals("green")) {greenNumber++;}
	}
	
	public void pay(int a) {
		money=money-a;
	}
	
	public void earn(int a) {
		money=money+a;
	}
	
	public int getBlack() {return blackNumber;}
	public int getBlue() {return blueNumber;}
	public int getYellow() {return yellowNumber;}
	public int getGreen() {return greenNumber;}
	public int getMoney() {return money;}
	
}

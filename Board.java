import java.util.ArrayList;

import javax.swing.*;

public class Board {
	private Players players;
	private Boats boats;
	private Stocks stocks;
	private int captain;
	Object[] possibleValues = { "black", "blue", "yellow","green" };
	
	public Board() {
		int n= Integer.parseInt((String) JOptionPane.showInputDialog(null, "Input the number of players", "Input", JOptionPane.PLAIN_MESSAGE, null, null,null));
		players=new Players(n);
		stocks=new Stocks();
		captain=0;				
	}
	
	public void bid() {
		int bid=0;
		int n=0;
		boolean brk=false;
		ArrayList<Integer> withdraw= new ArrayList<Integer>();
		int max=0;
		while(true) {						
			for(int i=0;i<players.getNumber();i++) {
				while(withdraw.contains(i)) {i++;}
				bid= Integer.parseInt((String) JOptionPane.showInputDialog(null, "Player"+(i+1)+", please input the bid", "Input", JOptionPane.PLAIN_MESSAGE, null, null,null));
				if(bid==0) {n++;withdraw.add(i);}
				else {captain=i;max=bid;}
				if(n==players.getNumber()-1) {brk=true;JOptionPane.showMessageDialog(null, "Player"+(captain+1)+" becomes the captain!", "We got a winner",  JOptionPane.DEFAULT_OPTION);break;}
			}
			if(brk==true) {break;}
		}
		players.pay(captain, max);
		String stk=(String) JOptionPane.showInputDialog(null, "Captain"+(captain+1)+" , buy 1 stock", "Buy", JOptionPane.INFORMATION_MESSAGE, null, possibleValues, possibleValues[0]);
		players.buyStock(captain, stk);
		if(stocks.getPrice(stk)==0)players.pay(captain, 5);
		else players.pay(captain, stocks.getPrice(stk));
		System.out.println(players);
	}
	
	public void setBoats() {
		String stk=(String) JOptionPane.showInputDialog(null, "Captain"+(captain+1)+" , choose 1 stock that won't be on the boats", "Boats", JOptionPane.INFORMATION_MESSAGE, null, possibleValues, possibleValues[0]);
		ArrayList<String> goods= new ArrayList<String>();
		goods.add("black");
		goods.add("blue");
		goods.add("green");
		goods.add("yellow");
		goods.remove(stk);
		int p1= Integer.parseInt((String) JOptionPane.showInputDialog(null, "Captain"+(captain+1)+", please set the position of "+goods.get(0), "Postion", JOptionPane.PLAIN_MESSAGE, null, null,null));
		int p2= Integer.parseInt((String) JOptionPane.showInputDialog(null, "Captain"+(captain+1)+", please set the position of "+goods.get(1), "Postion", JOptionPane.PLAIN_MESSAGE, null, null,null));
		int p3= Integer.parseInt((String) JOptionPane.showInputDialog(null, "Captain"+(captain+1)+", please set the position of "+goods.get(2), "Postion", JOptionPane.PLAIN_MESSAGE, null, null,null));
		boats=new Boats(goods.get(0),p1,goods.get(1),p2,goods.get(2),p3);
		System.out.println(boats);
	}
	
	public static void main(String[] args) {
		Board bo= new Board();
		while(!bo.stocks.finish()) {
			bo.bid();
			bo.setBoats();
			
		}
		
		
	}

}

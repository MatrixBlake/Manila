import java.util.ArrayList;

import javax.swing.*;

public class Board {
	private Players players;
	private Boats boats;
	private Stocks stocks;
	
	public Board() {
		int n= Integer.parseInt((String) JOptionPane.showInputDialog(null, "Input the number of players", "Input", JOptionPane.PLAIN_MESSAGE, null, null,null));
		players=new Players(n);
		stocks=new Stocks();
	}
	
	public void bid() {
		int bid=0;
		int n=0;
		boolean brk=false;
		int captain=0;
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
		String stk=(String) JOptionPane.showInputDialog(null, "Player"+(captain+1)+", please buy a stock" , "Input", JOptionPane.PLAIN_MESSAGE, null, null,null);
		players.buyStock(captain, stk);
		if(stocks.getPrice(stk)==0)players.pay(captain, 5);
		else players.pay(captain, stocks.getPrice(stk));
		System.out.println(players);
	}
	
	public static void main(String[] args) {
		Board bo= new Board();
		bo.bid();
		
	}

}

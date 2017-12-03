import java.util.ArrayList;

import javax.swing.*;

public class Board {
	private Players players;
	private Boats boats;
	private Stocks stocks;
	private int captain;
	Object[] possibleValues = { "black", "blue", "yellow","green" };
	private ArrayList<Integer> wharfPosition;
	private ArrayList<Integer> wharfPrice;
	private ArrayList<Integer> shipyardPosition; 
	private ArrayList<Integer> shipyardPrice;
	private int insurrance; 
	private int getToWharf;
	private int getToShipyard;
	
	public Board() {
		int n= Integer.parseInt((String) JOptionPane.showInputDialog(null, "Input the number of players", "Input", JOptionPane.PLAIN_MESSAGE, null, null,null));
		players=new Players(n);
		stocks=new Stocks();
		wharfPrice=new ArrayList<Integer>();
		wharfPrice.add(4);
		wharfPrice.add(3);
		wharfPrice.add(2);
		shipyardPrice= new ArrayList<Integer>();
		shipyardPrice.add(4);
		shipyardPrice.add(3);
		shipyardPrice.add(2);
		captain=0;	
		insurrance=0;
		System.out.println(players);
	}
	
	public void bid() {
		wharfPosition=new ArrayList<Integer>();
		shipyardPosition=new ArrayList<Integer>();
		getToWharf=0;
		getToShipyard=0;
		for(int i=0;i<3;i++) {wharfPosition.add(0);}
		for(int i=0;i<3;i++){shipyardPosition.add(0);}
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
	}
		
	public void buyStock() {
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
	
	public void dice() {
		boats.dice();
		System.out.println(boats);
	}
	
	public Object[] takePosition(Object[] AllPostions) {
		for(int i=0;i<players.getNumber();i++) {
			String choice=(String) JOptionPane.showInputDialog(null, "Player"+(i+1)+" , choose 1 position", "Position", JOptionPane.INFORMATION_MESSAGE, null, AllPostions, AllPostions[0]);
			if(choice.equals(boats.getBoat(0).getName())) {
				players.pay(i, boats.takePosition(0, (i+1)));
				if(boats.getBoat(0).getPositionTaken().get(boats.getBoat(0).getPositionTaken().size()-1)>0){AllPostions=remove(AllPostions,boats.getBoat(0).getName());}
			}
			if(choice.equals(boats.getBoat(1).getName())) {
				players.pay(i, boats.takePosition(1, (i+1)));
				if(boats.getBoat(1).getPositionTaken().get(boats.getBoat(1).getPositionTaken().size()-1)>0){AllPostions=remove(AllPostions,boats.getBoat(1).getName());}
			}
			if(choice.equals(boats.getBoat(2).getName())) {
				players.pay(i, boats.takePosition(2, (i+1)));
				if(boats.getBoat(2).getPositionTaken().get(boats.getBoat(2).getPositionTaken().size()-1)>0){AllPostions=remove(AllPostions,boats.getBoat(2).getName());}
			}
			if(choice.equals("whalf1")) {wharfPosition.set(0, i+1);players.pay(i, wharfPrice.get(0));AllPostions=remove(AllPostions,"whalf1");}
			if(choice.equals("whalf2")) {wharfPosition.set(1, i+1);players.pay(i, wharfPrice.get(1));AllPostions=remove(AllPostions,"whalf2");}
			if(choice.equals("whalf3")) {wharfPosition.set(2, i+1);players.pay(i, wharfPrice.get(2));AllPostions=remove(AllPostions,"whalf3");}
			if(choice.equals("shipyard1")) {shipyardPosition.set(0, i+1);players.pay(i, shipyardPrice.get(0));AllPostions=remove(AllPostions,"shipyard1");}
			if(choice.equals("shipyard2")) {shipyardPosition.set(1, i+1);players.pay(i, shipyardPrice.get(1));AllPostions=remove(AllPostions,"shipyard2");}
			if(choice.equals("shipyard3")) {shipyardPosition.set(2, i+1);players.pay(i, shipyardPrice.get(2));AllPostions=remove(AllPostions,"shipyard3");}
			if(choice.equals("insurrance")) {insurrance=i;players.earn(i,10);AllPostions=remove(AllPostions,"insurrance");}
		}
		return AllPostions;		
	}
	
	public Object[] remove(Object[] AllPostions, String s) {
		ArrayList<Object> l=new ArrayList<Object>();
		for(int i=0;i<AllPostions.length;i++) {l.add(AllPostions[i]);}
		l.remove(s);
		Object[] array = (Object[])l.toArray(new Object[l.size()]); 
		return array;
	}
	
	public String positionSituation() {
		String s="";
		s=s+boats.toString();
		s=s+"wharf:";
		for(int i=0;i<3;i++) {s=s+" "+wharfPosition.get(i);}
		s=s+"\r\n";
		s=s+"shipyard:";
		for(int i=0;i<3;i++) {s=s+" "+shipyardPosition.get(i);}
		s=s+"\r\n";
		s=s+"insurrance: "+insurrance+"\r\n";
		return s;
	}
	
	public void check() {
		getToWharf=0;
		getToShipyard=0;
		for(int i=0;i<3;i++) {
			if(boats.getPosition(i)>13) getToWharf++;
			if(boats.getPosition(i)<13) getToShipyard++;
		}
	}
	
	public String balance() {
		String s="";
		for(int i=0;i<3;i++) {
			if(boats.getBoat(i).getPosition()>13 && boats.getPositionTaken(i).get(0)>0) {
				int earn=boats.earning(i);
				for(int j=0;j<boats.getPositionTaken(i).size();j++) {
					if(boats.getPositionTaken(i).get(j)>0) {
						players.earn(boats.getPositionTaken(i).get(j)-1, earn);
						s=s+"player"+boats.getPositionTaken(i).get(j)+" earns "+earn+" for "+boats.getBoat(i).getName()+"\r\n";
					}
				}
			}
		}
		if(wharfPosition.get(0)>0 && getToWharf>0) {
			players.earn(wharfPosition.get(0)-1, 6);
			s=s+"player"+wharfPosition.get(0)+" earns 6 for "+"wharf1\r\n";
		}
		if(wharfPosition.get(1)>0 && getToWharf>1) {
			players.earn(wharfPosition.get(1)-1, 8);
			s=s+"player"+wharfPosition.get(1)+" earns 8 for "+"wharf2\r\n";
		}
		if(wharfPosition.get(2)>0 && getToWharf>2) {
			players.earn(wharfPosition.get(2)-1, 15);
			s=s+"player"+wharfPosition.get(2)+" earns 15 for "+"wharf3\r\n";
		}
		if(shipyardPosition.get(0)>0 && getToShipyard>0) {
			players.earn(shipyardPosition.get(0)-1, 6);
			s=s+"player"+shipyardPosition.get(0)+" earns 6 for "+"shipyard1\r\n";
		}
		if(shipyardPosition.get(1)>0 && getToShipyard>1) {
			players.earn(shipyardPosition.get(1)-1, 8);
			s=s+"player"+shipyardPosition.get(1)+" earns 8 for "+"shipyard2\r\n";
		}
		if(shipyardPosition.get(2)>0 && getToShipyard>2) {
			players.earn(shipyardPosition.get(2)-1, 15);
			s=s+"player"+shipyardPosition.get(2)+" earns 6 for "+"shipyard3\r\n";
		}
		if(insurrance>0) {
			s=s+"player"+insurrance+" pays ";
			if(getToShipyard==1) {players.pay(insurrance-1, 6);s=s+6;}
			if(getToShipyard==2) {players.pay(insurrance-1, 14);s=s+14;}
			if(getToShipyard==3) {players.pay(insurrance-1, 29);s=s+29;}
			s=s+" for insurrance";
		}
		for(int i=0;i<3;i++) {if(boats.getPosition(i)>13) {stocks.updatePrice(boats.getBoat(i).getName());}}
		System.out.println(players);
		System.out.println(stocks);
		return s;
	}
	
	public Stocks getStocks() {return stocks;}
	public Players getPlayers() {return players;}
	public Boats getBoats() {return boats;}
	


}

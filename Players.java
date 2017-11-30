import java.util.*;

public class Players {
	private ArrayList<Player> list;
	
	public Players(int n) {
		list=new ArrayList<Player>();
		ArrayList<String> l=new ArrayList<String>();
		for(int i=0;i<5;i++) {l.add("black");}
		for(int i=0;i<5;i++) {l.add("blue");}
		for(int i=0;i<5;i++) {l.add("yellow");}
		for(int i=0;i<5;i++) {l.add("green");}
		for(int i=0;i<n;i++) {				
			int random1 = (int)(Math.random()*l.size());
			String s1=l.get(random1);
			l.remove(s1);
			int random2= (int)(Math.random()*l.size());
			String s2=l.get(random2);
			l.remove(s2);
			list.add(new Player(s1,s2));			
		}
	}
	
	public String toString() {
		String s="";
		for(int i=0;i<list.size();i++) {
			int n=i+1;
			s=s+"Player"+n+" black:"+list.get(i).getBlack()+" blue:"+list.get(i).getBlue()+" green:"+list.get(i).getGreen()+" yellow:"+list.get(i).getYellow()+" money: "+list.get(i).getMoney()+"\r\n";
		}
		return s;
	}
	
	public int getNumber() {
		return list.size();
	}
	
	public void buyStock(int i,String s) {
		list.get(i).buyStock(s);
	}
	
	public void pay(int i, int m) {
		list.get(i).pay(m);
	}
	
	public void earn(int i, int m) {
		list.get(i).earn(m);
	}
	
	public ArrayList<Player> getPlayersList(){return list;}
	

}

import java.util.*;
public class Stocks {
	private ArrayList<Stock> list;
	
	public Stocks() {
		list=new ArrayList<Stock>();
		Stock s0=new Stock("black");
		Stock s1=new Stock("blue");
		Stock s2=new Stock("yellow");
		Stock s3=new Stock("green");
		list.add(s0);
		list.add(s1);
		list.add(s2);
		list.add(s3);
	}
	
	public void updatePrice(String s) {
		if(s.equals("black")) {list.get(0).updatePrice();}
		if(s.equals("blue")) {list.get(1).updatePrice();}
		if(s.equals("yellow")) {list.get(2).updatePrice();}
		if(s.equals("green")) {list.get(3).updatePrice();}
	}
	
	public int getPrice(String s) {
		if(s.equals("black")) {return list.get(0).getPrice();}
		if(s.equals("blue")) {return list.get(1).getPrice();}
		if(s.equals("yellow")) {return list.get(2).getPrice();}
		if(s.equals("green")) {return list.get(3).getPrice();}
		return 0;
	}
	
	public boolean finish() {
		if(list.get(0).getPrice()==30||list.get(1).getPrice()==30||list.get(2).getPrice()==30||list.get(3).getPrice()==30) return true;
		else return false;
	}
	
	public String toString() {
		String s="";
		for(int i=0;i<4;i++) {
			s=s+list.get(i).getName()+": "+list.get(i).getPrice()+"\r\n";
		}		
		return s;
	}
	

}

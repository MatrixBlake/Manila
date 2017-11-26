import java.util.*;
public class Stocks {
	private ArrayList<Stock> list;
	
	public Stocks() {
		list.add(new Stock("black"));
		list.add(new Stock("blue"));
		list.add(new Stock("yellow"));
		list.add(new Stock("green"));
	}
	
	public void updatePrice(String s) {
		if(s.equals("black")) {list.get(0).updatePrice();}
		if(s.equals("blue")) {list.get(1).updatePrice();}
		if(s.equals("yellow")) {list.get(2).updatePrice();}
		if(s.equals("green")) {list.get(3).updatePrice();}
	}

}

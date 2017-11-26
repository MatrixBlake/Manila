import java.util.*;
public class Boat {
	private String name;
	private int totalPrice;
	private ArrayList<Integer> positionPrice;
	private ArrayList<Integer> positionTaken;
	private int position;
	
	public Boat(String s, int i) {
		name=s;
		position=i;
		if(s.equals("black")) {
			totalPrice=24;
			positionPrice.add(2);
			positionPrice.add(3);
			positionPrice.add(4);
		}
		if(s.equals("blue")) {
			totalPrice=30;
			positionPrice.add(3);
			positionPrice.add(4);
			positionPrice.add(5);
		}
		if(s.equals("yellow")) {
			totalPrice=18;
			positionPrice.add(1);
			positionPrice.add(2);
			positionPrice.add(3);
		}
		if(s.equals("green")) {
			totalPrice=36;
			positionPrice.add(3);
			positionPrice.add(4);
			positionPrice.add(5);
			positionPrice.add(5);
		}		
	}
	
	public void dice() {
		int random=(int)Math.random()*6+1;
		position=position+random;
	}
	
	
	
	
	
}

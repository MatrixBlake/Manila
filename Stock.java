
public class Stock {
	private String name;
	private int price;
	
	public Stock(String s) {
		name=s;
		price=0;
	}
	
	public void updatePrice() {
		if(price==0) {price=5;}
		if(price==5) {price=10;}
		if(price==10) {price=20;}
		if(price==20) {price=30;}
	}
	
	public String getName() {
		return name;
	}
}

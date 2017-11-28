import java.util.*;
public class Boats {
	ArrayList<Boat> list;
	
	public Boats(String s1, int i1, String s2, int i2, String s3, int i3) {
		list=new ArrayList<Boat>();
		list.add(new Boat(s1,i1));
		list.add(new Boat(s2,i2));
		list.add(new Boat(s3,i3));
	}
	
	public String toString() {
		String s="";
		for(int i=0;i<list.size();i++) {
			s=s+list.get(i).getName()+": "+list.get(i).getPosition()+". And on boat position taken situation:";
			for(int j=0;j<list.get(i).getPositionTaken().size();j++) {
				s=s+" "+list.get(i).getPositionTaken().get(j);
			}
			s=s+"\r\n";
		}
		return s;
	}
	
	public void dice() {
		list.get(0).dice();
		list.get(1).dice();
		list.get(2).dice();
	}
	
	public Boat getBoat(int i) {
		return list.get(i);
	}
	
	public int takePosition(int m, int n) {
		return list.get(m).takePosition(n);
	}
	
	public int earning(int m) {
		return list.get(m).earning();
	}
	
	public ArrayList<Integer> getPositionTaken(int m){
		return list.get(m).getPositionTaken();
	}
	
	public int getPosition(int m) {
		return list.get(m).getPosition();
	}

}

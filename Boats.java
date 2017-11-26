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
			s=s+list.get(i).getName()+" "+list.get(i).getPosition()+"\r\n";
		}
		return s;
	}
	

}

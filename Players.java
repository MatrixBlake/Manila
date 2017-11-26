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
			int random1 = (int)(Math.random()*l.size()+1);
			String s1=l.get(random1);
			l.remove(s1);
			int random2= (int)(Math.random()*l.size()+1);
			String s2=l.get(random2);
			l.remove(s2);
			list.add(new Player(s1,s2));			
		}
	}

}

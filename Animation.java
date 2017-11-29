import java.awt.*;
import javax.swing.*;

public class Animation {
	
	public static void main(String[] args) {
		
		Board bo= new Board();
		int boat1=0;
		int boat2=0;
		int boat3=0;

		class BoatFigure1 extends JPanel{
			public void paintComponent(Graphics g) {
				g.setColor(Color.white);
				g.fillRect(0, 0, this.getWidth(), this.getHeight());
				String c= bo.getBoats().getBoat(0).getName();
				int p=bo.getBoats().getBoat(0).getPosition();
				if(c.equals("black"))g.setColor(Color.black);
				if(c.equals("blue"))g.setColor(Color.blue);
				if(c.equals("yellow"))g.setColor(Color.yellow);
				if(c.equals("green"))g.setColor(Color.green);
				g.fillRect(p*50, 50, 200, 100);
			}
		}
		
		class BoatFigure2 extends JPanel{
			public void paintComponent(Graphics g) {
				g.setColor(Color.white);
				g.fillRect(0, 0, this.getWidth(), this.getHeight());
				String c= bo.getBoats().getBoat(1).getName();
				int p=bo.getBoats().getBoat(1).getPosition();
				if(c.equals("black"))g.setColor(Color.black);
				if(c.equals("blue"))g.setColor(Color.blue);
				if(c.equals("yellow"))g.setColor(Color.yellow);
				if(c.equals("green"))g.setColor(Color.green);
				g.fillRect(p*50, 50, 200, 100);
			}
		}
		
		class BoatFigure3 extends JPanel{
			public void paintComponent(Graphics g) {
				g.setColor(Color.white);
				g.fillRect(0, 0, this.getWidth(), this.getHeight());
				String c= bo.getBoats().getBoat(2).getName();
				int p=bo.getBoats().getBoat(2).getPosition();
				if(c.equals("black"))g.setColor(Color.black);
				if(c.equals("blue"))g.setColor(Color.blue);
				if(c.equals("yellow"))g.setColor(Color.yellow);
				if(c.equals("green"))g.setColor(Color.green);
				g.fillRect(p*50, 50, 200, 100);
			}
		}
		
		while(!bo.getStocks().finish()) {
			bo.bid();
			bo.setBoats();
			
			JFrame frame = new JFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 
			BoatFigure1 boatFigure1=new BoatFigure1();
			boatFigure1.setPreferredSize(new Dimension(1000, 200));
			BoatFigure2 boatFigure2=new BoatFigure2();
			boatFigure2.setPreferredSize(new Dimension(1000, 200));
			BoatFigure3 boatFigure3=new BoatFigure3();
			boatFigure3.setPreferredSize(new Dimension(1000, 200));
			frame.getContentPane().add(BorderLayout.NORTH,boatFigure1);
			frame.getContentPane().add(BorderLayout.CENTER,boatFigure2);
			frame.getContentPane().add(BorderLayout.SOUTH,boatFigure3);
			
			frame.setSize(1000, 600);
			frame.setVisible(true);
			
			for(int i=0;i<3;i++) {
				bo.takePosition();
				bo.dice();
				frame.repaint();
			}
			bo.check();
			bo.balance();			
		}
		System.out.println(bo.getPlayers());
		
		

	}

	

}

import java.awt.*;
import javax.swing.*;

public class Animation {
	
	public static void main(String[] args) {
		
		Board bo= new Board();
		
		class BoatFigure extends JPanel{
			public void paintComponent(Graphics g) {
				g.setColor(Color.white);
				g.fillRect(0, 0, this.getWidth(), this.getHeight());
				try {
				for(int i=0;i<3;i++) {
					String c= bo.getBoats().getBoat(i).getName();
					int p=bo.getBoats().getBoat(i).getPosition();
					if(c.equals("black"))g.setColor(Color.black);
					if(c.equals("blue"))g.setColor(Color.blue);
					if(c.equals("yellow"))g.setColor(Color.yellow);
					if(c.equals("green"))g.setColor(Color.green);					
					g.fillRect(p*50, 200*i, 200, 100);
					if(c.equals("black"))g.setColor(Color.white);	
					else{g.setColor(Color.BLACK);}
					String s="";
					for(int j:bo.getBoats().getBoat(i).getPositionTaken()) {s=s+j+" ";}					
					g.drawString(s+" "+p, p*50+20, 200*i+20);
				}
				}catch(Exception e) {}
			}
		}
		
		class Situation extends JPanel{
			public void paintComponent(Graphics g) {
				g.setColor(Color.white);
				g.fillRect(0, 0, this.getWidth(), this.getHeight());
				g.setColor(Color.BLACK);
				for(int i=0;i<bo.getPlayers().getNumber();i++) {
					g.drawString("Player"+(i+1)+" :"+bo.getPlayers().getPlayersList().get(i).toString(), 0, 20+20*i);
				}
				g.drawString(bo.getStocks().toString(), 0, 80);
				
			}
		}
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
		
		Situation situation=new Situation();
		situation.setPreferredSize(new Dimension(1000,100));
		frame.getContentPane().add(BorderLayout.SOUTH, situation);
		BoatFigure boatFigure=new BoatFigure();
		frame.getContentPane().add(BorderLayout.CENTER,boatFigure);	
		frame.setSize(1000, 800);
		frame.setVisible(true);
		
		while(!bo.getStocks().finish()) {
			bo.bid();
			frame.repaint();
			bo.buyStock();
			frame.repaint();
			bo.setBoats();
			frame.repaint();
			
			Object[] AllPostions= {bo.getBoats().getBoat(0).getName(),bo.getBoats().getBoat(1).getName(),bo.getBoats().getBoat(2).getName(),"whalf1","whalf2","whalf3","shipyard1","shipyard2","shipyard3","insurrance"};
			
			for(int i=0;i<3;i++) {
				AllPostions=bo.takePosition(AllPostions);
				frame.repaint();
				bo.dice();
				frame.repaint();
			}
			bo.check();
			String s=bo.balance();	
			JOptionPane.showMessageDialog(null, s, "balance result", JOptionPane.DEFAULT_OPTION);
		}
		System.out.println(bo.getPlayers());
	}
	

	

}

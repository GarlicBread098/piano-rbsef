package src.bezel;
import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JPanel;

import src.main.MyPanel;

public class Bezel extends JPanel{

	static public int bezelHeight = (MyPanel.screenHeight)/5;
	static public int bezelWidth = MyPanel.screenWidth;
	
	
	public Bezel() {
		
	}
	

	
	
	public void draw(Graphics2D g2) {
		g2.setColor(Color.BLACK);
		g2.fillRect(0,0,bezelWidth, bezelHeight);
		g2.setColor(Color.GRAY);
		g2.drawLine(0, 0, 0, bezelHeight);
		g2.drawLine(0, 0, bezelWidth, 0);
		g2.drawLine(0, bezelHeight, bezelWidth, bezelHeight);
		g2.drawLine(bezelWidth, 0, bezelWidth, bezelHeight);
	}
}

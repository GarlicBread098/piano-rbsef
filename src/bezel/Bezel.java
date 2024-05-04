package src.bezel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import src.main.MyPanel;

public class Bezel extends JPanel {

	static public int bezelHeight = (MyPanel.screenHeight)/5;
	static public int bezelWidth = MyPanel.screenWidth;
	
	public JSlider octave_left = new JSlider(1,7,4);
	
	
	public Bezel() {
		octave_left.setPreferredSize(new Dimension(200, 100));
        octave_left.setPaintTicks(true);
        octave_left.setPaintTrack(true);
        octave_left.setPaintLabels(true);
        octave_left.setMajorTickSpacing(1);
	}
	
	public String Currentoctave(JSlider s){
		Integer x = s.getValue();
		String currentOctave = x.toString();
		System.out.println(currentOctave);
		return currentOctave;

	}

	public String nextOctave(JSlider s){
		Integer x = s.getValue();
		x = x + 1;
		String nextOctave = x.toString();
		System.out.println(nextOctave);
		return nextOctave;
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

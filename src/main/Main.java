    package src.main;

import java.awt.Container;
import javax.swing.JFrame;



public class Main extends JFrame{

	public Main() {
		setTitle("Piano Pilot"); //name of program
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        Container pane = getContentPane(); //creates the pane the program is in
        MyPanel mp = new MyPanel();
		pane.add(mp); //adds adds myPanel to the pane
		
		pack();
		setVisible(true);
		
		mp.startAppThread();//initiates the run loop
		
	}

	
	public static void main(String[] args) {
		new Main();
		
		
		
	}
}

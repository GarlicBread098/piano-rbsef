package src.main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JPanel;

import src.bezel.Bezel;
import src.bezel.Slider;
import src.piano.MyPiano;
import src.piano.PlayKey;

public class MyPanel extends JPanel implements Runnable {

	Thread appThread = new Thread();

	MyPiano myPiano = new MyPiano();
	Bezel b = new Bezel();
	Slider s1 = new Slider(50,b.bezelHeight/5, 315,45); // creates the first Slider for the first Octave 210-30
	Slider s2 = new Slider(50,b.bezelHeight/5 + 60, 315,45); // creates the second Slider for the second Octave

	PlayKey pk = new PlayKey();
	MouseHandler mh = new MouseHandler(myPiano.bk, myPiano.wk,s1,s2);
	KeyHandler kh = new KeyHandler(pk, s1,s2);
	AnimateString as = new AnimateString();
	ArrayList<String> outputs = new ArrayList<String>();
	

	int FPS = 60;

	public static int screenWidth = 1920;
	public static int screenHeight = 1080;

	public MyPanel() {
		setPreferredSize(new Dimension(screenWidth, screenHeight));
		setFocusable(true);

		add(b);
		add(myPiano);
		addMouseListener(mh);
		addKeyListener(kh);

	}

	public void update(String note, String notes_octaves) {
		
		outputs.add(notes_octaves + "-" + note);
		System.out.println(outputs);

		

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////
	// App loop
	public void startAppThread() {
		appThread = new Thread(this); // this is how you instantiate a thread
		appThread.start(); // automatically calls the run method
	}

	public void run() {// This will contain the main loop which will be the core of its performance
		// Here we are using the sleep method to achieve 60 FPS
		double drawInterval = 1000000000 / FPS;// This is the total time between each frame
		double nextDrawTime = System.nanoTime() + drawInterval;

		while (appThread != null) {
			// 1,000,000,000 nanoseconds is equal to 1 second
			// long currentTime = System.nanoTime();//returns the current value of the
			// running java virtual machines high-resolution time source, in nanoseconds

			update();// updates information
			repaint();// Draws the screen with the updated information

			try {
				double remainingTime = nextDrawTime - System.nanoTime();

				if (remainingTime < 0) {
					remainingTime = 0;
				}
				Thread.sleep((long) remainingTime / 1000000);
				nextDrawTime += drawInterval;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void update() {
		s1.update();
		s2.update();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		myPiano.draw(g2);
		b.draw(g2);
		s1.draw(g2);
		s2.draw(g2);

		try {
			as.draw(g2, outputs, 0, 0, 30, 30);
		} catch (IOException e) {
			System.out.println("bruhbrhubrhrbuhrbuhbruhrbruurbrbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbu");
			e.printStackTrace();
		}
		g2.dispose();// This disposes of this graphics context and release any system resources that
						// it is using.
	}

}

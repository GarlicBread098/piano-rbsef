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
import src.piano.MyPiano;
import src.piano.PlayKey;

public class MyPanel extends JPanel implements Runnable {

	Thread appThread = new Thread();

	MyPiano myPiano = new MyPiano();
	Bezel b = new Bezel();
	PlayKey pk = new PlayKey();
	MouseHandler mh = new MouseHandler(myPiano.bk, myPiano.wk);
	KeyHandler kh = new KeyHandler();
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

	public void update(String note) {
		outputs.add(note);
		System.out.println(outputs);

	}

	/////////////////////////////////////////////////////////////////////////////////////////////////
	class KeyHandler implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) { // checks which key is pressed then updates the values accordingly
			int key = e.getKeyCode(); // registers the key typed
			// white keys
			if (key == KeyEvent.VK_A) {
				try {
					pk.playSound("key09.wav"); // plays sound if certain key is pressed
					update(myPiano.notes[0]); // updates the output arrayList
					myPiano.wk[0].pressed = true; // sets the corresponding key as pressed
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			if (key == KeyEvent.VK_S) {
				try {
					pk.playSound("key10.wav");
					update(myPiano.notes[1]);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					((Throwable) e1).printStackTrace();
				}

			}
			if (key == KeyEvent.VK_D) {
				try {
					pk.playSound("key11.wav");
					update(myPiano.notes[2]);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			if (key == KeyEvent.VK_F) {
				try {
					pk.playSound("key12.wav");
					update(myPiano.notes[3]);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			if (key == KeyEvent.VK_G) {
				try {
					pk.playSound("key13.wav");
					update(myPiano.notes[4]);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			if (key == KeyEvent.VK_J) {
				try {
					pk.playSound("key14.wav");
					update(myPiano.notes[5]);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			if (key == KeyEvent.VK_K) {
				try {
					pk.playSound("key15.wav");
					update(myPiano.notes[6]);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

			// black keys
			if (key == KeyEvent.VK_W) {
				try {
					pk.playSound("key17.wav");
					update(myPiano.sharpNotes[0]);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			if (key == KeyEvent.VK_E) {
				try {
					pk.playSound("key18.wav");
					update(myPiano.sharpNotes[1]);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			if (key == KeyEvent.VK_T) {
				try {
					pk.playSound("key20.wav");
					update(myPiano.sharpNotes[2]);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			if (key == KeyEvent.VK_Y) {
				try {
					pk.playSound("key21.wav");
					update(myPiano.sharpNotes[3]);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			if (key == KeyEvent.VK_U) {
				try {
					pk.playSound("key22.wav");
					update(myPiano.sharpNotes[4]);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		}

		@Override
		public void keyTyped(KeyEvent arg0) {

		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}
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

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		myPiano.draw(g2);
		b.draw(g2);
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

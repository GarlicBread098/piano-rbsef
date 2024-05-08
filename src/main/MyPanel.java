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

	public void update(String note, String notes_octaves) {
		
		outputs.add(notes_octaves + "-" + note);
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
					pk.playSound(s1.octaveToString(), "-c.wav"); // plays sound if certain key is pressed
					//update(b.octave_left.toString() , myPiano.notes[0]); // updates the output arrayList
					myPiano.wk[0].pressed = true; // sets the corresponding key as pressed
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			if (key == KeyEvent.VK_S) {
				try {
					pk.playSound(b.Currentoctave(b.octave_left),"-d.wav");
					//update(b.octave_left.toString(), myPiano.notes[1]);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					((Throwable) e1).printStackTrace();
				}

			}
			if (key == KeyEvent.VK_D) {
				try {
					pk.playSound(b.Currentoctave(b.octave_left),"-e.wav");
					//update(b.octave_left.toString(), myPiano.notes[2]);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			if (key == KeyEvent.VK_F) {
				try {
					pk.playSound(b.Currentoctave(b.octave_left),"-f.wav");
					//update(b.octave_left.toString(), myPiano.notes[3]);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			if (key == KeyEvent.VK_G) {
				try {
					pk.playSound(b.Currentoctave(b.octave_left),"-g.wav");
					//update(b.octave_left.toString(), myPiano.notes[4]);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			if (key == KeyEvent.VK_H) {
				try {
					pk.playSound(b.Currentoctave(b.octave_left),"-a.wav");
					//update(b.octave_left.toString(), myPiano.notes[5]);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			if (key == KeyEvent.VK_J) {
				try {
					pk.playSound(b.Currentoctave(b.octave_left),"-b.wav");
					//update(b.octave_left.toString(), myPiano.notes[6]);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			//// Second octave
			if (key == KeyEvent.VK_V) {
				try {
					//System.out.println(b.Currentoctave(b.octave_left)+1);
					pk.playSound(b.nextOctave(b.octave_right), "-c.wav"); // plays sound if certain key is pressed
					//update(b.octave_right.toString(), myPiano.notes[0]); // updates the output arrayList
					myPiano.wk[0].pressed = true; // sets the corresponding key as pressed
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			if (key == KeyEvent.VK_B) {
				try {
					pk.playSound(b.nextOctave(b.octave_right),"-d.wav");
					//update(b.octave_right.toString(), myPiano.notes[1]);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					((Throwable) e1).printStackTrace();
				}

			}
			if (key == KeyEvent.VK_N) {
				try {
					pk.playSound(b.nextOctave(b.octave_right),"-e.wav");
					//update(b.octave_right.toString(), myPiano.notes[2]);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			if (key == KeyEvent.VK_M) {
				try {
					pk.playSound(b.nextOctave(b.octave_right), "-f.wav");
					//update(b.octave_right.toString(), myPiano.notes[3]);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			if (key == KeyEvent.VK_COMMA) {
				try {
					pk.playSound(b.nextOctave(b.octave_right),"-g.wav");
					//update(b.octave_right.toString(), myPiano.notes[4]);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			if (key == KeyEvent.VK_PERIOD) {
				try {
					pk.playSound(b.nextOctave(b.octave_right),"-a.wav");
					//update(b.octave_right.toString(), myPiano.notes[5]);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			if (key == KeyEvent.VK_SLASH) {
				try {
					pk.playSound(b.nextOctave(b.octave_right),"-b.wav");
					//update(b.octave_right.toString(), myPiano.notes[6]);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

			// black keys
			if (key == KeyEvent.VK_Q) {
				try {
					pk.playSound(b.Currentoctave(b.octave_right),"-cs.wav");
					//update(b.octave_right.toString(), myPiano.sharpNotes[0]);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			if (key == KeyEvent.VK_W) {
				try {
					pk.playSound(b.Currentoctave(b.octave_right),"-ds.wav");
					//update(b.octave_right.toString(), myPiano.sharpNotes[1]);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			if (key == KeyEvent.VK_E) {
				try {
					pk.playSound(b.Currentoctave(b.octave_right),"-fs.wav");
					//update(b.octave_right.toString(), myPiano.sharpNotes[2]);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			if (key == KeyEvent.VK_R) {
				try {
					pk.playSound(b.Currentoctave(b.octave_right),"-gs.wav");
					//update(b.octave_right.toString(), myPiano.sharpNotes[3]);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			if (key == KeyEvent.VK_T) {
				try {
					pk.playSound(b.Currentoctave(b.octave_right),"-as.wav");
					//update(b.octave_right.toString(), myPiano.sharpNotes[4]);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			//second octave 
			if (key == KeyEvent.VK_Y) {
				try {
					pk.playSound(b.nextOctave(b.octave_right),"-cs.wav");
					//update(b.octave_right.toString(), myPiano.sharpNotes[0]);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			if (key == KeyEvent.VK_U) {
				try {
					pk.playSound(b.nextOctave(b.octave_left),"-ds.wav");
					//update(myPiano.sharpNotes[1]);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			if (key == KeyEvent.VK_I) {
				try {
					pk.playSound(b.nextOctave(b.octave_left),"-fs.wav");
					//update(myPiano.sharpNotes[2]);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			if (key == KeyEvent.VK_O) {
				try {
					pk.playSound(b.nextOctave(b.octave_left),"-gs.wav");
					//update(myPiano.sharpNotes[3]);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			if (key == KeyEvent.VK_P) {
				try {
					pk.playSound(b.nextOctave(b.octave_left),"-as.wav");
					//update(myPiano.sharpNotes[4]);
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

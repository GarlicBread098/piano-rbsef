package src.piano;

import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import src.main.MyPanel;

public class MyPiano extends JPanel {
	public final int totalKeys = 88; // total keys for the entire piano
	public final int totalOctaves = 7; // total number of octaves in the piano

	int octaveOnScreen1 = 1; // the first octave on screen
	int octaveOnScreen2 = 2; // the second octave on screen
	int whiteKeysScreen = 17; // number of white keys on screen
	int blackKeysScreen = 10; // number of black keys on screen

	public MyBlackKey[] bk = new MyBlackKey[blackKeysScreen];
	public MyWhiteKey[] wk = new MyWhiteKey[whiteKeysScreen];

	public int pianoWidth = MyPanel.screenWidth; // the piano is the full width of the screen
	public int pianoHeight = (MyPanel.screenHeight * 4) / 5; // the piano height is 4/5ths of the screen

	public String notes[] = { "C", "D", "E", "F", "G", "A", "B" }; // labels for white notes
	public String sharpNotes[] = { "C#", "D#", "F#", "G#", "A#" }; // labels for black notes

	public MyPiano() {

	}

	public void draw(Graphics2D g2) {
		int blackX = (MyWhiteKey.width * 2) / 3;// the starting position of the black key x cordinate in reference to
												// drawing the rectangle, it must be at the two thirds of the way of the
												// white key
		int blackY = (MyPanel.screenHeight) / 5; // the starting position of the black key y cordinate in reference to
													// drawing the rectangle it must be the same as the white key
		int blackWidth = (MyWhiteKey.width * 2) / 3; // 2/3 the width of white key
		int blackHeight = (MyWhiteKey.height * 2) / 3;// 2/3 the height of white key

		for (int i = 0; i < whiteKeysScreen; i++) {
			int x1 = i * MyWhiteKey.width;
			int x2 = (i + 1) * MyWhiteKey.width;
			int y1 = (MyPanel.screenHeight) / 5;
			int y2 = MyPanel.screenHeight;

			wk[i] = new MyWhiteKey(); // creates each individual white key
			wk[i].leftBoundX = x1; // sets the boundaries on the left and right dependent on the x coordinate
			wk[i].rightBoundX = x2;

			g2.setColor(Color.BLACK);

			g2.drawLine(x1, y1, x2, y1);// top horizontal
			g2.drawLine(x1, y2, x2, y2);// bottom horizontal
			g2.drawLine(x1, y1, x1, y2);// left vertical
			g2.drawLine(x2, y1, x2, y2);// right vertical

			/*
			 * if (wk[i].pressed == true) {
			 * g2.setColor(Color.BLUE);
			 * System.out.println("hey");
			 * g2.drawLine(x1, y1, x2, y1);// top horizontal
			 * g2.drawLine(x1, y2, x2, y2);// bottom horizontal
			 * g2.drawLine(x1, y1, x1, y2);// left vertical
			 * g2.drawLine(x2, y1, x2, y2);// right vertical
			 * }
			 */

		}

		for (int i = 0; i < blackKeysScreen; i++) {

			// g2.setColor(Color.BLACK);
			if (i == 0 || i == 1 || i == 5 || i == 6) {
				g2.fillRect(blackX, blackY, blackWidth, blackHeight);
				bk[i] = new MyBlackKey();
				bk[i].leftBoundX = blackX; // sets the x boundary on the left
				bk[i].rightBoundX = blackX + MyBlackKey.width; // sets the y boundary on the right

				if (i == 1 || i == 6) {
					blackX += MyWhiteKey.width * 2;
				} else if (i == 0 || i == 5) {
					blackX += MyWhiteKey.width;
				}

			} else if (i == 2 || i == 3 || i == 4 || i == 7 || i == 8 || i == 9) {
				g2.fillRect(blackX, blackY, blackWidth, blackHeight);
				bk[i] = new MyBlackKey();
				bk[i].leftBoundX = blackX; // sets the x boundary on the left
				bk[i].rightBoundX = blackX + MyBlackKey.width; // sets the y boundary on the right

				if (i == 4 || i == 9) {
					blackX += MyWhiteKey.width * 2;
				} else {
					blackX += MyWhiteKey.width;
				}
			}
		}
	}

}

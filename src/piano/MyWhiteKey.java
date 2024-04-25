package src.piano;

import src.main.MyPanel;

public class MyWhiteKey {
	public int leftBoundX;
	public int rightBoundX;
	static int width = (MyPanel.screenWidth) / 14; // width of each white key
	static int height = (MyPanel.screenHeight * 4) / 5; // height of each key

	public boolean pressed = false;

	int octave;

	String note;

	public MyWhiteKey() {

	}
}

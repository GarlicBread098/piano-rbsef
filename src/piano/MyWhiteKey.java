package src.piano;

import src.main.MyPanel;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MyWhiteKey {
	public int leftBoundX;
	public int rightBoundX;
	static int width = (MyPanel.screenWidth) / 14; // width of each white key
	static int height = (MyPanel.screenHeight * 4) / 5; // height of each key

	BufferedImage defaultImage, pressedImage;

	public boolean pressed = false;

	int octave;

	String note;

	public MyWhiteKey() throws IOException {
		defaultImage = ImageIO.read(getClass().getResourceAsStream("/Images/whitekey0.jpg"));
		pressedImage = ImageIO.read(getClass().getResourceAsStream("/Images/whitekey1.jpg"));
	}

	public void draw(Graphics g2,int x, int y, int width, int height) {
		g2.drawImage(defaultImage, x, y, width, height, null);
		

	}
}

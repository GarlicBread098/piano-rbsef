package src.piano;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MyBlackKey {
    public int leftBoundX;
    public int rightBoundX;
    static int width = (MyWhiteKey.width * 2)/3; // width of each black key
	public static int height = (MyWhiteKey.height * 2)/3; // height of each black key
    
    BufferedImage defaultImage, pressedImage;
    //public boolean pressed = false; 
	int octave;
	String note;

    public MyBlackKey() throws IOException{
        defaultImage = ImageIO.read(getClass().getResourceAsStream("/Images/blackkey0.jpg"));
        pressedImage = ImageIO.read(getClass().getResourceAsStream("/Images/blackkey1.jpg"));
    }

    public void draw(java.awt.Graphics g2, int x, int y, int width, int height) {
        g2.drawImage(defaultImage, x, y, width, height, null);
    }

}

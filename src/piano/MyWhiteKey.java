package src.piano;

import src.main.KeyHandler;
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

	int keyNumber;
	KeyHandler kh;

	public boolean pressed = false;

	int octave;

	String note;

	public MyWhiteKey(int i, KeyHandler kh) throws IOException {
		keyNumber = i;
		defaultImage = ImageIO.read(getClass().getResourceAsStream("/Images/whitekey0.jpg"));
		pressedImage = ImageIO.read(getClass().getResourceAsStream("/Images/whitekey1.jpg"));

		this.kh = kh;
	}

	public void draw(Graphics g2,int x, int y, int width, int height) {
		BufferedImage image = setImage();
		g2.drawImage(image, x, y, width, height, null);
		

	}

	public BufferedImage setImage(){
		if(kh.sliderChanged(kh.s1)){
            kh.setPianoKeysPressed(kh.s1);
        }
        if(kh.sliderChanged(kh.s2)){
            kh.setPianoKeysPressed(kh.s2);
        }
		if(keyNumber == 0){
			if(kh.keyStillPlaying1.isEmpty()){
				return defaultImage;
			}
			else{
				if(kh.keyStillPlaying1.get(kh.s1.octaveToString() + "-c.wav")){
					return pressedImage;
				}
				else{
					return defaultImage;
				}
			}
		}

		if(keyNumber == 1){
			if(kh.keyStillPlaying1.isEmpty()){
				return defaultImage;
			}
			else{
				if(kh.keyStillPlaying1.get(kh.s1.octaveToString() + "-d.wav")){
					return pressedImage;
				}
				else{
					return defaultImage;
				}
			}
		}

		if(keyNumber == 2){
			if(kh.keyStillPlaying1.isEmpty()){
				return defaultImage;
			}
			else{
				if(kh.keyStillPlaying1.get(kh.s1.octaveToString() + "-e.wav")){
					return pressedImage;
				}
				else{
					return defaultImage;
				}
			}
		}

		if(keyNumber == 3){
			if(kh.keyStillPlaying1.isEmpty()){
				return defaultImage;
			}
			else{
				if(kh.keyStillPlaying1.get(kh.s1.octaveToString() + "-f.wav")){
					return pressedImage;
				}
				else{
					return defaultImage;
				}
			}
		}

		if(keyNumber == 4){
			if(kh.keyStillPlaying1.isEmpty()){
				return defaultImage;
			}
			else{
				if(kh.keyStillPlaying1.get(kh.s1.octaveToString() + "-g.wav")){
					return pressedImage;
				}
				else{
					return defaultImage;
				}
			}
		}

		if(keyNumber == 5){
			if(kh.keyStillPlaying1.isEmpty()){
				return defaultImage;
			}
			else{
				if(kh.keyStillPlaying1.get(kh.s1.octaveToString() + "-a.wav")){
					return pressedImage;
				}
				else{
					return defaultImage;
				}
			}
		}

		if(keyNumber == 6){
			if(kh.keyStillPlaying1.isEmpty()){
				return defaultImage;
			}
			else{
				if(kh.keyStillPlaying1.get(kh.s1.octaveToString() + "-b.wav")){
					return pressedImage;
				}
				else{
					return defaultImage;
				}
			}
		}

		if(keyNumber == 7){
			if(kh.keyStillPlaying2.isEmpty()){
				return defaultImage;
			}
			else{
				if(kh.keyStillPlaying2.get(kh.s2.octaveToString() + "-c.wav")){
					return pressedImage;
				}
				else{
					return defaultImage;
				}
			}
		}

		if(keyNumber == 8){
			if(kh.keyStillPlaying2.isEmpty()){
				return defaultImage;
			}
			else{
				if(kh.keyStillPlaying2.get(kh.s2.octaveToString() + "-d.wav")){
					return pressedImage;
				}
				else{
					return defaultImage;
				}
			}
		}

		if(keyNumber == 9){
			if(kh.keyStillPlaying2.isEmpty()){
				return defaultImage;
			}
			else{
				if(kh.keyStillPlaying2.get(kh.s2.octaveToString() + "-e.wav")){
					return pressedImage;
				}
				else{
					return defaultImage;
				}
			}
		}

		if(keyNumber == 10){
			if(kh.keyStillPlaying2.isEmpty()){
				return defaultImage;
			}
			else{
				if(kh.keyStillPlaying2.get(kh.s2.octaveToString() + "-f.wav")){
					return pressedImage;
				}
				else{
					return defaultImage;
				}
			}
		}

		if(keyNumber == 11){
			if(kh.keyStillPlaying2.isEmpty()){
				return defaultImage;
			}
			else{
				if(kh.keyStillPlaying2.get(kh.s2.octaveToString() + "-g.wav")){
					return pressedImage;
				}
				else{
					return defaultImage;
				}
			}
		}

		if(keyNumber == 12){
			if(kh.keyStillPlaying2.isEmpty()){
				return defaultImage;
			}
			else{
				if(kh.keyStillPlaying2.get(kh.s2.octaveToString() + "-a.wav")){
					return pressedImage;
				}
				else{
					return defaultImage;
				}
			}
		}

		if(keyNumber == 13){
			if(kh.keyStillPlaying2.isEmpty()){
				return defaultImage;
			}
			else{
				if(kh.keyStillPlaying2.get(kh.s2.octaveToString() + "-b.wav")){
					return pressedImage;
				}
				else{
					return defaultImage;
				}
			}
		}


		return defaultImage;
	}
}

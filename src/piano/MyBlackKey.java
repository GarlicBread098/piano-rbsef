package src.piano;

import java.awt.RenderingHints.Key;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import src.main.KeyHandler;

public class MyBlackKey {
    public int leftBoundX;
    public int rightBoundX;
    static int width = (MyWhiteKey.width * 2)/3; // width of each black key
	public static int height = (MyWhiteKey.height * 2)/3; // height of each black key
    
    BufferedImage defaultImage, pressedImage;
    //public boolean pressed = false; 
	int octave;
	String note;

    int keyNumber;
    KeyHandler kh;

    public MyBlackKey(int i, KeyHandler kh) throws IOException{
        keyNumber = i;
        defaultImage = ImageIO.read(getClass().getResourceAsStream("/Images/blackkey0.jpg"));
        pressedImage = ImageIO.read(getClass().getResourceAsStream("/Images/blackkey1.jpg"));
        this.kh = kh;

    }

    public void draw(java.awt.Graphics g2, int x, int y, int width, int height) {
        BufferedImage image = setImage();
        g2.drawImage(image, x, y, width, height, null);
    }

    public BufferedImage setImage(){
        if(keyNumber == 0){
            if(kh.keyStillPlaying1.isEmpty()){
                return defaultImage;
            }
            else{
                if(kh.keyStillPlaying1.get(kh.s1.octaveToString() + "-cs.wav")){
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
                if(kh.keyStillPlaying1.get(kh.s1.octaveToString() + "-ds.wav")){
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
                if(kh.keyStillPlaying1.get(kh.s1.octaveToString() + "-fs.wav")){
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
                if(kh.keyStillPlaying1.get(kh.s1.octaveToString() + "-gs.wav")){
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
                if(kh.keyStillPlaying1.get(kh.s1.octaveToString() + "-as.wav")){
                    return pressedImage;
                }
                else{
                    return defaultImage;
                }
            }
        }

        if(keyNumber == 5){
            if(kh.keyStillPlaying2.isEmpty()){
                return defaultImage;
            }
            else{
                if(kh.keyStillPlaying2.get(kh.s2.octaveToString() + "-cs.wav")){
                    return pressedImage;
                }
                else{
                    return defaultImage;
                }
            }
        }

        if(keyNumber == 6){
            if(kh.keyStillPlaying2.isEmpty()){
                return defaultImage;
            }
            else{
                if(kh.keyStillPlaying2.get(kh.s2.octaveToString() + "-ds.wav")){
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
                if(kh.keyStillPlaying2.get(kh.s2.octaveToString() + "-fs.wav")){
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
                if(kh.keyStillPlaying2.get(kh.s2.octaveToString() + "-gs.wav")){
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
                if(kh.keyStillPlaying2.get(kh.s2.octaveToString() + "-as.wav")){
                    return pressedImage;
                }
                else{
                    return defaultImage;
                }
            }
        }
        return null;
    }

}

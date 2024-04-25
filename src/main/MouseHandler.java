package src.main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import src.bezel.Bezel;
import src.piano.MyBlackKey;
import src.piano.MyWhiteKey;
import src.piano.PlayKey;

public class MouseHandler implements MouseListener {
    boolean mousePressed = false;
    PlayKey pk = new PlayKey();
    MyBlackKey[] bk;
    MyWhiteKey[] wk;

    public MouseHandler(MyBlackKey[] bk, MyWhiteKey[] wk){
        this.bk = bk;
        this.wk = wk;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        boolean withinBlackKeyX = ((bk[0].leftBoundX < x && x < bk[0].rightBoundX) || (bk[1].leftBoundX < x && x < bk[1].rightBoundX) || (bk[2].leftBoundX < x && x < bk[2].rightBoundX) || (bk[3].leftBoundX < x && x < bk[3].rightBoundX) || (bk[4].leftBoundX < x && x < bk[4].rightBoundX));

        if(y <= Bezel.bezelHeight){ // checks if the y coordinate is within the bezel 

        }
        else{ // this will run if the y coordinate is within the piano
           if((y < (Bezel.bezelHeight + MyBlackKey.height)) && withinBlackKeyX){  // checks if the y coordinate is within the black key area
                if(bk[0].leftBoundX < x && x < bk[0].rightBoundX){ // checks if the x coordinate is within c sharp
                    try {
                        pk.playSound("key17.wav");
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                else if(bk[1].leftBoundX < x && x < bk[1].rightBoundX){
                    try {
                        pk.playSound("key18.wav");
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                else if(bk[2].leftBoundX < x && x < bk[2].rightBoundX){
                    try {
                        pk.playSound("key20.wav");
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                else if(bk[3].leftBoundX < x && x < bk[3].rightBoundX){
                    try {
                        pk.playSound("key21.wav");
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                else if(bk[4].leftBoundX < x && x < bk[4].rightBoundX){
                    try {
                        pk.playSound("key22.wav");
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                /*Save this for when I have the rest of the files ready 
                else if(bk[].leftBoundX < x && x < bk[].rightBoundX){
                    pk.playSound();
                }
                else if(bk[].leftBoundX < x && x < bk[].rightBoundX){
                    pk.playSound();
                }
                else if(bk[].leftBoundX < x && x < bk[].rightBoundX){
                    pk.playSound();
                }
                else if(bk[].leftBoundX < x && x < bk[].rightBoundX){
                    pk.playSound();
                }
                else if(bk[].leftBoundX < x && x < bk[].rightBoundX){
                    pk.playSound();
                }
                */
                
            }
            else{
                //First octave of white keys
                if(wk[0].leftBoundX < x && x < wk[0].rightBoundX){
                    try {
                        pk.playSound("key09.wav");
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                else if(wk[1].leftBoundX < x && x < wk[1].rightBoundX){
                    try {
                        pk.playSound("key10.wav");
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                else if(wk[2].leftBoundX < x && x < wk[2].rightBoundX){
                    try {
                        pk.playSound("key11.wav");
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                else if(wk[3].leftBoundX < x && x < wk[3].rightBoundX){
                    try {
                        pk.playSound("key12.wav");
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                else if(wk[4].leftBoundX < x && x < wk[4].rightBoundX){
                    try {
                        pk.playSound("key13.wav");
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                else if(wk[5].leftBoundX < x && x < wk[5].rightBoundX){
                    try {
                        pk.playSound("key14.wav");
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                else if(wk[6].leftBoundX < x && x < wk[6].rightBoundX){
                    try {
                        pk.playSound("key15.wav");
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                //second octave of white keys
                /* 
                else if(wk[].leftBoundX < x && x < wk[].rightBoundX){
                    pk.playSound("");
                }
                else if(wk[].leftBoundX < x && x < wk[].rightBoundX){
                    pk.playSound("");
                }
                else if(wk[].leftBoundX < x && x < wk[].rightBoundX){
                    pk.playSound("");
                }
                else if(wk[].leftBoundX < x && x < wk[].rightBoundX){
                    pk.playSound("");
                }
                else if(wk[].leftBoundX < x && x < wk[].rightBoundX){
                    pk.playSound("");
                }
                else if(wk[].leftBoundX < x && x < wk[].rightBoundX){
                    pk.playSound("");
                }
                else if(wk[].leftBoundX < x && x < wk[].rightBoundX){
                    pk.playSound("");
                }
                */

           }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
       
    }

    /* 
    public void itClicked(MouseEvent e){
        int x = e.getX();
        int y = e.getY();

        if(y <= Bezel.bezelHeight){

        }
        else{
            if()
        }




    }
    */
    
}

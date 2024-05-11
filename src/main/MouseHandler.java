package src.main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import src.bezel.Bezel;
import src.bezel.Slider;
import src.piano.MyBlackKey;
import src.piano.MyWhiteKey;
import src.piano.PlayKey;

public class MouseHandler implements MouseListener {
    boolean mousePressed = false;
    PlayKey pk = new PlayKey();
    Bezel b = new Bezel();

    MyBlackKey[] bk;
    MyWhiteKey[] wk;

    Slider s1, s2;

    public MouseHandler(MyBlackKey[] bk, MyWhiteKey[] wk, Slider s1, Slider s2){
        this.bk = bk;
        this.wk = wk;
        this.s1 = s1;
        this.s2 = s2;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //work out a method to check if it was clicked within the notches to change the octave
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        boolean withinBlackKeyX = ((bk[0].leftBoundX < x && x < bk[0].rightBoundX) || (bk[1].leftBoundX < x && x < bk[1].rightBoundX) || (bk[2].leftBoundX < x && x < bk[2].rightBoundX) || (bk[3].leftBoundX < x && x < bk[3].rightBoundX) || (bk[4].leftBoundX < x && x < bk[4].rightBoundX));
        boolean withinBlackKeyX2 = ((bk[5].leftBoundX < x && x < bk[5].rightBoundX) || (bk[6].leftBoundX < x && x < bk[6].rightBoundX) || (bk[7].leftBoundX < x && x < bk[7].rightBoundX) || (bk[8].leftBoundX < x && x < bk[8].rightBoundX) || (bk[9].leftBoundX < x && x < bk[9].rightBoundX));
        

        if(y <= Bezel.bezelHeight){ // checks if the y coordinate is within the bezel 
            checkIfSliderPressed(s1, x, y);
            checkIfSliderPressed(s2, x, y);

        }
        else{ // this will run if the y coordinate is within the piano
           if((y < (Bezel.bezelHeight + MyBlackKey.height)) && (withinBlackKeyX || withinBlackKeyX2)){  // checks if the y coordinate is within the black key area
                if(bk[0].leftBoundX < x && x < bk[0].rightBoundX){ // checks if the x coordinate is within c sharp
                    try {
                        pk.playSound(s1.octaveToString(),"-cs.wav",s1);
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                else if(bk[1].leftBoundX < x && x < bk[1].rightBoundX){
                    try {
                        pk.playSound(s1.octaveToString(),"-ds.wav",s1);
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                else if(bk[2].leftBoundX < x && x < bk[2].rightBoundX){
                    try {
                        pk.playSound(s1.octaveToString(),"-fs.wav",s1);
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                else if(bk[3].leftBoundX < x && x < bk[3].rightBoundX){
                    try {
                        pk.playSound(s1.octaveToString(),"-gs.wav",s1);
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                else if(bk[4].leftBoundX < x && x < bk[4].rightBoundX){
                    try {
                        pk.playSound(s1.octaveToString(),"-as.wav",s1);
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                //second octave of black keys
                else if(bk[5].leftBoundX < x && x < bk[5].rightBoundX){
                    try {
                        pk.playSound(s2.octaveToString(),"-cs.wav",s2);
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                else if(bk[6].leftBoundX < x && x < bk[6].rightBoundX){
                    try {
                        pk.playSound(s2.octaveToString(),"-ds.wav",s2);
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                else if(bk[7].leftBoundX < x && x < bk[7].rightBoundX){
                    try {
                        pk.playSound(s2.octaveToString(),"-fs.wav",s2);
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                else if(bk[8].leftBoundX < x && x < bk[8].rightBoundX){
                    try {
                        pk.playSound(s2.octaveToString(),"-gs.wav",s2);
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                else if(bk[9].leftBoundX < x && x < bk[9].rightBoundX){
                    try {
                        pk.playSound(s2.octaveToString(),"-as.wav",s2);
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                
                
            }
            else{
                //First octave of white keys
                if(wk[0].leftBoundX < x && x < wk[0].rightBoundX){
                    try {
                        pk.playSound(s1.octaveToString(), "-c.wav",s1);
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                else if(wk[1].leftBoundX < x && x < wk[1].rightBoundX){
                    try {
                        pk.playSound(s1.octaveToString(),"-d.wav",s1);
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                else if(wk[2].leftBoundX < x && x < wk[2].rightBoundX){
                    try {
                        pk.playSound(s1.octaveToString(),"-e.wav",s1);
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                else if(wk[3].leftBoundX < x && x < wk[3].rightBoundX){
                    try {
                        pk.playSound(s1.octaveToString(),"-f.wav",s1);
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                else if(wk[4].leftBoundX < x && x < wk[4].rightBoundX){
                    try {
                        pk.playSound(s1.octaveToString(),"-g.wav",s1);
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                else if(wk[5].leftBoundX < x && x < wk[5].rightBoundX){
                    try {
                        pk.playSound(s1.octaveToString(),"-a.wav",s1);
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                else if(wk[6].leftBoundX < x && x < wk[6].rightBoundX){
                    try {
                        pk.playSound(s1.octaveToString(),"-b.wav",s1);
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                //second octave of white keys
                
                else if(wk[7].leftBoundX < x && x < wk[7].rightBoundX){
                    try {
                        pk.playSound(s2.octaveToString(),"-c.wav",s2);
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                else if(wk[8].leftBoundX < x && x < wk[8].rightBoundX){
                    try {
                        pk.playSound(s2.octaveToString(),"-d.wav",  s2);
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    } 
                }
                else if(wk[9].leftBoundX < x && x < wk[9].rightBoundX){
                    try {
                        pk.playSound(s2.octaveToString(),"-e.wav", s2);
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                else if(wk[10].leftBoundX < x && x < wk[10].rightBoundX){
                    try {
                        pk.playSound(s2.octaveToString(),"-f.wav", s2);
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                else if(wk[11].leftBoundX < x && x < wk[11].rightBoundX){
                    try {
                        pk.playSound(s2.octaveToString(),"-g.wav", s2);
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                else if(wk[12].leftBoundX < x && x < wk[12].rightBoundX){
                    try {
                        pk.playSound(s2.octaveToString(),"-a.wav", s2);
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                else if(wk[13].leftBoundX < x && x < wk[13].rightBoundX){
                    try {
                        pk.playSound(s2.octaveToString(),"-b.wav", s2);
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {

                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                

           }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int x = e.getX();
        setSliderOnRelease(s1, x);
        setSliderOnRelease(s2, x);
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        int x = e.getX();
        //moveSlider(s1,x);
        //moveSlider(s2,x);
    }

    @Override
    public void mouseExited(MouseEvent e) {
       
    }

    public void checkIfSliderPressed(Slider s, int x, int y){
        if(y > s.y && y < (s.y + s.height))// checks if the mouse clicked in between the height of the slider
        {
            if(x > s.sliderX && x < (s.sliderX + s.sliderWidth))// checks if the mouse clicked in between the width of the slider
            {
                s.sliderPressed = true; // sets the slider to be pressed
            }
        }
    }

    

    public void setSliderOnRelease(Slider s, int x){
        if(s.sliderPressed){ // checks if the slider is pressed
            s.sliderPressed = false;// sets the slider to not be pressed
            

            if(x < s.x){
                s.octave = 1;
            }
            else if(x > s.x + s.width){
                s.octave = 7;
            }
            else if((x > s.x) && ( x < (s.x + (s.width/16)*3))){
                s.octave = 1;
            }
            else if((x > (s.x + (s.width/16)*3)) && ( x < (s.x + (s.width/16)*5))){
                s.octave = 2;
            }
            else if((x > (s.x + (s.width/16)*5)) && ( x < (s.x + (s.width/16)*7))){
                s.octave = 3;
            }
            else if((x > (s.x + (s.width/16)*7)) && ( x < (s.x + (s.width/16)*9))){
                s.octave = 4;
            }
            else if((x > (s.x + (s.width/16)*9)) && ( x < (s.x + (s.width/16)*11))){
                s.octave = 5;
            }
            else if((x > (s.x + (s.width/16)*11)) && ( x < (s.x + (s.width/16)*13))){
                s.octave = 6;
            }
            else if((x > (s.x + (s.width/16)*13)) && ( x < (s.x + (s.width/16)*16))){
                s.octave = 7;
            }

            

       }
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

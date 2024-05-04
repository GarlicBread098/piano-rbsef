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
    Bezel b = new Bezel();
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
        boolean withinBlackKeyX2 = ((bk[5].leftBoundX < x && x < bk[5].rightBoundX) || (bk[6].leftBoundX < x && x < bk[6].rightBoundX) || (bk[7].leftBoundX < x && x < bk[7].rightBoundX) || (bk[8].leftBoundX < x && x < bk[8].rightBoundX) || (bk[9].leftBoundX < x && x < bk[9].rightBoundX));
        

        if(y <= Bezel.bezelHeight){ // checks if the y coordinate is within the bezel 

        }
        else{ // this will run if the y coordinate is within the piano
           if((y < (Bezel.bezelHeight + MyBlackKey.height)) && (withinBlackKeyX || withinBlackKeyX2)){  // checks if the y coordinate is within the black key area
                if(bk[0].leftBoundX < x && x < bk[0].rightBoundX){ // checks if the x coordinate is within c sharp
                    try {
                        pk.playSound(b.Currentoctave(b.octave_left),"-cs.wav");
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                else if(bk[1].leftBoundX < x && x < bk[1].rightBoundX){
                    try {
                        pk.playSound(b.Currentoctave(b.octave_left),"-ds.wav");
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                else if(bk[2].leftBoundX < x && x < bk[2].rightBoundX){
                    try {
                        pk.playSound(b.Currentoctave(b.octave_left),"-fs.wav");
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                else if(bk[3].leftBoundX < x && x < bk[3].rightBoundX){
                    try {
                        pk.playSound(b.Currentoctave(b.octave_left),"-gs.wav");
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                else if(bk[4].leftBoundX < x && x < bk[4].rightBoundX){
                    try {
                        pk.playSound(b.Currentoctave(b.octave_left),"-as.wav");
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                //second octave of black keys
                else if(bk[5].leftBoundX < x && x < bk[5].rightBoundX){
                    try {
                        pk.playSound(b.nextOctave(b.octave_left),"-cs.wav");
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                else if(bk[6].leftBoundX < x && x < bk[6].rightBoundX){
                    try {
                        pk.playSound(b.nextOctave(b.octave_left),"-ds.wav");
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                else if(bk[7].leftBoundX < x && x < bk[7].rightBoundX){
                    try {
                        pk.playSound(b.nextOctave(b.octave_left),"-fs.wav");
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                else if(bk[8].leftBoundX < x && x < bk[8].rightBoundX){
                    try {
                        pk.playSound(b.nextOctave(b.octave_left),"-gs.wav");
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                else if(bk[9].leftBoundX < x && x < bk[9].rightBoundX){
                    try {
                        pk.playSound(b.nextOctave(b.octave_left),"-as.wav");
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
                        pk.playSound(b.Currentoctave(b.octave_left), "-c.wav");
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                else if(wk[1].leftBoundX < x && x < wk[1].rightBoundX){
                    try {
                        pk.playSound(b.Currentoctave(b.octave_left),"-d.wav");
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                else if(wk[2].leftBoundX < x && x < wk[2].rightBoundX){
                    try {
                        pk.playSound(b.Currentoctave(b.octave_left),"-e.wav");
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                else if(wk[3].leftBoundX < x && x < wk[3].rightBoundX){
                    try {
                        pk.playSound(b.Currentoctave(b.octave_left),"-f.wav");
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                else if(wk[4].leftBoundX < x && x < wk[4].rightBoundX){
                    try {
                        pk.playSound(b.Currentoctave(b.octave_left),"-g.wav");
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                else if(wk[5].leftBoundX < x && x < wk[5].rightBoundX){
                    try {
                        pk.playSound(b.Currentoctave(b.octave_left),"-a.wav");
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                else if(wk[6].leftBoundX < x && x < wk[6].rightBoundX){
                    try {
                        pk.playSound(b.Currentoctave(b.octave_left),"-b.wav");
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                //second octave of white keys
                
                else if(wk[7].leftBoundX < x && x < wk[7].rightBoundX){
                    try {
                        pk.playSound(b.nextOctave(b.octave_left),"-c.wav");
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                else if(wk[8].leftBoundX < x && x < wk[8].rightBoundX){
                    try {
                        pk.playSound(b.nextOctave(b.octave_left),"-d.wav");
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    } 
                }
                else if(wk[9].leftBoundX < x && x < wk[9].rightBoundX){
                    try {
                        pk.playSound(b.nextOctave(b.octave_left),"-e.wav");
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                else if(wk[10].leftBoundX < x && x < wk[10].rightBoundX){
                    try {
                        pk.playSound(b.nextOctave(b.octave_left),"-f.wav");
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                else if(wk[11].leftBoundX < x && x < wk[11].rightBoundX){
                    try {
                        pk.playSound(b.nextOctave(b.octave_left),"-g.wav");
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                else if(wk[12].leftBoundX < x && x < wk[12].rightBoundX){
                    try {
                        pk.playSound(b.nextOctave(b.octave_left),"-a.wav");
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                else if(wk[13].leftBoundX < x && x < wk[13].rightBoundX){
                    try {
                        pk.playSound(b.nextOctave(b.octave_left),"-b.wav");
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

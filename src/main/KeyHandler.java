package src.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import src.bezel.Slider;
import src.piano.PlayKey;

public class KeyHandler implements KeyListener {
    //     <Keystroke, Key   >
    HashMap<Character, String> controlsOctave1, controlsOctave2;
    //     <Key,    true/false>
    HashMap<String, Boolean> keysPressed1, keysPressed2; 
    PlayKey pk;
    Slider s1, s2;

    public KeyHandler(PlayKey pk, Slider s1, Slider s2) {
        this.pk = pk;
        this.s1 = s1;
        this.s2 = s2;
        controlsOctave1 = new HashMap<>();
        controlsOctave2 = new HashMap<>();
        keysPressed1 = new HashMap<>();
        keysPressed2 = new HashMap<>();
        setDefaultControls();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        //aathrow new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }


    @Override
    public void keyPressed(KeyEvent e) {
        try {
            checkIfPlayPianoKey(e,s1);
            checkIfPlayPianoKey(e,s2);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        //throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        stopPlayingKey(e,s1);
        stopPlayingKey(e,s2);
        //throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }


    public void setDefaultControls(){ //sets the default controls
        
        //setting up the controls for the First octave of white keys
        controlsOctave1.put('a', "c");
        controlsOctave1.put('s',"d");
        controlsOctave1.put('d',"e");
        controlsOctave1.put('f',"f");
        controlsOctave1.put('g',"g");
        controlsOctave1.put('h',"a");
        controlsOctave1.put('j',"b");
        // setting up the controls for the first octave of black keys
        controlsOctave1.put('q', "cs");
        controlsOctave1.put('w', "ds");
        controlsOctave1.put('e', "fs");
        controlsOctave1.put('r', "gs");
        controlsOctave1.put('t', "as");

        //setting up the controls for the second octave of white keys
        controlsOctave2.put('v', "c");
        controlsOctave2.put('b',"d");
        controlsOctave2.put('n',"e");
        controlsOctave2.put('m',"f");
        controlsOctave2.put(',',"g");
        controlsOctave2.put('.',"a");
        controlsOctave2.put('/',"b");
        // setting up the controls for the second octave of black keys
        controlsOctave2.put('y', "cs");
        controlsOctave2.put('u', "ds");
        controlsOctave2.put('i', "fs");
        controlsOctave2.put('o', "gs");
        controlsOctave2.put('p', "as");
    }

    public void setPianoKeysPressed(){//sets all the keys pressed to false
        for(String key : controlsOctave1.values()){
            keysPressed1.put(key, false);
        }
        for(String key : controlsOctave2.values()){
            keysPressed2.put(key, false);
        }
    }


    public void stopPlayingKey(KeyEvent key, Slider s){//updates the keys pressed given if the respective keybind is released
        char keyChar = key.getKeyChar();
        if(s.currentSliderNumber == 1){
            //keysPressed1.put(controlsOctave1.get(keyChar), false);
            pk.stopSound(s.octaveToString(), "-" + controlsOctave1.get(keyChar) + ".wav",s);
            //System.out.println(keysPressed1.get(controlsOctave1.get(keyChar)));
        }
        else if(s.currentSliderNumber == 2){
            //keysPressed2.put(controlsOctave2.get(keyChar), false);
            System.out.println("bruh");
            pk.stopSound(s.octaveToString(), "-" + controlsOctave2.get(keyChar) + ".wav",s);
        }
    }


    public void checkIfPlayPianoKey(KeyEvent key,Slider s) throws FileNotFoundException, UnsupportedAudioFileException, IOException, LineUnavailableException{//plays the piano key if the key pressed is a piano key
        char keyChar = key.getKeyChar();
        String path = "";
        
        if(s.currentSliderNumber == 1){
            path = "-" + controlsOctave1.get(keyChar) + ".wav";
            keysPressed1.put(controlsOctave1.get(keyChar), true);//sets the key pressed to true
        }
        else if(s.currentSliderNumber == 2){
            path = "-" + controlsOctave2.get(keyChar) + ".wav";
            keysPressed2.put(controlsOctave2.get(keyChar), true);//sets the key pressed to true
        }
        
       
        pk.playSound(s.octaveToString(), path,s);//plays the sound
    }
}
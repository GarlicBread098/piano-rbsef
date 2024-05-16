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
    //     <Keypath,    true/false>
    HashMap<String, Boolean> keyStillPlaying1, keyStillPlaying2; 
    //      <keypath, Timer>
    HashMap<String, Timer> keyTimers1, keyTimers2;
    //    <Keypath,    true/false>
    HashMap<String, Boolean> keyBeingPressed1, keyBeingPressed2;
    PlayKey pk;
    Slider s1, s2;

    public KeyHandler(PlayKey pk, Slider s1, Slider s2) {
        this.pk = pk;
        this.s1 = s1;
        this.s2 = s2;
        controlsOctave1 = new HashMap<>();
        controlsOctave2 = new HashMap<>();
        setDefaultControls();
        keyStillPlaying1 = new HashMap<>();
        keyStillPlaying2 = new HashMap<>();
        keyBeingPressed1 = new HashMap<>();
        keyBeingPressed2 = new HashMap<>();
        setPianoKeysPressed();
        keyTimers1 = new HashMap<>();
        keyTimers2 = new HashMap<>();
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        //aathrow new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }


    @Override
    public void keyPressed(KeyEvent e) {
        try {
            if(controlsOctave1.containsKey(e.getKeyChar())){
                playPianoKey(e,s1);
            }
            else if(controlsOctave2.containsKey(e.getKeyChar())){
                playPianoKey(e,s2);
            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        //throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Character keyChar = e.getKeyChar();
        try {
            if(controlsOctave1.containsKey(e.getKeyChar())){
                stopPlayingKey(keyChar,s1);
            }
            else if(controlsOctave2.containsKey(e.getKeyChar())){
                stopPlayingKey(keyChar,s2);
            }
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
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
            String path = ""+s1.octaveToString() + "-" + key + ".wav";
            keyStillPlaying1.put(path, false);
            keyBeingPressed1.put(path, false);
            
        }
        for(String key : controlsOctave2.values()){
            String path = ""+s2.octaveToString() + "-" + key + ".wav";
            keyStillPlaying2.put(path, false);
            keyBeingPressed2.put(path, false);
        }
    }

                //             [key(ex: "a"), slider(s1)] The string needs to be the keyboard input not notes
    public void stopPlayingKey(Character key , Slider s) throws InterruptedException{//updates the keys pressed given if the respective keybind is released
        String path = ""+s.octaveToString();


        if(s.currentSliderNumber == 1){
            path += "-" + controlsOctave1.get(key) + ".wav";
            keyBeingPressed1.put(path, false);//States that the key is no longer being pressed
            if(keyTimers1.get(path).getTime() > 1000){//checks if the key was pressed for less than a second
                pk.stopSound(path,s);
            }
            path = ""+s.octaveToString();
        }
        else if(s.currentSliderNumber == 2){
            path += "-" + controlsOctave2.get(key) + ".wav";
            keyBeingPressed2.put(path, false);//States that the key is no longer being pressed
            if(keyTimers2.get(path).getTime() > 1000){//checks if the key was pressed for less than a second
                pk.stopSound(path,s);
            }
        }
    }

    public void stopPlayingKey(String path, Slider s) throws InterruptedException{//updates the keys pressed given if the respective keybind is released

        if(s.currentSliderNumber == 1){
            keyBeingPressed1.put(path, false);//States that the key is no longer being pressed
            if(keyTimers1.get(path).getTime() > 1000){//checks if the key was pressed for less than a second
                pk.stopSound(path,s);
                keyStillPlaying1.put(path, false);
            }
        }
        else if(s.currentSliderNumber == 2){
            keyBeingPressed2.put(path, false);//States that the key is no longer being pressed
            if(keyTimers2.get(path).getTime() > 1000){//checks if the key was pressed for less than a second
                pk.stopSound(path,s);
                keyStillPlaying2.put(path, false);
            }
        }
    }


    public void playPianoKey(KeyEvent key,Slider s) throws FileNotFoundException, UnsupportedAudioFileException, IOException, LineUnavailableException{//plays the piano key if the key pressed is a piano key
        char keyChar = key.getKeyChar();
        String path = ""+s.octaveToString();
        
        if(s.currentSliderNumber == 1){//checks if the current slider is the first slider
            path += "-" + controlsOctave1.get(keyChar) + ".wav";//gets the path of the sound
            if(keyStillPlaying1.get(path)){//checks if the key is still playing
                path = null;
            }
            else{
                keyStillPlaying1.put(path, true);//sets the key pressed to true
                keyTimers1.put(path, new Timer());//creates a new timer for the given key
                keyTimers1.get(path).startTimer();//starts the timer for the given key
                keyBeingPressed1.put(path, true);
            }

        }
        else if(s.currentSliderNumber == 2){//checks if the current slider is the second slider
            path ="" + s.octaveToString() + "-" + controlsOctave2.get(keyChar) + ".wav";//gets the path of the sound keyStillPlaying2.put(path, true);//sets the key pressed to true
            if(keyStillPlaying2.get(path)){//checks if the key is still playing
                path = null;
            }
            else{
                keyStillPlaying2.put(path, true);//sets the key pressed to true
                keyTimers2.put(path, new Timer());//creates a new timer for the given key
                keyTimers2.get(path).startTimer();//starts the timer for the given key
                keyBeingPressed2.put(path, true);
            }
        
        }
        if(path != null){
            pk.playSound(path, s);//plays the sound
        }
    }


    public void update() throws InterruptedException{//updates the keys being pressed
        for(String path: keyStillPlaying1.keySet()){
            if(keyStillPlaying1.get(path) && !keyBeingPressed1.get(path)){//checks if the key is still playing and if the key is not being pressed
                stopPlayingKey(path,s1);//stops the key
            }
        }
        for(String path: keyStillPlaying2.keySet()){
            if(keyStillPlaying2.get(path) && !keyBeingPressed2.get(path)){//checks if the key is still playing and if the key is not being pressed
                stopPlayingKey(path,s2);//stops the key
            }
        }
    }
}
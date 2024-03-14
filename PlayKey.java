package PianoPoject;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class PlayKey {
	public PlayKey() {
	
	}
	
	public synchronized void playSound(String str) throws FileNotFoundException, UnsupportedAudioFileException, IOException, LineUnavailableException {
		  new Thread(new Runnable() {
		  
		    public void run() {
		      try {
		        Clip clip = AudioSystem.getClip(); // creates a new audion clip 
		        AudioInputStream inputStream = AudioSystem.getAudioInputStream(
		          MyPiano.class.getResourceAsStream("Notes/" + str)); // gets accses to folder with audio files
		        clip.open(inputStream); // opens the spesific file 
		        clip.start(); // playsm the clip
		      } catch (Exception e) {
		        System.err.println(e.getMessage());
		      }
		    }
		  }).start(); //starts audio clip
		}
	
}
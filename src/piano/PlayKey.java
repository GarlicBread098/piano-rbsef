package src.piano;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import src.bezel.Slider;

public class PlayKey {
	HashMap<String, Clip> clips1, clips2; 
	Slider s1, s2;

	public PlayKey() {
		clips1 = new HashMap<String, Clip>();
		clips2 = new HashMap<String, Clip>();
	}
	
	public synchronized void playSound(String octave, String str, Slider s) throws FileNotFoundException, UnsupportedAudioFileException, IOException, LineUnavailableException {
		new Thread(new Runnable() {
			public void run() {
				try {
					Clip clip = AudioSystem.getClip(); // creates a new audio clip 
					String path = "/NOTES/" + octave + str;
					
					AudioInputStream inputStream = AudioSystem.getAudioInputStream(
						MyPiano.class.getResourceAsStream(path)); // gets access to folder with audio files
					//System.out.println("/NOTES/" + octave + str);
					clip.open(inputStream); // opens the specific file 
					if(s.currentSliderNumber == 1){
						clips1.put(path,clip); // puts the clip in the hashmap along with the path to identify it
					}
					else if(s.currentSliderNumber == 2){
						clips2.put(path,clip); // puts the clip in the hashmap along with the path to identify it
					}
					clip.start(); // plays the clip
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
			}
		}).start(); //starts audio clip
	}

	public void stopSound(String octave, String str, Slider s) {//Stops the sound
		String path = "/NOTES/" + octave + str;//gets the path of the specified sound
		Clip clip = null;
		if(s.currentSliderNumber == 1){
			clip = clips1.get(path);//gets the clip from the hashmap
		}
		else if(s.currentSliderNumber == 2){
			clip = clips2.get(path);//gets the clip from the hashmap
		}	
		if (clip != null) {
			clip.stop();//stops the clip	
			clip.setFramePosition(0);
		}
	}
}

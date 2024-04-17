package rbsef;

import java.awt.*;
import javax.swing.*;

import rbsef.MyPanel.ButtonHandler;
import rbsef.MyPanel.KeyHandler;


public class PianoPane extends JPanel {
    
    String notes[] = {"C", "D", "E", "F", "G", "A", "B"}; // labels for white notes 
    String sharpNotes[] = {"C#", "D#", "F#", "G#", "A#"}; // labels for black notes 
    Button whiteKeys[] = new Button [7]; // number of desired white keys
    Button blackKeys[] = new Button[6]; // number of desired black keys
    
    public PianoPane(ButtonHandler bh, KeyHandler kh){
        setPreferredSize(new Dimension(1250,780)); //size of the frame holding the buttons

        for (int i = 0;i<7;i++) { //creates a loop that will create all keys in order 
            whiteKeys[i] = new Button (notes[i]); //creates a new key with its corresponding note
            add (whiteKeys[i]); //adds it to the frame
            setForeground(Color.BLACK); // sets color of text on the key to black
            whiteKeys[i].setBackground(new Color(255, 248, 230)); // sets color of the key to white/bonish color
            whiteKeys[i].addActionListener(bh);
            whiteKeys[i].addKeyListener(kh); // always checks if the keys is pressed 
            switch(i){
              case 0:
                blackKeys[0] = new Button(sharpNotes[0]); //creates first black key
                add(blackKeys[0]); 
                blackKeys[0].setForeground(Color.WHITE); // sets color of text on the key to white
                blackKeys[0].setBackground(Color.black); // sets color of the key to black
                blackKeys[0].addActionListener(bh);
                blackKeys[0].addKeyListener(kh);
                break;
              case 1:
                blackKeys[1] = new Button(sharpNotes[1]); //creates 2nd black key
                add(blackKeys[1]);
                blackKeys[1].setForeground(Color.WHITE); // sets color of text on the key to white
                blackKeys[1].setBackground(Color.black); // sets color of the key to black
                blackKeys[1].addActionListener(bh);
                blackKeys[1].addKeyListener(kh);
                break;
              case 3:
                blackKeys[3] = new Button(sharpNotes[2]); //creates 3rd black key
                add(blackKeys[3]);
                blackKeys[3].setForeground(Color.WHITE); // sets color of text on the key to white
                blackKeys[3].setBackground(Color.black); // sets color of the key to black
                blackKeys[3].addActionListener(bh);
                blackKeys[3].addKeyListener(kh);
                break;
              case 4:
                blackKeys[4] = new Button(sharpNotes[3]); //creates 4th black key
                add(blackKeys[4]);
                blackKeys[4].setForeground(Color.WHITE); // sets color of text on the key to white
                blackKeys[4].setBackground(Color.black); // sets color of the key to black
                blackKeys[4].addActionListener(bh);
                blackKeys[4].addKeyListener(kh);
                break;
              case 5:
                blackKeys[5] = new Button(sharpNotes[4]); //creates 5th black key
                add(blackKeys[5]);
                blackKeys[5].setForeground(Color.WHITE); // sets color of text on the key to white
                blackKeys[5].setBackground(Color.black); // sets color of the key to black
                blackKeys[5].addActionListener(bh);
                blackKeys[5].addKeyListener(kh);
                break;
            } 
            
            setLayout(new BoxLayout (this, BoxLayout.X_AXIS));
            setSize(750,500);
            
        }
    }

}

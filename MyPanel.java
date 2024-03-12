package PianoPoject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class MyPanel extends JPanel{
    ButtonHandler bh = new ButtonHandler(); // creaates button handler 
    PianoPane pp = new PianoPane(bh); // creates piano pane which holds the piano
    PlayKey pk = new PlayKey(); // creates the audio clips 
    JLabel console = new JLabel(); // makes a label to display records of pressed keys 
    
    ArrayList<String> outputs = new ArrayList<String>(); // holds records of pressed keys
    
    public MyPanel(){
        add(pp); // adds piano to frame
        add(console); // adds console to frame
        setPreferredSize(new Dimension(1250,900)); // sets size of frame
        setBackground(Color.black); //sets background color to black 
        console.setForeground(Color.white); // sets text for console to white
        console.setSize(200, 100); // sets the consoles size 
    }

    public void consoleUpdate(String note){ // method to update console output
      outputs.add(note); //adds most recent string to the record 
      console.setText(outputs.toString()); // sets console output to the record 
    }

    class ButtonHandler implements ActionListener{

        public void actionPerformed(ActionEvent e) {
          try {
            if(e.getSource() == pp.whiteKeys[0]){ // checks which key is pressed
              pk.playSound("key09.wav"); // plays that keys sound 
              consoleUpdate(pp.notes[0]); // adds that key to the console output
              
            }else if(e.getSource() == pp.whiteKeys[1]){ // checks which key is pressed
              pk.playSound("key10.wav"); // plays that keys sound 
              consoleUpdate(pp.notes[1]); // adds that key to the console output
              
            } else if(e.getSource() == pp.whiteKeys[2]){ // checks which key is pressed
              pk.playSound("key11.wav"); // plays that keys sound 
              consoleUpdate(pp.notes[2]); // adds that key to the console output
              
            } else if(e.getSource() == pp.whiteKeys[3]){ // checks which key is pressed
              pk.playSound("key12.wav"); // plays that keys sound 
              consoleUpdate(pp.notes[3]); // adds that key to the console output
              
            } else if(e.getSource() == pp.whiteKeys[4]){ // checks which key is pressed
              pk.playSound("key13.wav"); // plays that keys sound 
              consoleUpdate(pp.notes[4]); // adds that key to the console output
              
            } else if(e.getSource() == pp.whiteKeys[5]){ // checks which key is pressed
              pk.playSound("key14.wav"); // plays that keys sound 
              consoleUpdate(pp.notes[5]); // adds that key to the console output
              
            } else if(e.getSource() == pp.whiteKeys[6]){ // checks which key is pressed
              pk.playSound("key15.wav"); // plays that keys sound 
              consoleUpdate(pp.notes[6]); // adds that key to the console output
              
            }
            if(e.getSource() == pp.blackKeys[0]){ // checks which key is pressed
              pk.playSound("key17.wav"); // plays that keys sound 
              consoleUpdate(pp.sharpNotes[0]); // adds that key to the console output

            } else if(e.getSource() == pp.blackKeys[1]){ // checks which key is pressed
              pk.playSound("key18.wav"); // plays that keys sound 
              consoleUpdate(pp.sharpNotes[1]); // adds that key to the console output

            } else if(e.getSource() == pp.blackKeys[3]){ // checks which key is pressed
              pk.playSound("key20.wav"); // plays that keys sound 
              consoleUpdate(pp.sharpNotes[2]); // adds that key to the console output

            } else if(e.getSource() == pp.blackKeys[4]){ // checks which key is pressed
              pk.playSound("key21.wav"); // plays that keys sound 
              consoleUpdate(pp.sharpNotes[3]); // adds that key to the console output

            } else if(e.getSource() == pp.blackKeys[5]){ // checks which key is pressed
              pk.playSound("key22.wav"); // plays that keys sound 
              consoleUpdate(pp.sharpNotes[4]); // adds that key to the console output
            } 

        } catch (Exception e1Exception) {
          
        } 
    }
  }
}

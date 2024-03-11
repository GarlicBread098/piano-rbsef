package PianoPoject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class MyPanel extends JPanel{
    ButtonHandler bh = new ButtonHandler();
    PianoPane pp = new PianoPane(bh);
    PlayKey pk = new PlayKey();
    JLabel console = new JLabel();
    
    ArrayList<String> outputs = new ArrayList<String>();
    
    public MyPanel(){
        add(pp);
        add(console);
        setPreferredSize(new Dimension(1250,900));
        setBackground(Color.black);
        console.setBackground(Color.black);
        console.setForeground(Color.white);
        console.setSize(200, 100);
    }

    public void consoleUpdate(String note){
      outputs.add(note);
      console.setText(outputs.toString());
    }

    class ButtonHandler implements ActionListener{

        public void actionPerformed(ActionEvent e) {
          try {
            if(e.getSource() == pp.whiteKeys[0]){
              pk.playSound("key09.wav");
              consoleUpdate(pp.notes[0]);
              
            }else if(e.getSource() == pp.whiteKeys[1]){
              pk.playSound("key10.wav");
              consoleUpdate(pp.notes[1]);
              
            } else if(e.getSource() == pp.whiteKeys[2]){
              pk.playSound("key11.wav");
              consoleUpdate(pp.notes[2]);
              
            } else if(e.getSource() == pp.whiteKeys[3]){
              pk.playSound("key12.wav");
              consoleUpdate(pp.notes[3]);
              
            } else if(e.getSource() == pp.whiteKeys[4]){
              pk.playSound("key13.wav");
              consoleUpdate(pp.notes[4]);
              
            } else if(e.getSource() == pp.whiteKeys[5]){
              pk.playSound("key14.wav");
              consoleUpdate(pp.notes[5]);
              
            } else if(e.getSource() == pp.whiteKeys[6]){
              pk.playSound("key15.wav");
              consoleUpdate(pp.notes[6]);
              
            }
            if(e.getSource() == pp.blackKeys[0]){
              pk.playSound("key17.wav");
              consoleUpdate(pp.sharpNotes[0]);
            } else if(e.getSource() == pp.blackKeys[1]){
              pk.playSound("key18.wav");
              consoleUpdate(pp.sharpNotes[1]);
            } else if(e.getSource() == pp.blackKeys[3]){
              pk.playSound("key20.wav");
              consoleUpdate(pp.sharpNotes[2]);
            } else if(e.getSource() == pp.blackKeys[4]){
              pk.playSound("key21.wav");
              consoleUpdate(pp.sharpNotes[3]);
            } else if(e.getSource() == pp.blackKeys[5]){
              pk.playSound("key22.wav");
              consoleUpdate(pp.sharpNotes[4]);
            } 

        } catch (Exception e1Exception) {
          
        } 
    }
  }
}

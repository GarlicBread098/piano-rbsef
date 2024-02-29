package PianoPoject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import PianoPoject.MyPanel.ButtonHandler;

public class PianoPane extends JPanel {
    
    String notes[] = {"C", "D", "E", "F", "G", "A", "B"};
    String sharpNotes[] = {"C#", "D#", "F#", "G#", "A#"};
    Button whiteKeys[] = new Button [7];
    Button blackKeys[] = new Button[6];
    //PianoComponent pc = new PianoComponent(whiteKeys[0]);

    public PianoPane(ButtonHandler bh){
        setPreferredSize(new Dimension(1250,780));

        for (int i = 0;i<7;i++) {
            whiteKeys[i] = new Button (notes[i]);
            add (whiteKeys[i]);
            setForeground(Color.BLACK);
            whiteKeys[i].setBackground(new Color(255, 248, 230));
            whiteKeys[i].addActionListener(bh);
            switch(i){
              case 0:
                blackKeys[0] = new Button(sharpNotes[0]);
                add(blackKeys[0]);
                blackKeys[0].setForeground(Color.WHITE);
                blackKeys[0].setBackground(Color.black);
                blackKeys[0].addActionListener(bh);
                break;
              case 1:
                blackKeys[1] = new Button(sharpNotes[1]);
                add(blackKeys[1]);
                blackKeys[1].setForeground(Color.WHITE);
                blackKeys[1].setBackground(Color.black);
                blackKeys[1].addActionListener(bh);
                break;
              case 3:
                blackKeys[3] = new Button(sharpNotes[2]);
                add(blackKeys[3]);
                blackKeys[3].setForeground(Color.WHITE);
                blackKeys[3].setBackground(Color.black);
                blackKeys[3].addActionListener(bh);
                break;
              case 4:
                blackKeys[4] = new Button(sharpNotes[3]);
                add(blackKeys[4]);
                blackKeys[4].setForeground(Color.WHITE);
                blackKeys[4].setBackground(Color.black);
                blackKeys[4].addActionListener(bh);
                break;
              case 5:
                blackKeys[5] = new Button(sharpNotes[4]);
                add(blackKeys[5]);
                blackKeys[5].setForeground(Color.WHITE);
                blackKeys[5].setBackground(Color.black);
                blackKeys[5].addActionListener(bh);
                break;
            } 

            //add(pc);
            setLayout(new BoxLayout (this, BoxLayout.X_AXIS));
            setSize(750,500);
            
        }
    }

}

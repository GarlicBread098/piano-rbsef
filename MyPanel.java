package PianoPoject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

public class MyPanel extends JPanel{
    KeyHandler kh = new KeyHandler();
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
        setFocusable(true);
        addKeyListener(kh);

    }

    public void consoleUpdate(String note){
      outputs.add(note);
      console.setText(outputs.toString());
    }

    class KeyHandler implements KeyListener{
        
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode(); //registers the key typed
            System.out.println("blkajsf;klfsdfssssssssssssssssssssssssssssssssssssssssssssd");
            //white keys
            if(key == KeyEvent.VK_A){
                    try {
                        pk.playSound("key09.wav");
                        consoleUpdate(pp.notes[0]);
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }

            }
            if(key == KeyEvent.VK_S){
                try {
                    pk.playSound("key10.wav");
                    consoleUpdate(pp.notes[1]);
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            
            }
            if(key == KeyEvent.VK_D){
                try {
                    pk.playSound("key11.wav");
                    consoleUpdate(pp.notes[2]);
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

            }
            if(key == KeyEvent.VK_F){
                try {
                    pk.playSound("key12.wav");
                    consoleUpdate(pp.notes[3]);
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

            }
            if(key == KeyEvent.VK_G){
                try {
                    pk.playSound("key13.wav");
                    consoleUpdate(pp.notes[4]);
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

            }
            if(key == KeyEvent.VK_J){
                try {
                    pk.playSound("key14.wav");
                    consoleUpdate(pp.notes[5]);
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

            }
            if(key == KeyEvent.VK_K){
                try {
                    pk.playSound("key15.wav");
                    consoleUpdate(pp.notes[6]);
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

            }

            //black keys
            if(key == KeyEvent.VK_W){
                try {
                    pk.playSound("key17.wav");
                    consoleUpdate(pp.sharpNotes[0]);
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

            }
            if(key == KeyEvent.VK_E){
                try {
                    pk.playSound("key18.wav");
                    consoleUpdate(pp.sharpNotes[1]);
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

            }
            if(key == KeyEvent.VK_T){
                try {
                    pk.playSound("key20.wav");
                    consoleUpdate(pp.sharpNotes[2]);
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

            }
            if(key == KeyEvent.VK_Y){
                try {
                    pk.playSound("key21.wav");
                    consoleUpdate(pp.sharpNotes[3]);
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

            }
            if(key == KeyEvent.VK_U){
                try {
                    pk.playSound("key22.wav");
                    consoleUpdate(pp.sharpNotes[4]);
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

            }
        
        

            
        }

        @Override
        public void keyReleased(KeyEvent e) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
        }

        @Override
        public void keyTyped(KeyEvent arg0){

        }
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
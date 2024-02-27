package thirdprojects;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MyPanel extends JPanel{
    Button whiteKeys[] = new Button [7];
    ButtonHandler bh = new ButtonHandler();
    
    public MyPanel(){
        setPreferredSize(new Dimension(1250,780));
        
 
        for (int i = 0;i<7;i++) {
            whiteKeys[i] = new Button ("Key " + (i + 1));
            add (whiteKeys[i]);
            setForeground(Color.BLACK);
            whiteKeys[i].setBackground(new Color(255, 248, 230));
            whiteKeys[i].addActionListener(bh);
            
        }

        setLayout (new BoxLayout (this, BoxLayout.X_AXIS));
        setSize(750,500);
    }

    private class ButtonHandler implements ActionListener{

        public void actionPerformed(ActionEvent e) {
          if(e.getSource() == whiteKeys[0]){
            System.out.println("press1");
          }else if(e.getSource() == whiteKeys[1]){
            System.out.println("press2");
          } else if(e.getSource() == whiteKeys[2]){
            System.out.println("press3");
          } else if(e.getSource() == whiteKeys[3]){
            System.out.println("press4");
          } else if(e.getSource() == whiteKeys[4]){
            System.out.println("press5");
          } else if(e.getSource() == whiteKeys[5]){
            System.out.println("press6");
          } else if(e.getSource() == whiteKeys[6]){
            System.out.println("press7");
          }
        }
    }
}

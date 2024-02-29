package PianoPoject;

import javax.swing.JFrame;
import java.awt.*;

public class MyPiano extends JFrame { 
    MyPanel mp = new MyPanel();

    public MyPiano(){
        setTitle("Short Piano");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container pane = getContentPane();
		pane.add(mp);

        pack();
        setVisible(true);

    }
    public static void main(String[] args) {
        new MyPiano();
    }
}
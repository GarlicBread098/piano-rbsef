package rbsef;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPiano extends JFrame implements ActionListener{ 
    MyPanel mp = new MyPanel(); // creates myPanel

    JMenuBar jb = new JMenuBar(); // creates a menubar which holds menus
    JMenu js = new JMenu("Settings"); //creates a menu
    JMenu js2 = new JMenu("Help");

    JMenuItem off = new JMenuItem("Hide Console"); // creates a item called off which toggels off the visibility of the console 
	JMenuItem on = new JMenuItem("Show Console");  // creates a item called on which toggels on the visibility of the console 
    JMenuItem controls = new JMenuItem("Controls"); 

    public MyPiano(){
        setTitle("Piano Pilot"); //name of program
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        Container pane = getContentPane(); //creates the pane the program is in
		pane.add(mp); //adds adds myPanel to the pane 

        setJMenuBar(jb); //sets the menubar
        jb.add(js); // adds the menu setting and help
        jb.add(js2);

        js.add(off); //adds off to the menu 
        off.addActionListener(this); //add a listener to the off so it knows when it is clicked

        js.add(on); //adds on to the menu
        on.addActionListener(this); //add a listener to the on so it knows when it is clicked

        js2.add(controls);
        controls.addActionListener(this);
        pack(); //packs everthing into the frame
        setVisible(true); //makes everything visible

    }   
    
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == off){ //if what is pressed is off
            mp.console.setVisible(false); // hide console
        } else if(e.getSource() == on){ //if what is pressed is on
            mp.console.setVisible(true); // show console
        } else if(e.getSource() == controls){
            JOptionPane.showMessageDialog(this, "white keybinds: C = 'A',   D = 'S',    E = 'D',    F = 'F',    G = 'G',    A = 'J',    B = 'K'             black keybinds: C# = 'W',    D# = 'E',    F# = 'T',    G# = 'Y',    A# = 'U'");
        }
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

    public static void main(String[] args) {
        new MyPiano(); //runs program
    }
}
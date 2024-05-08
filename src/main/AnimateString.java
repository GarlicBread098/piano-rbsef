package src.main;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class AnimateString extends JPanel {
    private HashMap<Character, BufferedImage> imageCache = new HashMap<>(); // creates a hashmap to store the images
    ArrayList<String> outputs;  // creates an arraylist to store the outputs
    String str; // creates a string to store the outputs
    int removalCounter = 0; // keeps track of which values from the arrayList Notes have been removed
    int x, y; // the x and y coordinate for the string

    public AnimateString() {

    }

    public void draw(Graphics2D g2, ArrayList<String> outputs, int x, int y, int charWidth, int charHeight)
            throws IOException { // draws the string on the screen
        this.outputs = outputs; // sets the outputs to the outputs from the main class
        str = outputs.toString(); // converts the outputs to a string
        this.x = x; // sets the x coordinate to the x coordinate from the main class
        

        for (char ch : str.toCharArray()) { //iterates through the string
            if (ch == ' ') { // if the character is a space
                x += charWidth; //move the x coordinate to the right by a character width
            } 
            else { // if the character is not a space
                BufferedImage image = imageCache.get(ch); //set the image to the character in the image cache
                if (image == null) { // if the image is not in the cache 
                    String imagePath = "/Font/" + ch + ".PNG"; //set the image path to the character in the Font folder
                    InputStream inputStream = getClass().getResourceAsStream(imagePath);//get the input stream from the image path
                    if (inputStream != null) { // if the input stream is not null
                        try { // try to read the image
                            image = ImageIO.read(inputStream); //read the image
                            imageCache.put(ch, image); //put the image in the cache
                        } 
                        finally { //close the input stream
                            inputStream.close();
                        }
                    }
                }

                if (image != null) { // if the image is in the cache
                    g2.drawImage(image, x, y, charWidth, charHeight, null); //draw the image
                    x += (ch == ',') ? charWidth / 3 : charWidth; // if the character is a comma, move the x coordinate to the right by a third of the character width, otherwise move the x coordinate to the right by the character width
                } 
                else { // if the image is null
                    System.err.println("Image is null or not found for character: " + ch); //print an error message
                }
            }
        }
    }
}

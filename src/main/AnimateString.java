package src.main;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class AnimateString extends JPanel {
    ArrayList<String> outputs;
    String str;
    int removalCounter = 0; // keeps track of which values from the arrayList Notes have been removed
    int x, y; // the x and y coordinate for the string

    public AnimateString() {

    }

    public void draw(Graphics2D g2, ArrayList<String> outputs, int x, int y, int charWidth, int charHeight)
            throws IOException {
        this.outputs = outputs; // records the arraylist of strings into this classes outputs
        str = outputs.toString(); // updates the string to whatever the outputs arraylist holds
        this.x = x; // this is the current x coordinate that will paint the next character

        for (char ch : str.toCharArray()) { // iterates through each character in the string with the purpose to draw
                                            // each one
            if (ch == ' ') { // if the character is a space then we just update the x coordinate to move it
                             // along
                x += charWidth;
            }

            else { // else the character isn't a space then it will run the following code
                String imagePath = "/res/Font/" + ch + ".PNG"; // This is simply recording the path of the image for
                                                               // easy access
                InputStream inputStream = getClass().getResourceAsStream(imagePath); //

                if (inputStream != null) {
                    if (x > (MyPanel.screenWidth - (charWidth * 2))) {
                        outputs.remove(removalCounter);
                    }
                    try {
                        BufferedImage image = ImageIO.read(inputStream);
                        if (image != null) {
                            g2.drawImage(image, x, y, charWidth, charHeight, null);
                            if (ch == ',') {
                                x += charWidth / 3;
                            } else {
                                x += charWidth;
                            }
                        } else {
                            // Handle null image
                            System.err.println("Image is null: " + imagePath);
                        }
                    } finally {
                        inputStream.close(); // Close the input stream
                    }
                } else {
                    // Handle missing input stream
                    System.err.println("Input stream is null: " + imagePath);
                }
            }
        }
    }
}

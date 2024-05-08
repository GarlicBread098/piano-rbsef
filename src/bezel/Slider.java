package src.bezel;

import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Slider {
    BufferedImage notches,slider;
    
        public int x;
        public int y;
        public int width;
        public int height;
        public int octave = 7;

        public int sliderX;
        public int sliderWidth;
        public boolean sliderPressed = false;

        public Slider(int x, int y, int width, int height) {
            loadImages();
            setParameters(x, y, width, height);

        }

        public String octaveToString(){
            return String.valueOf(octave);
        }


        public void loadImages() { // load the images for the slider
            try {
                notches = ImageIO.read(getClass().getResourceAsStream("/Images/notches.png"));
                slider = ImageIO.read(getClass().getResourceAsStream("/Images/slider.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void setParameters(int x, int y, int width, int height) {// set the parameters for the slider
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;

            sliderWidth = width/8;
            sliderX = x + ((octave) * sliderWidth) - (sliderWidth/2);
            //sliderX = (x -(width/7)/2 - 35) + (octave * 35); //Sets the sliders X position by getting the x position of the slider and then subtracting half of the width of the slider and then subtracting 35 to get the correct position
            
        }

        public void moveSlider(){//moves the slider to the mouse position if the slider was pressed
            Point mouseLocation = MouseInfo.getPointerInfo().getLocation(); // gets the location of the mouse
            int mouseX = mouseLocation.x; // sets the x position of the mouse to the x position of the mouse location

            if(sliderPressed){ // checks if the slider is pressed
                if(mouseX < x){ // checks if the x position of the mouse is less than the x position of the slider
                    mouseX = x; // sets the x position of the mouse to the x position of the slider
                }
                else if(mouseX > (x + width)){ // checks if the x position of the mouse is greater than the x position of the slider plus the width of the slider
                    mouseX = x + width; // sets the x position of the mouse to the x position of the slider plus the width of the slider
                }
                else{
                    sliderX = mouseX - (sliderWidth/2); // sets the x position of the slider to the x position of the mouse minus half of the width of the slider
                    System.out.println(sliderX);
                }
                
            }
        }

        public void update() {//update the slider
            sliderX = x + ((octave) * sliderWidth) - (sliderWidth/2);
            moveSlider();

        }

        public void draw(Graphics g2) {//draws the Notches then the slider on top of it
            g2.drawImage(notches, x, y, width, height, null);
            g2.drawImage(slider, sliderX, y, sliderWidth, height, null);
        }
}


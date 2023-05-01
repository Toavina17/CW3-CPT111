/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CW3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;


/**
 *
 * @author andrew.abel
 */
public class ImagePanel extends JPanel {

    private final Image myImage;
    private final int myX, myY;
    private final int myWidth, myHeight;
    private final Person id;
    
    public ImagePanel(Person dispID,
                        int myX, 
                        int myY, 
                        int myWidth, 
                        int myHeight) {
        
        // Constructor for image panel        
        // Complete this method
        
        this.id = dispID;
        this.myX = myX;
        this.myY = myY;
        this.myWidth = myWidth;
        this.myHeight = myHeight;
        this.myImage = this.id.getPhoto();
        Color col = new Color(183, 166, 124);
        setBackground(col); 
        
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
  
        //Initial values
        Color brown = new Color(183, 166, 124);
        
        //WANTED TEXT 
        Font font = new Font("DialogInput", Font.BOLD, 40);
        g.setFont(font);
        g.setColor(Color.BLACK);
        g.drawString("WANTED", (this.myWidth  - g.getFontMetrics().stringWidth("WANTED"))/2, font.getSize());
        
        //DEAD OR ALIVE
            //rectangle
            g.fillRect(40, 60, this.myWidth - 80, 35);
            
            //add the 2 circles and the rectangles if i can
            
            //write dead or alive
            Font alive = new Font("Nimbus Sans L", Font.PLAIN, 30);
            g.setFont(alive);
            g.setColor(brown);
            g.drawString("DEAD OR ALIVE", (this.myWidth  - g.getFontMetrics().stringWidth("DEAD OR ALIVE"))/2, 90);

        //Add the picture of the criminal
        g.drawImage(this.myImage, 100, 110, 200, 200, this);
        
        //Add the name of the criminal
        String name = id.getFirstName() + " \""+ id.getNickname() + "\" " + id.getFamilyName();        
        g.setColor(Color.BLACK);
        int size = 20;
        Font criminal = new Font("Lato Heavy", Font.PLAIN, size);
        g.setFont(criminal);        
            //In case the size of the police is too big and the name does not enter in one line
            //use this
            //if(g.getFontMetrics().stringWidth(name) > this.myWidth){
                while(g.getFontMetrics().stringWidth(name) > this.myWidth){
                    size--;
                }
            //}
        
        g.drawString(name, (this.myWidth  - g.getFontMetrics().stringWidth(name))/2, 350);
        
        //put the next big rectangle for the reason why this person is wanted
        g.fillRect(50, 375, this.myWidth - 100, 60);
        
        //the offense they did
        String offense = id.getCrimes();         
        Font off = new Font("URW Gothic L", Font.PLAIN, 20);
        g.setFont(off);
        g.setColor(brown);         
        if(g.getFontMetrics().stringWidth(offense) > this.myWidth - 120){
            String one = offense.substring(0, (offense.length())/2);
            String two = offense.substring((offense.length())/2 + 1);
            g.drawString(one, (this.myWidth  - g.getFontMetrics().stringWidth(one))/2, 395);
            g.drawString(two, (this.myWidth  - g.getFontMetrics().stringWidth(two))/2, 415);
        }else{
            g.drawString(offense, (this.myWidth  - g.getFontMetrics().stringWidth(offense))/2, 375+font.getSize());
        }
        
        //age of the person
        String age = "Age: " + id.getAgeinYears();
        g.setFont(criminal);
        g.setColor(Color.BLACK);
        g.drawString(age, (this.myWidth  - g.getFontMetrics().stringWidth(age))/2, 455);
        
        //Reward
        String reward = "$" + id.getReward();
        Font rew = new Font("Bitstream Vera Serif", Font.BOLD, 30);
        g.setFont(rew);
        g.drawString("REWARD", (this.myWidth  - g.getFontMetrics().stringWidth("REWARD"))/2, 500);
        g.drawString(reward, (this.myWidth  - g.getFontMetrics().stringWidth(reward))/2, 550);
    }
    
    
    // Getters, do not need to change
     @Override
    public int getX() {
        return myX;
    }

    @Override
    public int getY() {
        return myY;
    }

    @Override
    public int getWidth() {
        return myWidth;
    }

    @Override
    public int getHeight() {
        return myHeight;

    }
}

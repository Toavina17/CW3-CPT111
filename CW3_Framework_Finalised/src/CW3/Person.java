/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CW3;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import javax.imageio.ImageIO;

/**
 *
 * @author andrew.abel
 */
public class Person {

    // Instance variables
    private String firstName;
    private String familyName;
    private String nickname;
    private int reward;
    private String nationality;
    private String idCode;
    private String crimes;
    private LocalDate dob;
    private Image photo;

    public Person(String[] info) {
        // Constructor to take a String array and assign it to instance variables
        
        // Complete this method 
        //DONE
        this.firstName = info[0];
        this.familyName = info[1];
        this.nickname = info[2];
        this.reward = Integer.parseInt(info[3]);
        this.nationality = info[4];
        this.idCode = info[5];
        this.crimes = info[6];
        this.dob = convertDateOfBirth(info[7]); 
        this.photo = readImage(info[8]);
        
    }

    public Person(String line) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        // Constructor to take a single string, the entire line of a file, and assign
        // it to instance variables

        // Complete this method
        
        String[] split = line.split(",");
        for(int i = 0; i < split.length; i ++){
            split[i] = split[i].trim();
        }
        
        this.firstName = split[0];
        this.familyName = split[1];
        this.nickname = split[2];
        this.reward = Integer.parseInt(split[3]);
        this.nationality = split[4];
        this.idCode = split[5];
        this.crimes = split[6];
        this.dob = convertDateOfBirth(split[7]); 
        this.photo = readImage(split[8]);
        
    }

    public BufferedImage readImage(String filename) {
        // Read an image from a file and return a Buffered image

        // Complete this method
        // Return temporary value, change this
        BufferedImage image = null;
        try{           
            image = ImageIO.read(new File(filename));
        }
        catch(IOException e){
            System.out.println("Image error!");
        }
        return image;
    }

    public LocalDate convertDateOfBirth(String inputDate) {
        // Take a date input String and convert to a local date
        // If the date is an incorrect value, assign a default value of 1/1/1991

        // Complete this method
        // Return temporary value, change this
        
        LocalDate date;
        try{
            String[] datestring = inputDate.split("/");
            //date = LocalDate.of(datestring[0], datestring[1], datestring[2]);
            int year = Integer.parseInt(datestring[2].trim());
            int month = Integer.parseInt(datestring[1].trim());
            int day = Integer.parseInt(datestring[0].trim());
            //date = LocalDate.of(day, month, year);

            if (day > 31 || month > 12 || year < 0 || month < 1 || day < 1) {           
                date = LocalDate.of(1991, 1, 1);
                return date;
            } else {
                date = LocalDate.of(year, month, day);
                return date;
            } 
        }
        catch(DateTimeException d){
            date = LocalDate.of(1991, 1, 1);
            return date;
        }
    }

    public int getAgeinYears() {
        // return the age of the person in years

        // Complete this method
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public String toString() {
        // Output method as String

        // Do not change!
        String out = "***\n" + getIdCode() + ", " + getFirstName() + " "
                + getFamilyName() + ", Reward: " + getReward() + ", " + getNationality()
                + ", " + getDob().toString() + ", " + getNickname() + ", " + getCrimes();

        return out;
    }

    // All getters are completed, do not change
    public String getFirstName() {

        return firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public int getReward() {
        return reward;
    }

    public String getNationality() {
        return nationality;
    }

    public String getIdCode() {
        return idCode;
    }

    public LocalDate getDob() {
        return dob;
    }

    public Image getPhoto() {
        return photo;
    }

    public String getNickname() {
        return nickname;
    }

    public String getCrimes() {
        return crimes;
    }

}

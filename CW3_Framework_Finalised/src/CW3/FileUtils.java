/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CW3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andrew.abel
 */
public class FileUtils {
       
    public static List<Person> readFile(String filename) {

        // Receive a filename String, and read a file, storing all person 
        // information in an arraylist, handling any file reading errors and
        // returning an array list
        
        // Complete this method
        
        // temporary return line, change this
        
        //get the file
        Path path = Paths.get(filename);
        ArrayList<Person> person;
        person = new ArrayList<>();
        //try read the file        
        try{
            BufferedReader reader =Files.newBufferedReader(path);
            String lineContent=reader.readLine(); 
            while(lineContent != null){
                Person arr = new Person(lineContent);
                person.add(arr);               
                lineContent=reader.readLine();                 
            }
            //close the reader to make sure it's not holding any memory
            reader.close();
        }
        catch(IOException e){
            System.out.println("No file named " + filename);
        }
        return person;
    }
}

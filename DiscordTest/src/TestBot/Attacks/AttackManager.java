/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestBot.Attacks;

import java.io.*;

/**
 *
 * @author Matthew Stanley {@literal <mastanley3@zagmail.gonzaga.edu>}
 */
public class AttackManager {
    private final static String fileName = "Attacks.pfa";
    
    public void readFile(){
        try {
            FileReader reader = new FileReader(fileName);
            BufferedReader buffer = new BufferedReader(reader);
            String line = null;
            int count = 0;
            
            while((line = buffer.readLine()) != null){
                switch(count){
                    case(0):
                        
                }
                
                
                count++;
            }
            
            buffer.close();
            reader.close();
        } catch (FileNotFoundException ex) {
            System.err.println("Unable to open file");
        } catch(IOException ex) {
            System.err.println("Error reading file");
        }
    }
}

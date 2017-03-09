package engine;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.PrintWriter;

public class Io {
    
   static String filename = "data.csv";
    
    
    public static boolean SearchFile(String key,int col){
        File file = new File(filename);
        String data;
        boolean isExist = false;
        try {
            Scanner p = new Scanner(file);
            while (p.hasNext()){
                data = p.next();
                String[] val = data.split(",");
                if ( val[col].equals(key)){
                    isExist = true;
                }
            }
       
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Io.class.getName()).log(Level.SEVERE, null, ex);
        }
       return isExist; 
    }
    
    public static int CountFile (){
      File file = new File(filename);
      int count = 0;
       try {
           Scanner p = new Scanner(file);
           while(p.hasNext()){
               count++;
               p.next();
           }
       } catch (FileNotFoundException ex) {
           Logger.getLogger(Io.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       return count;
    }
    
    public static void AddData(){
        File file = new File(filename);
        PrintWriter pw;
       try {
           pw = new PrintWriter(new File("data.csv"));
        
        Scanner p = new Scanner(file);
        
        p.next();
        p.next();
        p.next();
        p.next();
        StringBuilder sb = new StringBuilder();
        sb.append("id");
        sb.append(',');
        sb.append("Name");
        sb.append('\n');

        sb.append("1");
        sb.append(',');
        sb.append("Prashant Ghimire");
        sb.append('\n');

        pw.write(sb.toString());
        pw.close();
       } catch (FileNotFoundException ex) {
           Logger.getLogger(Io.class.getName()).log(Level.SEVERE, null, ex);
       }
               
                
    }
    
}

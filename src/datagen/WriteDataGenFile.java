/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datagen;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Abdul Wahab
 */
public class WriteDataGenFile {
    
    
    
    public static void writeFile(String OutPutFile , StringBuilder sbFileWrite){
       PrintWriter writer = null;
       try {
           writer = new PrintWriter(OutPutFile, "UTF-8");
           
           writer.println(sbFileWrite.toString());
          
           
           writer.close();
       } catch (FileNotFoundException ex) {
           Logger.getLogger(WriteDataGenFile.class.getName()).log(Level.SEVERE, null, ex);
       } catch (UnsupportedEncodingException ex) {
           Logger.getLogger(WriteDataGenFile.class.getName()).log(Level.SEVERE, null, ex);
       } finally {
           writer.close();
       }
    }
    
    
}

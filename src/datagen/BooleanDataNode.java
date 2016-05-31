/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datagen;

import java.util.Random;

/**
 *
 * @author Abdul Wahab
 */
public class BooleanDataNode implements IdataNodeInterface {

private    String Name;
    public BooleanDataNode(String Name){
        this.Name = Name;
    }
    
    @Override
    public String getDataNodeName() {
        return Name;
    }

    @Override
    public String getRandomValue() {
      
          Random random = new Random();
          int  randomNumber = random.nextInt() %2 ;
       if (randomNumber==0 ) 
           return "false";
       else
           return "true";
       
    }
    
    
     @Override
    public String toString(){
        return getDataNodeName()+" boolean  ";
    }
}

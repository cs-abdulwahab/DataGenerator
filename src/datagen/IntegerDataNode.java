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
public class IntegerDataNode implements IdataNodeInterface{
    
    private String Name;
    int min;
    int max;

    public IntegerDataNode(String Name , int min , int max) {
    
    this.Name = Name;
    this.min = min ;
    this.max = max;
    
    }
    
    @Override
      public String  getRandomValue()throws IndexOutOfBoundsException{
            
      
          Random random = new Random();
          int  randomNumber = random.nextInt(max - min) + min;
       return randomNumber+"";
   
   }

    @Override
    public String getDataNodeName() {
        return Name;
    }
    
     @Override
    public String toString(){
        return getDataNodeName()+" int  ";
    }
    
}

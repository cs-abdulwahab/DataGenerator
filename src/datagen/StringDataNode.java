/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datagen;

import java.util.*;


/**
 *
 * @author Abdul Wahab
 */
public class StringDataNode implements IdataNodeInterface{
    
    private String Name;
    private ArrayList <String>range;

    public StringDataNode(String Name) {    
       this.Name = Name;
        range =new ArrayList();
    }
    

    @Override
    public String  getRandomValue()throws IndexOutOfBoundsException{
            
       String randString ;
       double d = Math.random() ;
             
        if (range.isEmpty() )
          throw new IndexOutOfBoundsException("OptionsList is Empty");
           
          d = d * range.size();
          int r = (int)Math.floor(d);
          
          try 
          {  
              randString =  range.get(r);
          }
          catch(Exception ex){
            randString = "NULL";
          }
       
       return "'"+randString+"'";
   
   }
    
    void addOption(String opt){
    range.add(opt);
    
    }

    @Override
    public String getDataNodeName() {
        return Name;
    }
    
    
    @Override
    public String toString(){
        return getDataNodeName()+" varchar (250)  ";
    }
    
    
}



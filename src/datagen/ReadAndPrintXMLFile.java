/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datagen;

/**
 *
 * @author Abdul Wahab
 */
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException; 

public class ReadAndPrintXMLFile{
    
    String readFile;
    
    public ReadAndPrintXMLFile(String readFile){
            this.readFile = readFile;
    }
    public ReadAndPrintXMLFile(){
            this.readFile = "DataNode.xml";
    }
    
    public  ArrayList Read (){
        
        ArrayList <IdataNodeInterface> ar = new ArrayList();
        
        try 
        {   
            
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse (new File(  this.readFile  ));
        
            // normalize text representation
            doc.getDocumentElement ().normalize ();
        
            NodeList listOfDataNodes = doc.getElementsByTagName("DataNode");
        
            for(int s=0; s < listOfDataNodes.getLength() ; s++){

                Node myDataNode = listOfDataNodes.item(s);                
                if (myDataNode.hasChildNodes() )
                    {
                        Element myDataNodeElement = (Element)myDataNode;
                
                            String Name = myDataNodeElement.getAttribute("name");
                            String type = myDataNodeElement.getAttribute("type");
                           
                            if ( type.equals("String") )
                            {
                            StringDataNode     sdn = new StringDataNode(Name);
                            NodeList getOptionList = myDataNodeElement.getElementsByTagName("option");

                                for(int c=0; c < getOptionList.getLength() ; c++)
                                {
                                    Element myDataNodeOptionElement = (Element) getOptionList.item(c);;
                                    String str = myDataNodeOptionElement.getTextContent();
                                    sdn.addOption(str);
                                }
                            ar.add(sdn);
                            }
                            
                             if ( type.toLowerCase().equals("boolean") )
                            {                           
                               
                                BooleanDataNode  idn = new BooleanDataNode(Name);
                           
                            ar.add(idn);
                            
                            }
                            
                            if ( type.equals("Number") )
                            {                           
                                String min = myDataNodeElement.getAttribute("min");
                                String max = myDataNodeElement.getAttribute("max");

                                int Min = Integer.parseInt(min);
                                int Max = Integer.parseInt(max);
                              
                                IntegerDataNode  idn = new IntegerDataNode(Name, Min, Max);
                           
                            ar.add(idn);
                            
                            }
                    
                    }
                 

                
                
            }//end of for loop with s var


        }catch (SAXParseException err) {
        System.out.println ("** Parsing error" + ", line " 
             + err.getLineNumber () + ", uri " + err.getSystemId ());
        System.out.println(" " + err.getMessage ());

        }catch (SAXException e) {
        Exception x = e.getException ();
        ((x == null) ? e : x).printStackTrace ();

        }catch (Throwable t) {
        t.printStackTrace ();
        }
        //System.exit (0);

    
    
    
    return ar;
    
    
    }//end of main

    public  String  ReadTableName (){
       
        String tableName ="";
        
        try {    
            
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc=null;
            try {
                doc = docBuilder.parse (new File(  this.readFile  ));
            } catch (SAXException ex) {
                Logger.getLogger(ReadAndPrintXMLFile.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ReadAndPrintXMLFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        
             tableName  = doc.getDocumentElement().getAttribute("name");
            
        } //end of main
        catch (ParserConfigurationException ex) {
            Logger.getLogger(ReadAndPrintXMLFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    return tableName;
    
    }//end of main
    
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datagen;

import java.util.ArrayList;


/**
 *
 * @author Abdul Wahab
 */
public class DataGen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String InputFile="DataNode.xml";
        String OutPutFile="Output.txt";
        int NumberofInstances = 10;
        
        /*
         Input.xml
         Output.txt   it contains
         200     number of instances
         */
        
        InputFile = args[0];
        OutPutFile = args[1];
        NumberofInstances = Integer.parseInt(args[2]);
        
        
        for (String string : args) {
            System.out.println(string);
        }
        
        ArrayList <IdataNodeInterface> id ;
        
        ReadAndPrintXMLFile rd = new ReadAndPrintXMLFile(InputFile);
         id =   rd.Read();
         
         String DataTable = rd.ReadTableName();
         StringBuilder strbuildMainQuery = new StringBuilder();
        //Create Column
         StringBuilder sbColumnsListCreateCol = new StringBuilder();
        // Create ColumnList
         StringBuilder sbColumnsList = new StringBuilder();
        // Create ValueList
         StringBuilder sbValueList = new StringBuilder();
        
         /****************************************/
         
         for(IdataNodeInterface idni : id){
             String s = idni.toString() +" , ";
            sbColumnsListCreateCol.append(s);
         }
          // -2  is done to truncate that extra  comma,   in the list
        String strCreateColumnList = sbColumnsListCreateCol.substring(0, sbColumnsListCreateCol.length()-2);
        
         /**********************************************/ 
        for(IdataNodeInterface idni : id){
            sbColumnsList.append(idni.getDataNodeName() +" , ");
         }
          // -2  is done to truncate that extra  comma,   in the list
        String strColumnList = sbColumnsList.substring(0, sbColumnsList.length()-2);
      
        /**********************************************/
      String strTable = " create table "+  DataTable   +" ( id int , ";
             strTable = strTable + strCreateColumnList;
             strTable = strTable + ");\n";
     
             
             strbuildMainQuery.append(strTable);
        
         for(int i = 1 ; i<= NumberofInstances ; i++ )
        {
            for(IdataNodeInterface idni : id)
            {
                sbValueList.append( idni.getRandomValue()+" , ");
            }
            // -2  is done to truncate that extra  comma,   in the list
            String strValueList = sbValueList.substring(0, sbValueList.length()-2);
        sbValueList.delete(0, sbValueList.length()-1);
            
          strbuildMainQuery.append( " insert into "+ DataTable +" ( id ,  "+ strColumnList  +") values("+ i +"   ,"+strValueList+");\n"  );
         
        }
      
          
         WriteDataGenFile.writeFile(OutPutFile,strbuildMainQuery);
         
        System.out.println( strbuildMainQuery  );
        
    
    }





}

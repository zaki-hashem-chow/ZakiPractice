/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ZakiPractice;

/**
 *
 * @author Zaki Admin
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Exception;


public class SubString2 extends CharType{
    
       
    private static ArrayList<String> charTypeArray = new ArrayList<String>();
    private static ArrayList<String> charArray = new ArrayList<String>();
    private static ArrayList<String> subStringArray = new ArrayList<String>();
    private static String subStringText;
    private int i;
    private String chr1 = null;

    
    private boolean sameOperator(){                                             //This Methode To see if there are more then 1 operator togather(continuasly) in the charArray
        boolean sameOperator = false;
        if(charTypeArray.get(i + 1) == null){
            sameOperator = false;
        }else if((charTypeArray.get(i) == "operator") && (charTypeArray.get(i + 1) == "operator")){        
            sameOperator = true;
        }else{
            sameOperator = false;
        }
        return sameOperator;
    }
       
    
    private void arrayMaker(){                                                  //This method is to create charArray(arrayList) of single characters from the string input
        String expression = null;                                               //and another charTypeArray(arrayList) of characterTypes(for characters
        Scanner sc = new Scanner(System.in);                                    //stored in charArray) returned from CharType Class passing same string input.
        System.out.println("Enter Calculation String then press Return: ");        
        expression = sc.nextLine();
        expression = expression.replaceAll(" ", "");     
        CharType ct = new CharType();
        
        for(i =0; i<expression.length(); i++){
           charTypeArray.add(i, ct.identifyChar(expression.charAt(i)));                                   
            charArray.add(i, Character.toString(expression.charAt(i)));
        }
        
    }
    
    public ArrayList subStringMaker(ArrayList charTypeArray, ArrayList charArray){
        
        SubString2 sc = new SubString2();
        sc.arrayMaker();
        
        charTypeArray = SubString2.charTypeArray;
        charArray = SubString2.charArray;        
        String chrType = null;
       // String str; 
        String subStringText = "";

      try{
          
        FOR:                                                                                 // FOR label        
        for(i = 0; i < charArray.size(); i++){            
            chr1 = charArray.get(i).toString();
            chrType = charTypeArray.get(i).toString();
            

            IF:                                                                             // IF label            
            if(i == 0){                                                                     ///First caracter block
                
                switch(chrType){
                    case "digit": {                           
                        subStringText = chr1; 
                        break IF;}                            

                    case "operator": {                           
                        System.err.println("Invalid First Craracter[ "+ chr1 +" ](type Operator)!!");     //////change this portion to enable operator at 1st character of string
                        break FOR; }  

                    default: System.err.println("Invalid First Craracter[ "+ chr1 +" ](type UnKnown)!!");
                        break FOR;                                               
                }
                
            }else if((i > 0) && (i < (charArray.size() - 1))){                          ///Middle caracters block
                
                switch(chrType){
                    case "digit": {
                        subStringText = subStringText +""+ chr1;                                                   
                        break IF;}                            

                    case "operator": {
                        subStringArray.add(subStringText);
                        
                        if(sameOperator()){
                            subStringArray.add(chr1);
                            subStringText = "";
                            i++;
                        }else{
                            subStringArray.add(chr1);
                            subStringText = "";                            
                        }
                        break; }  

                    default: System.err.println("Invalid Craracter[ "+ chr1 +" ](type Unknown)!!");
                        break FOR;                                               
            }
                
            }else{                                                                      ///Last caracter block
                
                switch(chrType){
                    case "digit": {
                        subStringText = subStringText +""+ chr1;
                        subStringArray.add(subStringText);
                        subStringText = "";                                                   
                        break IF;}                            

                    case "operator": {                           
                        System.err.println("Invalid Last Caracter[ "+ chr1 +" ](type Operator)!!");                                               
                        break FOR; }  

                    default: System.err.println("Invalid Last Caracter[ "+ chr1 +" ](type Unknown)!!");
                        break FOR;                                               
                }
                
            }          
                       
        }
        
      }catch(IndexOutOfBoundsException x){
          System.err.println(x);
      }
      
        return subStringArray;
    }
                  
 public static void main(String[] args){  
     
       SubString2 sc = new SubString2();
       ArrayList al = sc.subStringMaker(charTypeArray, charArray);
             
     System.out.println("Result ======>> "+subStringArray); 
     
}

}

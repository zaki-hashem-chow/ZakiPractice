package ZakiPractice;

// Refer to Calculator2, SubString, CharType class .java 

import java.util.ArrayList;
import java.util.Scanner;

public class SubString extends CharType{
   
   
       
    private static ArrayList<String> charTypeArray = new ArrayList<String>();
    private static ArrayList<String> charArray = new ArrayList<String>();
    public static ArrayList<String> subStringArray = new ArrayList<String>();
    static String subStringText;
    private int i;
    private String chr1 = null;
    
    
    private boolean sameOperator(){                                             //This Methode To see if there are more then 1 operator togather(continuasly) in the charArray
        boolean sameOperator = false;
        if(charTypeArray.get(i + 1) == null){
            sameOperator = false;
        }else if(charTypeArray.get(i + 1) == "operator" || charTypeArray.get(i - 1) == "operator"){        
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
        
        charTypeArray = SubString.charTypeArray;
        charArray = SubString.charArray;        
        String chrType = null;
        String str; 
        String subStringText = "";
        
        FOR:
        
        for(i=0; i<charArray.size(); i++){           
            int j=0;   
            chr1 = charArray.get(i).toString();
            chrType = charTypeArray.get(i).toString();
            
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            IF:
            
            if(charArray.size()-i < 2){                 
                switch(chrType){                                                //for last the character of the string ### I think 
                        case "digit": {                                         //this part is ok up to big comment line below
                            if(charTypeArray.get(i-1)=="digit"){
                                subStringText = subStringText + "" + chr1;
                                subStringArray.add(j, subStringText);
                                break FOR;
                                
                             }else if(charTypeArray.get(i-1)=="operator"){
                                subStringText = chr1;
                                subStringArray.add(j, subStringText);
                                break FOR;
                             }
                             break FOR;}
                        
                        case "operator": {
                            System.out.println("Invalid Last Craracter!!");
                             break FOR; }
                       
                        default: System.out.println("Invalid First Craracter!!");
                            break FOR;
                }
//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::                 

            }else{                                                              //this part (After the commented line above) 
                                                                                //is for the middle portion of the string 
                if(charArray.size() >= 1){                                      //(after first Character, before last character)
                                                                                // I am sure that the problem is in this portion
                    if(i > 0){
                        switch(chrType){
                           case "digit": {
                               
                                if(charTypeArray.get(i-1)=="digit"){
                                    subStringText = subStringText + "" + chr1; 
                                    break IF;
                                    
                                }else if(charTypeArray.get(i-1)=="operator"){
                                    j++;
                                    subStringText = subStringText + "" + chr1;
                                    break IF;
                                    
                                }break IF;}

                           case "operator": {
                               if(chr1.contains("-")){ 
                                   
                                    if(sameOperator() == false){
                                       subStringArray.add(j, subStringText);
                                       j++;
                                       subStringArray.add(j, chr1);
                                       subStringText = "";
                                       
                                    }else{
                                        System.out.println("Invalid Double Operator!!");
                                        break FOR;
                                    }  
                                    break IF;
                                    
                               }else if(chr1.contains("+")){
                                   
                                    if(sameOperator() == false){
                                    subStringArray.add(j, subStringText);
                                    j++;
                                    subStringArray.add(j, chr1);
                                    subStringText = "";
                                    
                                 }else{
                                     System.out.println("Invalid Double Operator!!");
                                     break FOR;
                                 }
                                    break IF;
                               }                          
                               break IF; } 
                           
                           default: System.out.println("Invalid First Craracter!!");
                               break FOR;
                           } 
                    }else{                                                          //for first character of the string ## I think this part is ok too
                        
                        switch(chrType){
                            case "digit": {                           
                                    subStringText = chr1;                                                                                        
                                 break IF;} 

                            case "operator": {                           
                                System.out.println("Invalid First Craracter!!");     //////change this portion to anable operator at 1st character of string
                                 break FOR; }  

                        default: System.out.println("Invalid First Craracter!!");
                            break FOR;                                               
                        } 
                    }
                }else{ 
                    System.out.println("Invalid formula!!!");
                    break FOR;
                }           
            }   
        
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
       }       
        return subStringArray;
    }
    
              
 public static void main(String[] args){  
     
       SubString sc = new SubString();
       sc.arrayMaker();
       ArrayList al = sc.subStringMaker(charTypeArray, charArray);
             
     System.out.println("Result ======>> "+subStringArray);         
}}

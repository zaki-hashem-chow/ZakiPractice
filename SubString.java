package ZakiPractice;

// Refer to Calculator2, SubString, CharType class .java 

import java.util.ArrayList;
import java.util.Scanner;

public class SubString extends CharType{
    
    private static String expression = null;   
    private static String str= "";   
    private static ArrayList<String> charTypeArray = new ArrayList<String>();
    private static ArrayList<String> charArray = new ArrayList<String>();
    public static ArrayList<String> subStringArray = new ArrayList<String>();
    
    
    
    private void arrayMaker(){
       
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Calculation String then press Return: ");        
        expression = sc.nextLine();
        expression = expression.replaceAll(" ", "");     
        CharType ct = new CharType();
        
        for(int i =0; i<expression.length(); i++){
            charTypeArray.add(i, ct.identifyChar(expression.charAt(i)));                                   
            charArray.add(i, Character.toString(expression.charAt(i)));
        }
    
    }
    public ArrayList getCharArray(){
        
        return charArray;
    }
    public ArrayList getCharTypeArray(){
        return charTypeArray;
    }
    
    public ArrayList subStringMaker(){
        String chr1 = null;
        String subString = null;
        String chrType = null;
        for(int i=0; i<charArray.size(); i++){           
            int j=0;   
            chr1 = charArray.get(i);
            chrType = charTypeArray.get(i);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            if(charTypeArray.get(i) != null){
               if(charTypeArray.get(i-1) != null){
                   
               
                   
                    
               }else{
                    switch(chrType){
                        case "digit": {
                            subString = chr1;                                                                      
                            break;}
                        
                        case "operator": {
                            if(chr1.contains("+")){
                            
                            }else if(chr1.contains("-")){
                                             
                            }else{
                                  System.out.println("Invalid Operator at first character of string!!");
                            }break;}
                        
                        default: System.out.println("Invalid First Craracter!!");
                        }
                    
               }
            }else{
                System.out.println("i = null!!");
            }
            subStringArray.add(str)
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
       }
        
        return subStringArray;
    }
              
 public static void main(String[] args){  
     
       SubString sc = new SubString();
       sc.arrayMaker();
       
        
       
       
       
     System.out.println(charTypeArray+"--->"+charArray+"======>>"+subStringArray);         
}}

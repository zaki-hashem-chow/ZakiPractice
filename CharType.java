/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ZakiPractice;

// Refer to Calculator2, SubString, CharType class .java 

/**
 *
 * @author Zaki Hashem Chowdhury
 */
public class CharType {
  
    public String identifyChar(char chr){
        
         String type = null;
 
        if(Character.isDigit(chr)){
            type = "digit";
        }
        else if(Character.isLetter(chr)){
            type = "letter";
        }
        else if(Character.isWhitespace(chr)){
            type = "space";
        }
        else if(isOperator(chr)== true){
            type = "operator";
            
        }else if(chr == '.'){
            type = "point";
                    
        }else{
            type = "err";
        }
        
        return type;
    }
           
    private boolean isOperator(char opr){       
        boolean operator = false;
        
        if(opr == '+'){
            operator = true;
        }
        else if(opr == '-'){
            operator = true;
        }
        else if(opr == '*'){
            operator = true;
        }
        else if(opr == '/'){
            operator = true;
        }
        else{
            operator = false;
        }        
        
        return operator;
    }    
}

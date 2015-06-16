/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ZakiPractice;
import java.util.Scanner;

/**
 *
 * @author Zaki Admin
 */
public class Calculator {
    static float firstNumber = 0;
    static float secondNumber = 0;
    static float result = 0;
    static String operatorSign;
    static String opr;

    
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter First Nmber: ");
        firstNumber = sc.nextFloat();
        
        System.out.println("What operation you want to do?: ");
        operatorSign = sc.next();
        
        System.out.println("Enter Next Number: ");
        secondNumber = sc.nextFloat();
        
        
        opr = operatorSign.replace(" ", "");
        
        if(opr.equals("*")){
            result = firstNumber * secondNumber;
            
        }else if(opr.equals("+")){
            result = firstNumber + secondNumber;
            
        }else if(opr.equals("-")){
            result = firstNumber - secondNumber;
        }else if(opr.equals("/")){
            result = firstNumber / secondNumber;
        }
        else{
            System.out.println("Please specify a valid operator within +,-,*,/ and try again.");
        }
        
        
        System.out.println("The result is: " + result);
    }
}

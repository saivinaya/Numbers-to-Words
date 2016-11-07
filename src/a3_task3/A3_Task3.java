/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a3_task3;

import java.util.*;
import java.util.regex.Pattern;
/**
 * This is to take a Dollar amount from the user, split it into long and fraction and call the class to compute
 * the English String equivalent
 * @author VinayaSaiD
 */
public class A3_Task3 {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        // Taking in the dollar amount
        System.out.println("Please enter a dollar amount: ");
        double dollarAmount = input.nextDouble();
        //getting the decimal value
        double decimalPart = 0.0;
        // if the dollarAmount is negative calculating the decimal is different from calculating if it is positive
        if (dollarAmount<0) {
            decimalPart = ((long) (dollarAmount) - dollarAmount);
        }
        else{
            decimalPart = (dollarAmount - (long) (dollarAmount));
        }
        // converting decimal value into 2 digit as we are only bothered upto 2 decimal places as we use cents
        int dollarDecimal = (int)(decimalPart * 100);
        // creating an instance of getWordsFromNumbers class
        getWordsFromNumbers covertAmounttoWords = new getWordsFromNumbers();
        // calling the convertAmount method in getWordsFromNumbers class using covertAmounttoWords instance
        String amountWords = covertAmounttoWords.convertAmount((long) dollarAmount);
        //  including decimal if it is present
        if (dollarDecimal!=0){
        System.out.println("Dollar amount in words: " +amountWords +" and " + dollarDecimal + "/100");
        }
        //if not present, not including it
        else{ if (dollarDecimal== 0){ 
                    System.out.println("Dollar amount in words: " +amountWords);
            }
        }
    }
}




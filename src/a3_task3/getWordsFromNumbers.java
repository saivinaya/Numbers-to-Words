/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a3_task3;

/**
 * This is to convert the given Dollar Amount to the respective word in English, 
 * convertAmount() is to convert the entire number by breaking it into parts
 * @author VinayaSaiD
 */
public class getWordsFromNumbers{
    // after thousand the numbers follow cartain pattern in multiples of 1000 , so storing it as one of the arrays
    private static String[] specialdigitNames = { "", " THOUSAND", " MILLION", " BILLION", " TRILLION" };
    // so the numbers after 20 have thier tens in their names
    private static String[] tensdigitNames = { "", " TEN", " TWENTY", " THIRTY", " FORTY", " FIFTY", " SIXTY", " SEVENTY", " EIGHTY", " NINETY" };
    // one to 19 are unique in their wording, so this is saved as another array
    private static String[] numNames = { "", " ONE", " TWO", " THREE", " FOUR", " FIVE",
        " SIX", " SEVEN", " EIGHT", " NINE", " TEN",
        " ELEVEN", " TWELVE", " THIRTEEN", " FOURTEEN", " FIFTEEN",
        " SIXTEEN", " SEVENTEEN", " EIGHTEEN", " NINETEEN" };
    
    //changeUptoThousand() converts numbers less than 1000, this is not included in doc as it is private class
    private String changeUptoThousand(int number) {
        // output in words
        String inWords;
        // last 2 digits can be between 0 to 19 only
        if (number % 100 < 20){
            inWords = numNames[number % 100];
            number /= 100;
        }
        else {
            // right most digit into word
            inWords = numNames[number % 10];
            //remove the right digit and remain the next 2 numbers
            number /= 10;
            
            // now right most digit in the left out 2 digits
            inWords = tensdigitNames[number % 10] + inWords;
            // remove the right digit and now only one digit left
            number /= 10;
        }
        if (number == 0) return inWords;
        // the last digit left is hundreds and select the name from 0 to 20
        return numNames[number] + " HUNDRED" + inWords;
    }
    
    public String convertAmount(long num) {
        // for getting the sign of the amount
        String sign = "";
        if (num == 0){
            return "zero"; 
        }
        else if (num < 0) {
            // if number negative, making it as positive number and saving the sign in the variable
            num = -num;
            sign = "Negative";
        }
        
        String inWords = "";
        int place = 0;
        
        // do this for every set of 3 digits from right till your left with northing
        do {
            // get the right most 3 numbers 
            long n = num % 1000;
            // check if it not 0
            if (n != 0){
                // call the changeUptoThousand for the 3 digit number
                String s = changeUptoThousand((int) n);
                // add the appropriate word from thousand 
                inWords = s + specialdigitNames[place] + inWords;
            }
            place++;
            //change the number leaving the right most 3 digits whic are processed above
            num /= 1000;
        } 
        while (num > 0);
        // add the sign and the number
        return (sign + inWords).trim();
    }
}  

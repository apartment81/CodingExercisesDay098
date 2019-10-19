package com.example.mirodone.clockwords;

public class NumberToWords {

    /*
    private static final String[] tensNames = {
           "",
           "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };

    private static final String[] numsNames = {
            "",
            "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen" ,"seventeen", "eighteen", "nineteen"
    };
*/



    private static final String[] tensNames = {
            "",
            "zece", "douazeci", "treizeci", "partuzeci", "cincizeci", "saizeci", "saptezeci", "optzeci", "nouazeci"
    };

    private static final String[] numsNames = {
            "",
            "unu", "doi", "trei", "patru", "cinci", "sase", "sapte", "opt", "noua", "zece",
            "unsprezece", "doisprezece", "treisprezece", "paisprezece", "cincisprezece", "saisprezece" ,"saptesprezece", "optsprezece", "nouasprezece"
    };



    public static String convert( int number) {

        if (number == 0) {
            return "o'clock";
        }

        String soFar;

        if( number % 100 < 20){
            soFar = numsNames[number % 100];
            number/= 100;
        }else {
            soFar = numsNames[number % 10];
            number/= 10;

            soFar = tensNames[number % 10] + "si" + soFar;
            number /=10;
        }

        if (number == 0) {
            return soFar.toUpperCase().trim();
        }

        return soFar.trim();

    }

}

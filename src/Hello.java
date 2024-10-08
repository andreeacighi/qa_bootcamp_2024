import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {

        int myFirstVariable = 100;
        int mySecondVariable = 0;
        final int MAX_SIZE = 10;
        final double PI = Math.PI;

        System.out.println("Hello world!");
        System.out.println("Second variable value is: " + mySecondVariable);

        myFirstVariable = MAX_SIZE +1;
        System.out.println(args[0]+args[1]);
        int operandLeft = Integer.parseInt(args[0]);
        int operandRight = Integer.parseInt(args[1]);
        System.out.println(operandLeft + operandRight);

        String currentDate = "Monday";
        switch (currentDate){
            case "Monday": {
                System.out.println("Noo Monday !!");
                break;
            }
            case "Friday":{
                System.out.println("Yeey Friday");
                break;
            }
            default:{
                System.out.println("meeh");
            }
        }

        int currentNumber = 1;
        while(currentNumber<= MAX_SIZE){
            System.out.println("Current number is " + currentNumber);
            currentNumber ++;
        }
        currentNumber = 1;
        do{
            System.out.println("Current number is " + currentNumber);
            currentNumber ++;
        }while (currentNumber <= MAX_SIZE);

        for (int i = 1; i <= MAX_SIZE ; i++) {
            System.out.println("Current size is " + i);
        }

        for (String arg: args){
            System.out.println(arg); //ca un foreach, parcurge lista si afiseaza ce avem in ea
        }

// Exercise Prime Numbers
        /*
        for (int i = 2; i <=1000000 ; i++) {
            boolean isPrime = true;
            for(int j = 2; j<=i/2;j++){
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime == true){
                System.out.println("Prime numbers are: " + i);
            }
        }
        */

        // Homework Numbers of days in month February from a year between 1900-2016 that is read from keyboard
        int number = Integer.parseInt(args[2]);
        if(number>=1900 && number<=2016){ // verificam daca anul se gaseste intre parametrii dati
            if ((number % 4 == 0 && number % 100 != 0) || !(number % 100 == 0 && number % 400 != 0) ){
                System.out.println("Is a leap year so February has 29 days");
            }else {
                System.out.println("Is not a leap year so February only has 28 days");
            }
        }else {
            System.out.println("The number is not in the range.Choose another one");
        }
    }

}
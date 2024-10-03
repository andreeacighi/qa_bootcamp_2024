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

    }

}

import java.util.stream.IntStream;

public class JavaMethods {
    public static void main(String[] args) {

       /* System.out.println("Hello 2!");

        float myFloat = myFirstMethod(50,70);
        System.out.println(myFloat);
        System.out.println("Number is odd? " + isOddNumber(5));
        printMessage(100);

        drawFullShape(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        drawShapeOutline(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        drawShapeCorners(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        */
        // Overloading
        /*
        addNumbers(1, 100);
        addNumbers(500f, 600f);
        addNumbers(105.6, 88.45);
        */
        drawFullShape(Integer.parseInt(args[0]));
        drawShapeOutline(Integer.parseInt(args[0]));
        drawShapeCorners(Integer.parseInt(args[0]));

    }

    private static void addNumbers(double v, double v1) {
        System.out.println("adding 2 double numbers with sum " + (v + v1));
    }
    private static void addNumbers(int v, int v1) {
        System.out.println("adding 2 int numbers with sum " + (v + v1));
    }
    private static void addNumbers(float v, float v1) {
        System.out.println("adding 2 float numbers with sum " + (v + v1));
    }
    // Create overload methods for the shapes drawing methods. The
    //overloaded methods should always draw squares, thus taking only one
    //parameter
    public static void drawFullShape(int length) {
        System.out.println("1");
        drawFullShape(length,length);
    }
    private static void drawShapeCorners(int length) {
        System.out.println("3");
        drawShapeCorners(length,length);
    }

    public static void drawShapeOutline(int length) {
        System.out.println("2");
        drawShapeOutline(length,length);
    }

    public static void drawFullShape(int width, int height) {
        System.out.println("Exercise 1");
        for(int i=0;i< height;i++){
            for (int j = 0; j< width;j++ ){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    private static void drawShapeCorners(int height, int width) {
        System.out.println("Exercise 3");
        for(int i=0;i< height;i++){
            for (int j = 0; j< width;j++ ){
                System.out.print(
                        (i ==0 && j==0) ||
                                (i == height-1 && j==0) ||
                                (j==width-1 && i==0) ||
                                (j==width-1 && i==height-1)? "*" : " ");
            }
            System.out.println();
        }
    }

    private static void drawShapeOutline(int height, int width) {
        System.out.println("Exercise 2");
        for(int i=0;i< height;i++){
            for (int j = 0; j< width;j++ ){
                    System.out.print((i ==0 || i == height-1 || j==0 || j==width-1)? "*" : " ");
            }
            System.out.println();
        }
    }

    public static float myFirstMethod(float input1, float input2) {

        return input1 + input2;
    }

    public static boolean isOddNumber(int number){
        boolean b = number % 2 != 0;
        return b;
    }

    public static void printMessage(int number){
        /*
        if (isOddNumber(number)){
            System.out.println("Number " + number + " is odd !");
        }else {
            System.out.println("Number " + number + " is even !");
        }
        */
        // sau
        /*
        String type = isOddNumber(number)? "odd" : "even";
        System.out.println("Number " + number + " is " + type + "!");
        */
        //sau
        System.out.println("Number " + number + " is " + (isOddNumber(number)? "odd" : "even") + "!");
    }


}

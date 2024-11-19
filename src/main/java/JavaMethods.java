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
       // drawFullShape(Integer.parseInt(args[0]));
        //drawShapeOutline(Integer.parseInt(args[0]));
        //drawShapeCorners(Integer.parseInt(args[0]));

        Shape myShape = new Shape();
        myShape.draw();
        myShape.erase();
        myShape.setColor("green");
        System.out.println("The shape has color: " +  myShape.getColor());

        Rectangle myRectangle = new Rectangle(4,5);
        myRectangle.draw();

        Square mySquare = new Square(12);
        mySquare.draw();

        System.out.println("Length " + mySquare.getLength());
        System.out.println("Diagonal is " + mySquare.getDiagonal());
        System.out.println("Perimeter is " + mySquare.getPerimeter());

        Shape myShape1 = new Square();
        Shape myShape2 = new Triangle();
        Shape myShape3 = new Rectangle();
        Shape myShape4 = new Circle();

        myShape1.draw(); // din square
        myShape2.draw();
        myShape3.draw();
        myShape4.draw();

        System.out.println();

        Person teacher1 = new Teacher("UPB");
        teacher1.setName("Alex");
        teacher1.setSurname("G");
        teacher1.eat();
        ((Teacher)teacher1).teachCourse(); // cast - sa putem apela metoda; sa i zicem ca e de tipul teacher

        Person student1 = new Student();
        student1.setName("Andrei");
        student1.setSurname("Pop");
        student1.eat();

        if (student1.getName() == null){
            throw new IllegalArgumentException(" No name for the student");
        }
        try {
            myExceptionMethod();
        }catch (IllegalThreadStateException ex){
            System.out.println("Ooops an exception " + ex.getMessage());
        }catch (IllegalArgumentException | MyException ex){
            System.out.println(ex.getMessage());
        }catch (Exception ex){
            System.out.println("Generic exception");
        }

        try {
            int argument = Integer.parseInt(args[0]);
        }catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("No params provided");
        }catch (NumberFormatException ex){
            System.out.println("Argument is not integer");
        }catch (Exception ex){
            System.out.println("Generic exception");
        }finally {
            System.out.println("This line will always execute ");
        }


    }
    public static void myExceptionMethod() throws MyException { // exceptie stack trace
        Student s1 = new Student();

        if (s1.getName() == null){
           // throw new IllegalArgumentException("Exception: No name for the student");
            throw new MyException("Exception: No name for the student");
        }
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

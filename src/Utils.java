public class Utils {

    public static void printSquare(Square sq){
        System.out.println("Static method");
        System.out.println("Square with side " + sq.getLength() + " has area of " + sq.getArea());
    }
}

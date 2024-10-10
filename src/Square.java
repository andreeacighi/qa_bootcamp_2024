import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

 @NoArgsConstructor @AllArgsConstructor
public class Square {
     @Getter @Setter
    private double squareSide;
     private static int i =0;

     public void setSide(double side){
        squareSide = side;
    }

    public double getArea(){
        return squareSide*squareSide;
        //return Math.pow(squareSide,2);
    }
    public void printCurrentSquare(){
        System.out.println("-----------------------------------------");
        System.out.println("Square with side " + squareSide + " has area of " + getArea());
    }

}

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

 @NoArgsConstructor
public class Square extends Rectangle{
     //private static int i =0;

     public  Square(double side){
         super(side,side);
     }
    @Override
    public double getArea(){
        return super.getArea();
        //return Math.pow(squareSide,2);
    }
    public void printCurrentSquare(){
        System.out.println("-----------------------------------------");
        System.out.println("Square with side " + getLength() + " has area of " + getArea());
    }

     @Override
     public void draw() {
         System.out.println("Drawing a square !");
     }
    @Override
     public String toString(){
        return "My square has 4 sides each" +this.getLength();
     }

     public void setSide(double i) {
         super.setLength(i);
         super.setWidth(i);

     }
 }

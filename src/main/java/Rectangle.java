import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor
public class Rectangle extends Shape {
    @Getter @Setter
    private double length;
    @Getter @Setter
    private double width;


    public double getArea(){
        return this.length + this.width;
    }
    public double getDiagonal(){
        return Math.sqrt(Math.pow(length,2)+Math.pow(width,2));
    }
    public double getPerimeter(){
        return 2 * (length+width);
    }

    @Override
    public void draw() {
        //super.draw(); // this calls the method from the superclass
        System.out.println("Drawing a rectangle !");
    }
}

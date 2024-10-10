public class Rectangle {
    public double length;
    public double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getArea(){
        return this.length + this.width;
    }
    public double getDiagonal(){
        return Math.sqrt(Math.pow(length,2)+Math.pow(width,2));
    }
    public double getPerimeter(){
        return 2 * (length+width);
    }
}

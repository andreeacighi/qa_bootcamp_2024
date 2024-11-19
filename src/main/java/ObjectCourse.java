

public class ObjectCourse {
    public static void main(String[] args) {
        //Car dacia1300 = new Car(); //instantiem o variabila de tipul Car
        Car vwPassat = new Car();

       // dacia1300.printCar();

        Car dacia1300 = new Car("Sedan","RED","dacia 1300",1300,45);
        /*
        dacia1300.color = "RED";
        dacia1300.carType = "Sedan";
        dacia1300.cylinderCapacity = 1300;
        dacia1300.model = "Dacia 1300";
        dacia1300.carPosition = 45;
        */
        dacia1300.startCar();
        dacia1300.accelerate(20);
        dacia1300.gearUp();
        dacia1300.steerRight(45);
        dacia1300.increaseMileage(5);
        dacia1300.stopCar();

        dacia1300.printCar();

        // Encapsulation
        dacia1300.setSpeed(5000);
        System.out.println( dacia1300.getSpeed());


        Square square = new Square();
        square.setSide(5);
        square.printCurrentSquare();

        for (String value : args){
            Square cmdSquare = new Square();
            cmdSquare.setSide(Double.parseDouble(value));
            //cmdSquare.printCurrentSquare();
            Utils.printSquare(cmdSquare); // static method
        }

        Rectangle rectangle = new Rectangle(5,10);
        System.out.println("Area is: " + rectangle.getArea() + " , Diagonal is: " +
                rectangle.getDiagonal() + " , Perimeter is: "+ rectangle.getPerimeter());
    }
}

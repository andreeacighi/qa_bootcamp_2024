package Others;

import org.junit.jupiter.api.*;

import java.text.DecimalFormat;
import Calculator.*;

public class CalculatorTests {

    Calculator c ;
    final String subtractionFailMessage ="Subtracting failed.";
    final String divisionFailMessage="Division failed.";
    final String sqrtFailMessage="Sqrt failed.";
    final String multiplicationFailMessage="Sqrt failed.";
    @BeforeAll
    public static void classSetup(){
        System.out.println("Preparing all the tests from the class");
    }
    @BeforeEach //se pune la inceput de teste si before all inainte de before each
    public void testSetup(){
        System.out.println("The method runs before each test!");
        c = new Calculator();
    }
    //teste valide - pozitive
    @Test
    public void TestAddition01(){
       double result = c.compute(3,4,"+");
       Assertions.assertEquals(7,result,"Addition fail");
    }

    @Test
    public void TestAddition02(){
        Assertions.assertEquals(14.5,c.compute(10,4.5,"+"),"Addition fail");
    }

    // teste invalide cu exceptie
    @Test
    public void testInvalidOperator(){

       IllegalArgumentException ex = Assertions.assertThrows(IllegalArgumentException.class,() ->
       {
           c.compute(5, 7, "ABC");
       }, "Operator not valid");
    }
    @Test
    public void testDivisionByZero(){
        IllegalArgumentException ex = Assertions.assertThrows(IllegalArgumentException.class,() ->
        {
            c.compute(5, 0, "/");
        }, "Operator not valid");
    }

    @Test
    public void testSubtraction01(){
        Assertions.assertEquals(10,c.compute(5,-5,"-"),"Subtraction failed");
    }

    @Test
    public void testMultiplication01(){
        Assertions.assertEquals(14,c.compute(7,2,"*"),"Multiplication failed!");
    }

    @Test
    public void testSquareRoot01(){
        Assertions.assertEquals(8,c.compute(64,0,"SQRT"),"SquareRoot failed!");
    }
    @Test
    public void testSquareRoot02(){
        Assertions.assertEquals(Math.sqrt(2),c.compute(2,0,"SQRT"),"SquareRoot failed!");
    }

    // Homework 4
    @Test
    public void testSubtraction02(){
        Assertions.assertEquals(10,c.compute(5,-5,"-"),subtractionFailMessage);
    }
    @Test
    public void testSubtraction03(){
        Assertions.assertEquals(0,c.compute(5,5,"-"),subtractionFailMessage);
    }
    @Test
    public void testSubtraction04(){
        Assertions.assertEquals(20,c.compute(15,-5,"-"),subtractionFailMessage);
    }
    @Test
    public void testSubtraction05(){
        Assertions.assertEquals(70,c.compute(85,15,"-"),subtractionFailMessage);
    }

    @Test
    public void testMultiplication02(){
        Assertions.assertEquals(140,c.compute(70,2,"*"),multiplicationFailMessage);
    }
    @Test
    public void testMultiplication03(){
        Assertions.assertEquals(90,c.compute(45,2,"*"),multiplicationFailMessage);
    }
    @Test
    public void testMultiplication04(){
        Assertions.assertEquals(6.6,c.compute(3.3,2,"*"),multiplicationFailMessage);
    }
    @Test
    public void testMultiplication05(){
        Assertions.assertEquals(56,c.compute(7,8,"*"),multiplicationFailMessage);
    }

    @Test
    public void testSquareRoot04(){
        Assertions.assertEquals(10,c.compute(100,0,"SQRT"),sqrtFailMessage);
    }
    @Test
    public void testSquareRoot05(){
        Assertions.assertEquals(15,c.compute(225,0,"SQRT"),sqrtFailMessage);
    }
    @Test
    public void testSquareRoot06(){
        Assertions.assertEquals(3,c.compute(9,0,"SQRT"),sqrtFailMessage);
    }
    @Test
    public void testSquareRoot03(){
        Assertions.assertEquals(10,c.compute(100,0,"SQRT"),sqrtFailMessage);
    }
    @Test
    public void testDivision01(){
        Assertions.assertEquals(4,c.compute(16,4,"/"),divisionFailMessage);
    }

    @Test
    public void testDivision02(){
        Assertions.assertEquals(15,c.compute(45,3,"/"),divisionFailMessage);
    }
    @Test
    public void testDivision03(){
        Assertions.assertEquals(2,c.compute(40,20,"/"),divisionFailMessage);
    }
    @Test
    public void testDivision04(){
        Assertions.assertEquals(1.5,c.compute(4.5,3,"/"),divisionFailMessage);
    }


    @AfterEach
    public void cleanTest(){
        System.out.println("Clean after the test!");
    }

    @AfterAll
    public static void cleanClass(){
        System.out.println("Cleanup at the end ");
    }
}

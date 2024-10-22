import org.junit.jupiter.api.*;

import java.text.DecimalFormat;

public class CalculatorTests {

    Calculator c ;
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
    @AfterEach
    public void cleanTest(){
        System.out.println("Clean after the test!");
    }

    @AfterAll
    public static void cleanClass(){
        System.out.println("Cleanup at the end ");
    }
}

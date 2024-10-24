import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CalculatorNgTests {
    Calculator c;
    final String additionFailMessage="Addition failed.";
    ExtentReports extent= new ExtentReports();
    ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/report.html");

    ITestContext testContext;

    //data provider cu array - ne oop
    @DataProvider
    public Object[][] calculatorDataProviderClassic(){
        return new Object[][]{
                {100,20,80,"+",additionFailMessage},
                {1000,555,445,"+",additionFailMessage},
                {1,1,0,"+",additionFailMessage}
        };
    }

    // data provider cu collection - OOP
    @DataProvider
    public Iterator<Object[]>calculatorDataProvider(){
        Collection<Object[] > dp = new ArrayList<>();
        dp.add(new Object[]{100,20,80,"+",additionFailMessage});
        dp.add(new Object[]{1000,555,445,"+",additionFailMessage});
        dp.add(new Object[]{1,1,0,"+",additionFailMessage});
        return dp.iterator();
    }

    private void setUpGeneric(){
        c = new Calculator();
        extent.attachReporter(sparkReporter);

    }
    @BeforeSuite
    public void setUpSuite(){
        setUpGeneric();
    }
    @BeforeClass
    public void setUpClass(){

    }
    @BeforeMethod
    public void setUp(){

    }
    @BeforeGroups(groups = {"addition","calculator"})
    public void setUpGroups(){

    }
    @BeforeTest
    private void setUpTest(final ITestContext testContext){

        this.testContext = testContext;
    }

    @Test(testName = "AdditionPositive",groups = {"addition","calculator"})
    public void test01(Method method){
        System.out.println(new Object(){}.getClass().getEnclosingMethod().getName()); //java reflexion - get name of the current method
        ExtentTest myTest = extent.createTest(new Object(){}.getClass().getEnclosingMethod().getName());
        //ExtentTest myTest = extent.createTest(method.getName());
        Assert.assertEquals(37,c.compute(24,13,"+"),"Addition failed");
        myTest.log(Status.PASS,"test finished");

    }

    @Test(testName = "AdditionNegatives",groups = {"addition","calculator"})
    public void test02(){
        System.out.println("AdditionNegatives");
        ExtentTest myTest = extent.createTest("AdditionNegatives");
        Assert.assertEquals(-23,c.compute(-11,-12,"+"),"Addition failed");
        myTest.log(Status.PASS,"test finished");
        myTest.pass("finished");
    }
    @Test(testName = "AdditionParameters",groups = {"addition","calculator"})
    @Parameters({"exp","d1","d2","op","errMess"})
    public void test03(String exp,String d1,String d2,String op, String errMess){
        ExtentTest myTest = extent.createTest(new Object(){}.getClass().getEnclosingMethod().getName());
        Assert.assertEquals(Double.parseDouble(exp),c.compute(Double.parseDouble(d1),Double.parseDouble(d2),op),errMess);
        myTest.pass("finished");
    }

    @Test(testName = "AdditionDataProviderClassic",groups = {"addition","calculator"},dataProvider = "calculatorDataProviderClassic")
    public void test04(double exp,double d1,double d2,String op,String message){
        ExtentTest myTest = extent.createTest(new Object(){}.getClass().getEnclosingMethod().getName());
        Assert.assertEquals(exp,c.compute(d1,d2,op),message);
        myTest.pass("finished");
    }
    @Test(testName = "AdditionDataProvider",groups = {"addition","calculator"},dataProvider = "calculatorDataProvider")
    public void test05(double exp,double d1,double d2,String op,String message){
        ExtentTest myTest = extent.createTest(new Object(){}.getClass().getEnclosingMethod().getName());
        Assert.assertEquals(exp,c.compute(d1,d2,op),message);
        myTest.pass("finished");
    }

    private void cleanUpGeneric(){
        extent.flush();
    }
    @AfterSuite
    public  void afterSuite(){
        cleanUpGeneric();
    }
    @AfterClass
    public void afterClass(){
        cleanUpGeneric();
    }
    @AfterGroups(groups = {"addition","calculator"})
    public void afterGroups(){
        cleanUpGeneric();
    }
}

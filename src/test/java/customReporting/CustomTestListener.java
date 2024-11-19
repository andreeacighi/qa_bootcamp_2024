package customReporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.*;

import java.time.Instant;

public class CustomTestListener extends TestListenerAdapter {
    ExtentReports extent = new ExtentReports();
    @Override
    public void onStart(ITestContext context){
        long unixTimestamp = Instant.now().getEpochSecond();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/report"+unixTimestamp+".html");
        extent.attachReporter(sparkReporter);
    }
    @Override
    public void onFinish(ITestContext context){
        extent.flush();
    }
    @Override
    public void onTestStart(ITestResult result){
        String testMethodName = result.getMethod().getMethodName(); // test name
        String testDescription = result.getMethod().getDescription(); // test description
        System.out.println("Start Test: " + testMethodName);
        ExtentTest myTest = extent.createTest(testMethodName);
        myTest.log(Status.INFO,"Test started: " + testMethodName);
        myTest.log(Status.INFO,"Test description: " + testDescription);

    }
    @Override
    public void onTestSuccess(ITestResult result){
        ExtentTest myTest = extent.createTest(result.getMethod().getMethodName());
        myTest.pass("Test passed.");

    }
    @Override
    public void onTestFailure(ITestResult result){
        ExtentTest myTest = extent.createTest(result.getMethod().getMethodName());
        myTest.fail("Test failed.");

    }
}

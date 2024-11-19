package Homework5.tests;

import juiceShop.frameworkUtils.Utils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected static final String baseUrl = Utils.getConfigProperty("baseUrl2");

    protected WebDriver driver;

    @BeforeMethod
    public void initBrowser(){

        // OLD version !! Do not use unless the server you are testing does not have internet
        // System.property("webdriver.chrome.driver", "C:\\Users\myuser\Download\chromedriver.exe");
        driver = Utils.getDriver();

    }

    @AfterMethod
    public void closeBrowser(){
        try {
            driver.close();
        }catch (Exception ex){
            driver.quit();
        }
    }
}

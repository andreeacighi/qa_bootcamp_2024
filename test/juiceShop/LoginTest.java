package juiceShop;

import frameworkUtils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {
    static final String baseUrl = "http://57.151.123.81:3000";

    WebDriver driver;

    @BeforeMethod
    public void initDriver(){

        // OLD version !! Do not use unless the server you are testing does not have internet
        // System.property("webdriver.chrome.driver", "C:\\Users\myuser\Download\chromedriver.exe");
        driver = Utils.getDriver();

    }

    @Test
    public void mainPage(){

        // OLD version !! Do not use unless the server you are testing does not have internet
        // System.property("webdriver.chrome.driver", "C:\\Users\myuser\Download\chromedriver.exe");
        driver.get(baseUrl + "/#/");
    }

    @Test
    public void login01() throws InterruptedException {

        //test de componenta
        driver.get(baseUrl + "/#/login"); //testam loginul in izolare, adica mergem direct pe pagina de login
        //test end to end - mergem de pe pargina principala, click pe account si dupa pe login


        // Definesc durata de așteptare (de exemplu, 10 secunde)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Așteaptă până când elementul este vizibil și apoi fă click pe el
        WebElement dismissModalElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#mat-dialog-0 > app-welcome-banner > div > div:nth-child(3) > button.mat-focus-indicator.close-dialog.mat-raised-button.mat-button-base.mat-primary.ng-star-inserted")));
        dismissModalElement.click();

        WebElement loginElement = driver.findElement(By.id("email"));
        loginElement.sendKeys("alex@alex.com");

        WebElement passwordElement = driver.findElement(By.id("password"));
        passwordElement.sendKeys("Abc123$");

        WebElement submitButton = driver.findElement(By.id("loginButton"));
        submitButton.click();


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

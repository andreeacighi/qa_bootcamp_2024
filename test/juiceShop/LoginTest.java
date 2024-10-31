package juiceShop;

import frameworkUtils.Selectors;
import frameworkUtils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class LoginTest {
    static final String baseUrl = Utils.getConfigProperty("baseUrl");

    WebDriver driver;

    @BeforeMethod
    public void initBrowser(){

        // OLD version !! Do not use unless the server you are testing does not have internet
        // System.property("webdriver.chrome.driver", "C:\\Users\myuser\Download\chromedriver.exe");
        driver = Utils.getDriver();

    }

    @Test
    public void mainPage(){

        // OLD version !! Do not use unless the server you are testing does not have internet
        // System.property("webdriver.chrome.driver", "C:\\Users\myuser\Download\chromedriver.exe");
        driver.get(baseUrl + "/#/");
        WebElement pageText = driver.findElement(By.cssSelector(Selectors.ALL_PRODUCTS_SELECTOR));
        Assert.assertEquals(pageText.getText(),"All Products");
    }
    @DataProvider(name = "RegistrationDataProvider")
    public Iterator<Object[]> registerDp (){
        Collection<Object[]> dp = new ArrayList<>();
        dp.add(new String[] {"alex@alex.com","alexrtete","alex"});
        return dp.iterator();
    }



    @Test
    public void login01() throws InterruptedException {

        //test de componenta
        driver.get(baseUrl + "/#/login"); //testam loginul in izolare, adica mergem direct pe pagina de login
        //test end to end - mergem de pe pargina principala, click pe account si dupa pe login

        /* 1. metoda
        // Definesc durata de așteptare (de exemplu, 10 secunde)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Așteaptă până când elementul este vizibil și apoi fă click pe el
        WebElement dismissModalElement = wait.until(
                ExpectedConditions.elementToBeClickable
                (By.cssSelector("#mat-dialog-0 > app-welcome-banner > " +
                        "div > div:nth-child(3) > button.mat-focus-indicator.close-dialog.mat-raised-button." +
                        "mat-button-base.mat-primary.ng-star-inserted")));

         */
        // 2. Metoda
        WebElement dismissModalElement = Utils.waitForElement(driver, 5,
                By.cssSelector(Selectors.MODAL_OK_BUTTON));
        dismissModalElement.click();

       /* FluentWait wait = new FluentWait<>(driver);
        try {
            wait.wait(5000);
        }catch (InterruptedException e){
            throw new  RuntimeException(e);
        }
        wait.until(ExpectedConditions.presenceOfElementLocated());*/

        WebElement loginElement = driver.findElement(By.id(Selectors.USERNAME_ID));
        loginElement.sendKeys("alex@alex.com");

        WebElement passwordElement = driver.findElement(By.id(Selectors.PASSWORD_ID));
        passwordElement.sendKeys("Abc123$");

        WebElement submitButton = driver.findElement(By.id(Selectors.SUBMIT_ID));
        submitButton.click();
        // nu e recomandat
        /*
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

         */

    }
    @Test(dataProvider = "RegistrationDataProvider")
    public void loginRegister(String username, String password, String securityAns){
        driver.get(baseUrl + "/#/login");
       WebElement dismissModalElement = Utils.waitForElement(driver, 5,
               By.cssSelector(Selectors.MODAL_OK_BUTTON));
       dismissModalElement.click();
        WebElement registerLink = driver.findElement(By.cssSelector(Selectors.REGISTER_URL));
        registerLink.click();

        Assert.assertEquals(
                driver.findElement(By.cssSelector(Selectors.REGISTER_HEADER)).getText(),
                "User Registration");

        WebElement usernameElement = driver.findElement(By.id(Selectors.REGISTER_EMAIL));
        usernameElement.clear();
        usernameElement.sendKeys("alex@alex.com");

       WebElement passwordElement = driver.findElement(By.id(Selectors.REGISTER_PASSWORD));
       passwordElement.clear();
       passwordElement.sendKeys("Abc123$");

       WebElement passwordRepeat = driver.findElement(By.id(Selectors.REGISTER_CONFIRM));
       passwordRepeat.clear();
       passwordRepeat.sendKeys("Abc123$");

       WebElement securityQuestion = Utils.waitForElement(driver, 5,
               By.cssSelector(Selectors.SECURITY_QUESTION));
       securityQuestion.click();

       WebElement securityQuestionChoice = driver.findElement(By.cssSelector(Selectors.SECURITY_QUESTION1));
       securityQuestionChoice.click();

       WebElement securityAnswer = driver.findElement(By.id(Selectors.SECURITY_ANSWER));
       securityAnswer.clear();
       securityAnswer.sendKeys("alex");

       WebElement submitButton = driver.findElement(By.id(Selectors.REGISTER_SUBMIT_BUTTON));
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

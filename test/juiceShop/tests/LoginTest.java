package juiceShop.tests;

import juiceShop.frameworkUtils.Selectors;
import juiceShop.frameworkUtils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import juiceShop.pages.LoginPage;
import juiceShop.pages.LoginPagePF;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class LoginTest extends BaseTest{




    @DataProvider(name = "RegistrationDataProvider")
    public Iterator<Object[]> registerDp (){
        Collection<Object[]> dp = new ArrayList<>();
        dp.add(new String[] {"alex@alex.com","alexrtete","alex"});
        return dp.iterator();
    }
    /*
    @Test(dataProvider = "RegistrationDataProvider")
    public void loginRegisterHomework(String username, String password, String securityAns){
        driver.get(baseUrl + "/#/");
    }

     */

   @Test
    public void loginRegister(){
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
        //asteapta pana dispare elementul ce suprapune butonul
        if (Utils.waitToDisappear(driver,5,By.id(Selectors.COOKIES_MODAL)))
        submitButton.click();
    }
/*
    @Test
    public void login01()  {

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
    /*
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
    /*

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



    }

         */
    @Test
    public void login01(){
        driver.get(baseUrl + "/#/login");
        LoginPage lp = new LoginPage(driver);
        lp.waitDismissModal();
        lp.login("alex@alex.com","Qwert123$");
    }

    @Test
    public void login02(){
        driver.get(baseUrl + "/#/login");
        LoginPagePF lp = new LoginPagePF(driver);
        lp.dismissModal();
        // Best practice isa to have the Asserts in tests
        Assert.assertEquals(lp.getLoginText(),lp.getStaticLogicText());
        lp.login("alex@alex.com","Qwert123$");
    }





}

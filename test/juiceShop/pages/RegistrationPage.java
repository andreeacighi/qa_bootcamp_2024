package juiceShop.pages;
import jdk.jshell.execution.Util;
import juiceShop.frameworkUtils.Selectors;
import juiceShop.frameworkUtils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage extends BasePage {

    public static final String REGISTER_HEADER = "body > app-root > div > mat-sidenav-container > mat-sidenav-content > app-register > div > mat-card > h1";
    public static final String REGISTER_EMAIL = "emailControl";
    public static final String REGISTER_PASSWORD = "passwordControl";
    public static final String REGISTER_CONFIRM = "repeatPasswordControl";
    public static final String SECURITY_QUESTION01 = "#mat-select-0 > div"; //CSS selector
    public static final String SECURITY_QUESTION02 = "securityQuestion"; // By name
    public static final String SECURITY_QUESTION1 = "#mat-option-0 > span";
    public static final String SECURITY_ANSWER = "securityAnswerControl";
    public static final String REGISTER_SUBMIT_BUTTON = "registerButton";
    private static final String COOKIES_MODAL = "cdk-overlay-0";
    //private static final String COOKIES_MODAL2 ="body > div.cc-window.cc-floating.cc-type-info.cc-theme-classic.cc-bottom.cc-right.cc-color-override--1225450786 > div > a";

    private static final String REGISTER_STATIC_TEXT = "User Registration";

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }
    public String getRegisterHeader(){
        return driver.findElement(By.cssSelector(REGISTER_HEADER)).getText();
    }
    public String getRegisterPageStatic(){
        return REGISTER_STATIC_TEXT;
    }
    public void register(String email ,String password, String securityAnswer ){
        WebElement emailField = driver.findElement(By.id(REGISTER_EMAIL));
        WebElement passwordField = driver.findElement(By.id(REGISTER_PASSWORD));
        WebElement passwordConfirm = driver.findElement(By.id(REGISTER_CONFIRM));

        emailField.clear();
        emailField.sendKeys(email);
        passwordField.clear();
        passwordField.sendKeys(password);
        passwordConfirm.clear();
        passwordConfirm.sendKeys(password);

        WebElement securityQuestionDropDown = Utils.waitForElement(driver,10,By.name(SECURITY_QUESTION02));
        securityQuestionDropDown.click();
        WebElement securityQ1 = driver.findElement(By.cssSelector(SECURITY_QUESTION1));
        securityQ1.click();

        WebElement securityAnswerField = driver.findElement(By.id(SECURITY_ANSWER));
        securityAnswerField.clear();
        securityAnswerField.sendKeys(securityAnswer);

        //https://www.browserstack.com/guide/selenium-scroll-tutorial
        //Utils.scrollDown(driver); // asta inca nu merge
        Utils.scrollToElement(driver,securityAnswerField);
        WebElement submitButton = driver.findElement(By.id(REGISTER_SUBMIT_BUTTON));
        // asteapta pana dispare elementul ce suprapune butonul
        if (waitToDisappear(driver,5,By.cssSelector(COOKIES_MODAL)))
        submitButton.click();


    }
    public static boolean waitToDisappear(WebDriver driver, long seconds, By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));

    }

}

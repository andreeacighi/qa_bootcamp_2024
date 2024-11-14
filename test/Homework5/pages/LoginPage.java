package Homework5.pages;

import juiceShop.frameworkUtils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    private static final String SIGN_IN_SELECTOR = "#svelte > div.container-fluid > div.main.row > div.content > h1"; //CSS SELECTOR
    private static final String SIGN_IN_STATIC_TEXT = "Sign in";
    private static final String USERNAME = "user"; //ID
    private static final String PASSWORD = "pass";//ID
    private static final String REMEMBER_ME = "remember";//ID // checkbox
    private static final String SIGN_IN_BUTTON = "#svelte > div.container-fluid > div.main.row >" +
            " div.content > div > div > div > form > button"; //CSS SELECTOR

    private static final String WEB_STUBS_SELECTOR = "#svelte > div.container-fluid > div.main.row > " +
            "div.content > h1";
    private static final String WEB_STUBS_TEXT = "Welcome to web-stubs, guest!";

    private static final String ERROR_TEXT_STATIC_USER = "Please enter your username";
    private static final String ERROR_TEXT_STATIC_PASS = "Please enter your password";
    @FindBy(css = WEB_STUBS_SELECTOR)
    WebElement webStubs;

    @FindBy(css = SIGN_IN_SELECTOR)
    WebElement signInSelector;
    @FindBy(id = USERNAME)
    WebElement usernameField;
    @FindBy(id = PASSWORD)
    WebElement passwordField;
    @FindBy(id = REMEMBER_ME)
    WebElement rememberMe;
    @FindBy(css = SIGN_IN_BUTTON)
    WebElement signInButton;


    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public String getWebStubsText(){
        Utils.textToBeInElementLocated(driver,15,By.cssSelector(WEB_STUBS_SELECTOR),WEB_STUBS_TEXT);
        return webStubs.getText();
    }
    public String getWebStubsStaticText(){
        return WEB_STUBS_TEXT;
    }
    public void clearAndSendKeys(WebElement element,String text ){
        element.clear();
        element.sendKeys(text);
    }
    public void login(String username, String password) {
        clearAndSendKeys(usernameField,username);
        clearAndSendKeys(passwordField,password);
        rememberMe.click();
    }

    public void signInButton(){
        signInButton.click();
    }
    public WebElement getSignInSelector(){
        Utils.textToBeInElementLocated(driver,15,By.cssSelector(SIGN_IN_SELECTOR),SIGN_IN_STATIC_TEXT);
        return signInSelector;
    }
    public String getSignInStaticText(){
        return SIGN_IN_STATIC_TEXT;
    }

    public String getErrorTextStaticUser(){
        return ERROR_TEXT_STATIC_USER;
    }
    public String getErrorTextStaticPass(){
        return ERROR_TEXT_STATIC_PASS;
    }


}


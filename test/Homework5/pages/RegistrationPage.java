package Homework5.pages;

import juiceShop.frameworkUtils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage extends BasePage{

    private static final String REGISTER_BUTTON = "#svelte > div.container-fluid > div.main.row > div.content > p:nth-child(3) > div > a"; //CSS
    private static final String SIGN_UP_SELECTOR = "#svelte > div.container-fluid > div.main.row > div.content > h1"; //CSS SELECTOR
    private static final String SIGN_UP_SELECTOR_TEXT = "Sign up";
    private static final String USERNAME = "username"; //ID
    private static final String PASSWORD = "password"; //ID
    private static final String CONFIRM_PASSWORD = "password2"; //ID
    private static final String TITLE_MR = "Mr";//ID
    private static final String TITLE_MS = "Ms"; //ID
    private static final String FIRST_NAME = "input-first-name"; //ID
    private static final String LAST_NAME = "input-last-name"; //ID
    private static final String EMAIL = "input-email"; //ID
    private static final String DATE_OF_BIRTH = "input-dob"; //ID
    private static final String NATIONALITY = "input-nationality"; //ID
    private static final String NATIONALITY_CLICK = "#input-nationality > option:nth-child(144)"; //CSS SELECTOR
    private static final String TERMS = "terms"; //ID
    private static final String SUBMIT_BUTTON = "#svelte > div.container-fluid > div.main.row > div.content > div > div > div > form > div:nth-child(13) > button"; //CSS SELECTOR
    private static final String ERROR_TEXT_STATIC_USER = "Please choose a username";
    private static final String ERROR_TEXT_STATIC_PASS = "Please choose a password";

    Actions actions;
    @FindBy(css = REGISTER_BUTTON)
    WebElement registerButton;
    @FindBy(css = SIGN_UP_SELECTOR)
    WebElement signUpSelector;
    @FindBy(id = USERNAME)
    WebElement usernameField;
    @FindBy(id = PASSWORD)
    WebElement passwordField;
    @FindBy(id = CONFIRM_PASSWORD)
    WebElement confirmPassField;
    @FindBy(id = TITLE_MR)
    WebElement titleMr;
    @FindBy(id = TITLE_MS)
    WebElement titleMs;
    @FindBy(id = FIRST_NAME)
    WebElement firstNameField;
    @FindBy(id = LAST_NAME)
    WebElement lastNameField;
    @FindBy(id = EMAIL)
    WebElement emailField;
    @FindBy(id = DATE_OF_BIRTH)
    WebElement dobField;
    @FindBy(id = NATIONALITY)
    WebElement nationalityField;
    @FindBy(css = NATIONALITY_CLICK)
    WebElement natClick;
    @FindBy(id = TERMS)
    WebElement termsField;
    @FindBy(css = SUBMIT_BUTTON)
    WebElement submitButton;


    public RegistrationPage(WebDriver driver) {
        super(driver);
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }
    public void clearAndSendKeys(WebElement element,String text ){
        element.clear();
        element.sendKeys(text);
    }
    public void clickElement(WebElement element){
        actions.moveToElement(element).perform();
        element.click();
    }
    public void registerButton(){
        clickElement(registerButton);
    }
    public void register(String user,String pass, String confPass,String title,String firstName,String lastName,String email,String date){
        clearAndSendKeys(usernameField,user);
        clearAndSendKeys(passwordField,pass);
        clearAndSendKeys(confirmPassField,confPass);
        sendTitle(title);
        clearAndSendKeys(firstNameField,firstName);
        clearAndSendKeys(lastNameField,lastName);
        clearAndSendKeys(emailField,email);
        sendDob(date);
        setNationality();
        clickElement(termsField);

    }
    public void setSubmitButton(){
        clickElement(submitButton);
    }
    public void sendTitle(String title){
        if (title.equals("Mr")) clickElement(titleMr);
        else if (title.equals("Ms")) clickElement(titleMs);
    }

    public void sendDob(String date){
        clickElement(dobField);
        dobField.sendKeys(date);
    }
    public void setNationality(){
        clickElement(nationalityField);
        natClick.click();
    }
    public String getSignUpSelector(){
        Utils.textToBeInElementLocated(driver,15,By.cssSelector(SIGN_UP_SELECTOR),SIGN_UP_SELECTOR_TEXT);
        return signUpSelector.getText();
    }
    public String getSignUpSelectorText(){
        return SIGN_UP_SELECTOR_TEXT;
    }
    public String getErrorTextStaticUser(){
        return ERROR_TEXT_STATIC_USER;
    }
    public String getErrorTextStaticPass(){
        return ERROR_TEXT_STATIC_PASS;
    }

}
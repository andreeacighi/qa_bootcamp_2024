package juiceShop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPagePF {

    //se poate si cu page factory dar si cu page object modal
    private WebDriver driver;
    private static final String LOGIN_TEXT_SELECTOR = "body > app-root > div > mat-sidenav-container > mat-sidenav-content > app-login > div > mat-card > h1";
    private static final String USERNAME_SELECTOR = "email"; // ID
    private static final String PASSWORD_SELECTOR = "password"; // ID
    private static final String SUBMIT_SELECTOR = "loginButton"; //ID
    private static final String NOT_REGISTER_SELECTOR = "#newCustomerLink > a"; // CSS selector
    private static final String MODAL_SELECTOR = "#mat-dialog-0 > app-welcome-banner > " +
            "div > div:nth-child(3) > button.mat-focus-indicator.close-dialog.mat-raised-button." +
            "mat-button-base.mat-primary.ng-star-inserted"; //CSS Selector
    private static final String LOGIN_TEXT_VALUE = "Login";

    // Partea de initializare a elementelor

    //Selenium 4
    // prima varianta
    @FindBy(css = LOGIN_TEXT_SELECTOR)
    WebElement loginTextHeader;

    // Selenium 3
    // A doua varianta - se pot folosi oricare dintre ele, recomandat e selenium 4
    @FindBy(how = How.CSS,using = LOGIN_TEXT_SELECTOR)
    WebElement loginTextHeader2;

    @FindBy(id = USERNAME_SELECTOR)
    WebElement usernameField;
    @FindBy(id = PASSWORD_SELECTOR)
    WebElement passwordField;
    @FindBy(id = SUBMIT_SELECTOR)
    WebElement submitButton;
    @FindBy(css = NOT_REGISTER_SELECTOR)
    WebElement newUserLink;
    @FindBy(css = MODAL_SELECTOR)
    WebElement modalButton;

    public LoginPagePF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void login(String username, String password){
        Assert.assertEquals(loginTextHeader.getText(), LOGIN_TEXT_VALUE);
        usernameField.clear();
        usernameField.sendKeys(username);
        passwordField.clear();
        passwordField.sendKeys(password);
        submitButton.click();
    }

    public void dismissModal(){
        modalButton.click();
    }

    public void newUser(){
        newUserLink.click();
    }

    public String getLoginText(){
        return loginTextHeader.getText();
    }
    public String getStaticLogicText(){
        return LOGIN_TEXT_VALUE;
    }
}

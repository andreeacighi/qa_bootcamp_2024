package Homework5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage{
    private static final String WEB_STUBS_SELECTOR = "#svelte > div.container-fluid > div.main.row > " +
            "div.content > h1";
    private static final String WEB_STUBS_TEXT = "Welcome to web-stubs, guest!";
    @FindBy(css = WEB_STUBS_SELECTOR)
    WebElement webStubs;
    public String getWebStubsText(){
        return webStubs.getText();
    }
    public String getWebStubsStaticText(){
        return WEB_STUBS_TEXT;
    }

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
}

package juiceShop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage{
    private static final String ALL_PRODUCTS_SELECTOR = "body > app-root > " +
            "div > mat-sidenav-container > mat-sidenav-content > app-search-result > " +
            "div > div > div.heading.mat-elevation-z6 > div.ng-star-inserted";
    private static final String ALL_PRODUCTS_TEXT = "All Products";
    @FindBy(css = ALL_PRODUCTS_SELECTOR)
    WebElement products;

    public String getProductsText(){
        return products.getText();
    }
    public String getProductsStaticText(){
        return ALL_PRODUCTS_TEXT;
    }
    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
}

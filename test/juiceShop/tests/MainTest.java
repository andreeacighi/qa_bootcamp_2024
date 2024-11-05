package juiceShop.tests;

import juiceShop.frameworkUtils.Selectors;
import juiceShop.pages.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class MainTest extends BaseTest{

    @Test
    public void mainPageTest(){

        // OLD version !! Do not use unless the server you are testing does not have internet
        // System.property("webdriver.chrome.driver", "C:\\Users\myuser\Download\chromedriver.exe");
        driver.get(baseUrl + "/#/");
        MainPage mp = new MainPage(driver);
        Assert.assertEquals(mp.getProductsText(),mp.getProductsStaticText());
    }
}

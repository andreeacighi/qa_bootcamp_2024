package juiceShop.tests;

import juiceShop.frameworkUtils.Selectors;
import juiceShop.frameworkUtils.Utils;
import juiceShop.pages.LoginPage;
import juiceShop.pages.RegistrationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class RegisterTest extends BaseTest{

    @DataProvider(name = "RegistrationDataProvider")
    public Iterator<Object[]> registerDp (){
        Collection<Object[]> dp = new ArrayList<>();
        dp.add(new String[] {"alex@alex.com","alexrtete","alex"});
        return dp.iterator();
    }

    @Test(dataProvider = "RegistrationDataProvider")
    public void loginRegister(String username, String password, String securityAns) {
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

    @Test(dataProvider = "RegistrationDataProvider")
    public void loginRegister2(String username, String password, String securityAns){
        driver.get(baseUrl + "/#/login");
        LoginPage lp = new LoginPage(driver);
        lp.waitDismissModal();
        lp.newUser();
        RegistrationPage rp = new RegistrationPage(driver);
        Assert.assertEquals(rp.getRegisterHeader(),rp.getRegisterPageStatic());
        rp.register(username,password,securityAns);
    }

}

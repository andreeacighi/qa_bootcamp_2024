package Homework4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RegisterTest {
        protected static final String baseUrl = Homework4.Utils.getConfigProperty("baseUrl");

        protected WebDriver driver;

        @BeforeMethod
        public void initBrowser(){

            // OLD version !! Do not use unless the server you are testing does not have internet
            // System.property("webdriver.chrome.driver", "C:\\Users\myuser\Download\chromedriver.exe");
            driver = Utils.getDriver();
            driver.manage().window().maximize();

        }
        @DataProvider(name = "RegistrationData")
        public Iterator<Object[]> provideData() {

            List<Object[]> testData = new ArrayList<>();

            // invalid tests
            testData.add(new Object[] { "invalidemail.com", "short23","short23","andreea"});
            testData.add(new Object[] { "ana@s.com", "","short23","andreea" });
            testData.add(new Object[] { "vlad@t.com", "vlad2345","vlad2435","andreea" });
            testData.add(new Object[] { "ioana@ioana.com", "short23","short23","" });

            // valid test
            testData.add(new Object[] { "andre@ci.com", "andreea24","andreea24","andreea" });
            testData.add(new Object[] { "popion@ion.com", "ionpop23","ionpop23","ionut" });
            testData.add(new Object[] { "dudf@flaviu.com", "flaviu234","flaviu234","flaviu" });

            return testData.iterator();
        }
        @Test(dataProvider = "RegistrationData")
        public void register(String email, String password,String confirmPassword,String securityAns) {
            // accesam main page
            driver.get(baseUrl + "/#/");
            // verificam sa fim pe main page
            Assert.assertEquals(driver.findElement(By.cssSelector(Homework4.Selectors.MAIN_PAGE_HEADER)).getText(), Homework4.Selectors.MAIN_TEXT);

            // Navigare pagina de login
            // Click pe butonul de Account
            WebElement accountButton = driver.findElement(By.id(Homework4.Selectors.ACCOUNT_BUTTON));
            WebElement dismiss = Homework4.Utils.waitForElement(driver,5,By.cssSelector(Selectors.DISMISS));
            dismiss.click();
            accountButton.click();

            // click pe butonul de login
            WebElement loginButton = driver.findElement(By.id(Homework4.Selectors.LOGIN_BUTTON));
            loginButton.click();

            // Verificam ca suntem pe pagina de login
            Assert.assertEquals(driver.findElement(By.cssSelector(Homework4.Selectors.LOGIN_HEADER)).getText(), Homework4.Selectors.LOGIN_TEXT);

            // click pe butonul ce ne duce la register
            WebElement registerLink = driver.findElement(By.cssSelector(Homework4.Selectors.REGISTER_URL));
            if (Homework4.Utils.waitToDisappear(driver,5,By.id(Selectors.MODAL)))
                registerLink.click();

            // verificam sa fim pe pagina de register
            Assert.assertEquals(
                    driver.findElement(By.cssSelector(Homework4.Selectors.REGISTER_HEADER)).getText(),
                    Selectors.REGISTER_TEXT);

            WebElement usernameElement = driver.findElement(By.id(Homework4.Selectors.REGISTER_EMAIL));
            usernameElement.clear();
            usernameElement.sendKeys(email);

            WebElement passwordElement = driver.findElement(By.id(Homework4.Selectors.REGISTER_PASSWORD));
            passwordElement.clear();
            passwordElement.sendKeys(password);

            WebElement passwordRepeat = driver.findElement(By.id(Homework4.Selectors.REGISTER_CONFIRM));
            passwordRepeat.clear();
            passwordRepeat.sendKeys(confirmPassword);

            WebElement securityQuestion = Homework4.Utils.waitForElement(driver, 5,
                    By.name(Homework4.Selectors.SECURITY_QUESTION));
            securityQuestion.click();


            WebElement securityQuestionChoice = Homework4.Utils.waitToBeClickable(driver,10,
                    By.cssSelector(Selectors.SECURITY_QUESTION1));
            securityQuestionChoice.click();

            WebElement securityAnswer = driver.findElement(By.id(Homework4.Selectors.SECURITY_ANSWER));
            securityAnswer.clear();
            securityAnswer.sendKeys(securityAns);

            WebElement submitButton = driver.findElement(By.id(Homework4.Selectors.REGISTER_SUBMIT_BUTTON));
            //asteapta pana dispare elementul ce suprapune butonul
            if (Homework4.Utils.waitToDisappear(driver,5,By.id(Homework4.Selectors.COOKIES_MODAL)))


            if (!submitButton.isDisplayed()){
                if (driver.findElement(By.id(Selectors.INVALID_EMAIL)).isDisplayed()) {
                    Assert.assertEquals(driver.findElement(By.id(Selectors.INVALID_EMAIL)).getText(),
                            Selectors.INVALID_EMAIL_TEXT, "Mesajul de eroare nu este cel așteptat.");

                } else if (driver.findElement(By.id(Selectors.INVALID_PASSWORD)).isDisplayed()) {
                    Assert.assertEquals(driver.findElement(By.id(Selectors.INVALID_PASSWORD)).getText(),
                            Selectors.INVALID_PASSWORD_TEXT, "Mesajul de eroare nu este cel așteptat.");
                    Assert.assertEquals(driver.findElement(By.id(Selectors.REPEAT_PASSWORD)).getText(),
                            Selectors.REPEAT_PASSWORD_TEXT, "Mesajul de eroare nu este cel așteptat.");


                } else if (driver.findElement(By.id(Selectors.WRONG_PASSWORD)).isDisplayed()) {
                    Assert.assertEquals(driver.findElement(By.id(Selectors.WRONG_PASSWORD)).getText(),
                            Selectors.WRONG_PASSWORD_TEXT, "Mesajul de eroare nu este cel așteptat.");

                } else if (driver.findElement(By.id(Selectors.NO_ANSWER)).isDisplayed()) {
                    Assert.assertEquals(driver.findElement(By.id(Selectors.NO_ANSWER)).getText(),
                            Selectors.NO_ANSWER_TEXT, "Mesajul de eroare nu este cel așteptat.");
                }
            }else {
                submitButton.click();

            }


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



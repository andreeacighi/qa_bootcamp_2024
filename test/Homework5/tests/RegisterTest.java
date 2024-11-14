package Homework5.tests;

import Homework5.pages.RegistrationPage;

import juiceShop.frameworkUtils.Utils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class RegisterTest extends BaseTest{
    @DataProvider(name = "RegisterDataProvider")
    public Iterator<Object[]> registerDp (){
        Collection<Object[]> dp = new ArrayList<>();
        // Positive tests
        dp.add(new String[] {"cighi24",
                "Andree234@",
                "Andree234@",
                "Ms",
                "Andreea",
                "Cighi",
                "cighi.and23@gmail.com",
                "06-24-2000"});
        dp.add(new String[] {"maria24",
                "Maria234@",
                "Maria234@",
                "Ms",
                "Maria",
                "Pop",
                "pop.maria23@gmail.com",
                "05-24-1989"});
        dp.add(new String[] {"florin31",
                "Florin312@",
                "Florin312@",
                "Mr",
                "Florin",
                "Gal",
                "florin.gal31@gmail.com",
                "12-31-1995"});
        // Negative tests
        dp.add(new String[] {"",
                "Andree234@",
                "Andree234@",
                "Ms",
                "Andreea",
                "Cighi",
                "cighi.and23@gmail.com",
                "06-24-2000"});
        dp.add(new String[] {"maria24",
                "",
                "Maria234@",
                "Ms",
                "Maria",
                "Pop",
                "pop.maria23@gmail.com",
                "05-24-1989"});
        return dp.iterator();
    }

    @Test(dataProvider = "RegisterDataProvider")
    public void register(String user,String pass, String confPass,String title,String firstName,String lastName,String email,String date){
        driver.get(baseUrl);
        RegistrationPage rp = new RegistrationPage(driver);
        rp.loginButton();
        rp.registerButton();
        Assert.assertEquals(rp.getSignUpSelector(),rp.getSignUpSelectorText());
        rp.register(user, pass, confPass, title, firstName, lastName, email, date);
        if (user.isEmpty() || pass.isEmpty()) {
            String expectedErrorText = "";
            if (user.isEmpty()) {
                expectedErrorText += rp.getErrorTextStaticUser();
            }
            if (pass.isEmpty()) {
                expectedErrorText += rp.getErrorTextStaticPass();
            }
            Assert.assertEquals(rp.getErrorText().getText(), expectedErrorText);

        }else {

            rp.setSubmitButton();

            String expectedText = rp.getConfirmSignInSelector().getText().trim().replaceAll(",\\s+", ",");
            String actualText = rp.getText(user).trim().replaceAll(",\\s+", ",");

            Assert.assertEquals(expectedText, actualText);
        }
    }
}

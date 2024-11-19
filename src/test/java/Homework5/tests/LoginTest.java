package Homework5.tests;

import Homework5.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class LoginTest extends BaseTest {

    @DataProvider(name = "LoginDataProvider")
    public Iterator<Object[]> loginDp() {
        Collection<Object[]> dp = new ArrayList<>();
        // Positive tests
        dp.add(new String[]{"zebra", "zebrapassword"});
        dp.add(new String[]{"dingo", "dingopassword"});
        dp.add(new String[]{"camel", "camelpassword"});
        //Negative tests
        dp.add(new String[]{"", "camelpassword"});
        dp.add(new String[]{"camel", ""});
        return dp.iterator();
    }

    @Test(dataProvider = "LoginDataProvider")
    public void login(String username, String password) {
        driver.get(baseUrl);
        LoginPage lp = new LoginPage(driver);
        Assert.assertEquals(lp.getWebStubsText(), lp.getWebStubsStaticText());
        lp.loginButton();
        Assert.assertEquals(lp.getSignInSelector().getText(), lp.getSignInStaticText());
        lp.login(username, password);
        if (username.isEmpty() || password.isEmpty()) {
            String expectedErrorText = "";
            if (username.isEmpty()) {
                expectedErrorText += lp.getErrorTextStaticUser();
            }
            if (password.isEmpty()) {
                expectedErrorText += lp.getErrorTextStaticPass();
            }

            Assert.assertEquals(lp.getErrorText().getText(), expectedErrorText);

        }else {

            lp.signInButton();

            String expectedText = lp.getConfirmSignInSelector().getText().trim().replaceAll(",\\s+", ",");
            String actualText = lp.getText(username).trim().replaceAll(",\\s+", ",");

            Assert.assertEquals(expectedText, actualText);
        }


    }




}

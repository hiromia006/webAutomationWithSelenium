package com.parabank.parasoft.oops.test;

import com.parabank.parasoft.oops.pages.HomePage;
import com.parabank.parasoft.oops.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    
    @Test
    public void loginWithOutUsernameShouldFail() {
        LoginPage loginPage = page.getInstance(LoginPage.class)
                .doLogin();
        Assert.assertTrue(loginPage.hasLoginFailError());

    }

    @Test
    public void loginWithUsernameShouldFail() {
        LoginPage loginPage = page.getInstance(LoginPage.class)
                .doLogin("automationsession");
        Assert.assertTrue(loginPage.hasLoginFailError());

    }

    @Test
    public void loginShouldSucceed() {
        HomePage homePage = page.getInstance(LoginPage.class)
                .doLogin("automationsession", "automationsession");
        Assert.assertTrue(homePage.isLogoutLink());

    }

    @Test
    public void printAllUrl() {
        page.getInstance(LoginPage.class)
                .printAllUrl();
    }

}

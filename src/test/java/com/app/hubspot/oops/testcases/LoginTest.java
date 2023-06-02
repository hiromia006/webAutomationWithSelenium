package com.app.hubspot.oops.testcases;

import com.app.hubspot.oops.pages.HomePage;
import com.app.hubspot.oops.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test(priority = 0)
    public void checkPageTitle() {
        Assert.assertEquals(page.getInstance(LoginPage.class).getPageTittle(), "HubSpot Login");
    }

    @Test(priority = 1)
    public void doLoginShouldFail() {
        LoginPage loginPage = page.getInstance(LoginPage.class)
                .doLogin();
        Assert.assertTrue(loginPage.hasErrorMessage());
    }

    @Test(priority = 2)
    public void doLoginWithUsernameShouldFail() {
        LoginPage loginPage = page.getInstance(LoginPage.class)
                .doLogin("sqalearningacademy2@gmail.com");
        Assert.assertTrue(loginPage.hasErrorMessage());
    }

    @Test(priority = 3)
    public void doLoginShouldSucceed() {
        HomePage homePage = page.getInstance(LoginPage.class)
                .doLogin("sqalearningacademy2@gmail.com", "HubspoT555123");
        Assert.assertTrue(homePage.isAccountMenu());
    }
}

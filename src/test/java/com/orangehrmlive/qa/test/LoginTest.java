package com.orangehrmlive.qa.test;

import com.orangehrmlive.qa.base.BaseTest;
import com.orangehrmlive.qa.pages.DashBoardPage;
import com.orangehrmlive.qa.pages.LoginPage;
import com.orangehrmlive.qa.util.GeneralUtil;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest extends BaseTest {
    LoginPage loginPage;

    public LoginTest(){
        super();
    }

    @BeforeMethod
    public void init() {
        initialization();
        loginPage = new LoginPage();
    }

    @Test(priority = 0)
    public void loginShouldFail() {
        loginPage.loginFail("Admin1", "admin123");
        Assert.assertTrue(loginPage.hasErrorMessage());
    }

    @Test(priority = 1)
    public void loginWithoutUsernameAndPasswordShouldFail() {
        loginPage.loginFail();
        Assert.assertTrue(loginPage.hasErrorMessage());
    }

    @Test(priority = 2)
    public void loginWithoutPasswordShouldFail() {
        loginPage.loginFail("Admin");
        Assert.assertTrue(loginPage.hasErrorMessage());
    }

    @Test(priority = 3)
    public void loginShouldSucceed() {
        DashBoardPage homePagePage = loginPage.login(getUsername(), getUsername());
        Assert.assertTrue(homePagePage.hasWelcome());
    }


    @AfterMethod
    public void TearDown() {
        GeneralUtil.mediumWaitForDomStable();
        driver.quit();
    }

}

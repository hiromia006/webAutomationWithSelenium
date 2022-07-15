package com.orangehrmlive.qa.test;

import com.orangehrmlive.qa.base.BaseTest;
import com.orangehrmlive.qa.pages.DashBoardPage;
import com.orangehrmlive.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {
    DashBoardPage homePage;
    LoginPage loginPage;


    @BeforeMethod
    public void setup() {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.login("Admin", "admin123");
    }

    @Test
    public void checkHomePageShouldSucceed() {
        Assert.assertTrue(homePage.hasWelcome());
    }

    @Test
    public void checkLeaveApply() {
        homePage.clickAssignLeave();
    }

    @AfterMethod
    public void dearTown() {
        driver.quit();
    }
}

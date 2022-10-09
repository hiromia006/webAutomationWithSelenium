package com.parabank.parasoft.pom.test;

import com.parabank.parasoft.pom.BaseParaBankTest;
import com.parabank.parasoft.pom.pages.CustomerLoginPage;
import com.parabank.parasoft.pom.pages.HomePage;
import com.parabank.parasoft.pom.pages.OpenAccountPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpenAccountTest extends BaseParaBankTest {
    HomePage homePage;

    public OpenAccountTest() {
        super();
    }

    @BeforeMethod
    public void initialization() {
        setUp();
        homePage = new CustomerLoginPage()
                .login(getParaBankUserName(), getParaBankPassword());
    }

    @Test
    public void openAccountShouldSucceed() {
        OpenAccountPage openAccountPage = homePage.clickOpenNewAccountLink()
                .selectAccountType(1)
                .selectFromAccountId(0)
                .clickOpenAccountBtn();
        Assert.assertTrue(openAccountPage.hasNewAccountId());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

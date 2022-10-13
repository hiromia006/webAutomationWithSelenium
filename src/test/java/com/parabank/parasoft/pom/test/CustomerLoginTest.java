package com.parabank.parasoft.pom.test;


import com.parabank.parasoft.pom.BaseParaBankTest;
import com.parabank.parasoft.pom.pages.CustomerLoginPage;
import com.parabank.parasoft.pom.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CustomerLoginTest extends BaseParaBankTest {

    private HomePage homePage;
    private CustomerLoginPage customerLoginPage;

    public CustomerLoginTest() {
        super();
    }

    @BeforeMethod
    public void init() {
        setUpBrowser();
        customerLoginPage = new CustomerLoginPage();
    }

    @Test
    public void loginShouldSucceed() {
        homePage = customerLoginPage.login(getParaBankUserName(), getParaBankPassword());
        Assert.assertTrue(homePage.isLoggedIn());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

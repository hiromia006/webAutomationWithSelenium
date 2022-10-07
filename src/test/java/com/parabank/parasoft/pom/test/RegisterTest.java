package com.parabank.parasoft.pom.test;

import com.parabank.parasoft.pom.BaseParaBankTest;
import com.parabank.parasoft.pom.pages.CustomerLoginPage;
import com.parabank.parasoft.pom.pages.RegisterPage;
import com.thedeanda.lorem.LoremIpsum;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest extends BaseParaBankTest {
    public CustomerLoginPage customerLoginPage;

    public RegisterTest() {
        super();
    }

    @BeforeMethod
    public void initialization() {
        setUp();
        customerLoginPage = new CustomerLoginPage();

    }

    @Test
    public void registrationShouldSucceed() {
        RegisterPage registerPage = customerLoginPage.clickRegistration()
                .fillFirstName(LoremIpsum.getInstance().getFirstName())
                .fillLastName(LoremIpsum.getInstance().getLastName());
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

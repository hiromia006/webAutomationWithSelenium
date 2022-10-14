package com.parabank.parasoft.pom.test;

import com.parabank.parasoft.pom.BaseParaBankTest;
import com.parabank.parasoft.pom.pages.CustomerLoginPage;
import com.parabank.parasoft.pom.pages.RegisterPage;
import com.parabank.parasoft.pom.util.General;
import com.thedeanda.lorem.LoremIpsum;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterTest extends BaseParaBankTest {
    public CustomerLoginPage customerLoginPage;

    public RegisterTest() {
        super();
    }

    @BeforeMethod
    public void initialization() {
        setUpBrowser();
        customerLoginPage = new CustomerLoginPage();

    }

    @Test(dataProvider = "getDataProviderData")
    public void registrationShouldSucceed(String firstName, String lastName) {
        RegisterPage registerPage = customerLoginPage.clickRegistration()
                .fillFirstName(firstName)
                .fillLastName(lastName);
    }

    @Test(dataProvider = "getDataProviderDataFromExcel")
    public void registrationDdtShouldSucceed(String firstName, String lastName) {
        RegisterPage registerPage = customerLoginPage.clickRegistration()
                .fillFirstName(firstName)
                .fillLastName(lastName);
    }
    @DataProvider
    public static Object[][] getDataProviderData() {
        return new Object[][]{{LoremIpsum.getInstance().getFirstName(), LoremIpsum.getInstance().getName()}, {LoremIpsum.getInstance().getFirstName(), LoremIpsum.getInstance().getName()}, {LoremIpsum.getInstance().getFirstName(), LoremIpsum.getInstance().getName()}};
    }


    @DataProvider
    public static Object[][] getDataProviderDataFromExcel() {
        return General.getTestData("Sheet1");
    }
    @AfterMethod
    public void tearDown(ITestResult result) {
        if (ITestResult.SUCCESS == result.getStatus()) {
            General.takeScreenshot(result.getMethod().getMethodName());
        }
        driver.quit();
    }


}

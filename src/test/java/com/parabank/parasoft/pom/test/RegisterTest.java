package com.parabank.parasoft.pom.test;

import com.parabank.parasoft.pom.BaseParaBankTest;
import com.parabank.parasoft.pom.pages.CustomerLoginPage;
import com.parabank.parasoft.pom.pages.HomePage;
import com.parabank.parasoft.pom.pages.RegisterPage;
import com.parabank.parasoft.pom.util.General;
import com.thedeanda.lorem.LoremIpsum;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterTest extends BaseParaBankTest {
    RegisterPage registerPage;

    public RegisterTest() {
        super();
    }

    @BeforeMethod
    public void initialization() {
        setUpBrowser();
        registerPage = new CustomerLoginPage()
                .clickRegistrationLink();
    }

    @Test
    public void registerShouldFail() {
        registerPage = registerPage
                .fillFistName(LoremIpsum.getInstance().getFirstName())
                .fillLastName(LoremIpsum.getInstance().getLastName())
                .fillAddress(LoremIpsum.getInstance().getCountry())
                .clickRegister();
        Assert.assertTrue(registerPage.getErrorCount() > 0);

    }

    @Test(groups = "smoke")
    public void registerWithTwoFieldsShouldFail() {
        registerPage = registerPage
                .fillFistName(LoremIpsum.getInstance().getFirstName())
                .fillAddress(LoremIpsum.getInstance().getCountry())
                .clickRegister();
        Assert.assertTrue(registerPage.getErrorCount() > 0);

    }

    @Test(invocationCount = 3)
    public void registerWithThreeFieldsShouldFail() {
        registerPage = registerPage
                .fillFistName(LoremIpsum.getInstance().getFirstName())
                .fillAddress(LoremIpsum.getInstance().getCountry())
                .fillCity(LoremIpsum.getInstance().getCity())
                .clickRegister();
        Assert.assertTrue(registerPage.getErrorCount() > 0);

    }

    @Test(retryAnalyzer = RerunningCount.class)
    public void registerShouldFail6() {
        registerPage = registerPage
                .fillFistName(LoremIpsum.getInstance().getFirstName())
                .fillAddress(LoremIpsum.getInstance().getCountry())
                .clickRegister();
        Assert.assertTrue(registerPage.getErrorCount() > 0);

    }


    @Test(dataProvider = "getDataProviderData")
    public void registerShouldFail3(String firstName, String LastName) {
        registerPage = registerPage
                .fillFistName(firstName)
                .fillLastName(LastName)
                .clickRegister();
        Assert.assertTrue(registerPage.getErrorCount() > 0);
    }

    @Test(dataProvider = "knowledgeShared")
    public void registerShouldFail4(String firstName, String LastName) {
        registerPage = registerPage
                .fillFistName(firstName)
                .fillLastName(LastName)
                .clickRegister();
        Assert.assertTrue(registerPage.getErrorCount() > 0);
    }

    @Test
    public void registerShouldSucceed() {
        String username = "share" + LoremIpsum.getInstance().getTitle(3).replaceAll(" ", "").toLowerCase();
        HomePage homePage = registerPage
                .fillFistName(LoremIpsum.getInstance().getFirstName())
                .fillLastName(LoremIpsum.getInstance().getLastName())
                .fillAddress(LoremIpsum.getInstance().getCountry())
                .fillCity(LoremIpsum.getInstance().getCity())
                .fillState(LoremIpsum.getInstance().getCity())
                .fillZipCode(LoremIpsum.getInstance().getZipCode())
                .fillPhoneNumber(LoremIpsum.getInstance().getPhone())
                .fillSsn("45665456")
                .fillUsername(username)
                .fillPassword(username)
                .fillConfirm(username)
                .clickRegisterBtn();
        Assert.assertTrue(homePage.isLogoutLink());
    }

    @DataProvider
    public Object[][] getDataProviderData() {
        return new Object[][]{{LoremIpsum.getInstance().getFirstName(), LoremIpsum.getInstance().getLastName()}, {LoremIpsum.getInstance().getFirstName(), LoremIpsum.getInstance().getName()}, {LoremIpsum.getInstance().getFirstName(), LoremIpsum.getInstance().getName()}};
    }

    @DataProvider(name = "knowledgeShared")
    public Object[][] getDataProviderDataFromExcel() {
        return General.getTestData("Sheet1");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (ITestResult.SUCCESS == result.getStatus()) {
            takeScreenshot(result.getMethod().getMethodName());
        }

        driver.quit();
    }


}

package com.orangehrmlive.qa.test;

import com.orangehrmlive.qa.base.BaseTest;
import com.orangehrmlive.qa.pages.AdminPage;
import com.orangehrmlive.qa.pages.LoginPage;
import com.thedeanda.lorem.LoremIpsum;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdminTest extends BaseTest {
    AdminPage adminPage;

    @BeforeMethod
    public void setup() {
        initialization();
        adminPage = new LoginPage()
                .login("Admin", "admin123")
                .clickAdmin();
    }

    @Test(enabled = false)
    public void checkAdminPageShouldSucceed() {
        Assert.assertTrue(adminPage.isAdminPage());
    }

    @Test
    public void addUserShouldSucceed() {
        String password = "qaqaQA123456";
        String username = "user" + LoremIpsum.getInstance().getTitle(1);

        adminPage = adminPage.clickAddBtn()
                .fillEmployeeName("a")
                .fillUsername(username)
                .selectStatus(1)
                .fillPassword(password)
                .fillConfirmPassword(password)
                .clickSaveBtn();
        Assert.assertTrue(adminPage.hasMessageSuccess());
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

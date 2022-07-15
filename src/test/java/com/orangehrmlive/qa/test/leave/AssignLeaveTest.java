package com.orangehrmlive.qa.test.leave;

import com.orangehrmlive.qa.base.BaseTest;
import com.orangehrmlive.qa.pages.DashBoardPage;
import com.orangehrmlive.qa.pages.LoginPage;
import com.orangehrmlive.qa.pages.leave.AssignLeavePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AssignLeaveTest extends BaseTest {
    AssignLeavePage assignLeavePage;
    DashBoardPage dashBoardPage;

    public AssignLeaveTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialization();
        dashBoardPage = new LoginPage().login("Admin", "admin123");
    }

    @Test
    public void checkLeaveApplyShouldSucceed() {
        assignLeavePage = dashBoardPage.clickAssignLeave();
        Assert.assertTrue(assignLeavePage.hasApplyLeaveForm());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

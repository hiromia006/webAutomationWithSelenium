package com.orangehrmlive.qa.pages;

import com.orangehrmlive.qa.base.BaseTest;
import com.orangehrmlive.qa.pages.leave.AssignLeavePage;
import com.orangehrmlive.qa.util.GeneralUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage extends BaseTest {
    @FindBy(id = "welcome")
    WebElement welcomeEl;

    @FindBy(css = "div.quickLaunge a[href$='assignLeave'] img")
    WebElement assignLeave;

    @FindBy(css = "a#menu_admin_viewAdminModule")
    WebElement adminEl;

    @FindBy(css = "a#menu_admin_viewSystemUsers")
    WebElement userEl;

    public DashBoardPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean hasWelcome() {
        return welcomeEl.getText().trim().contains("Welcome");
    }

    public AssignLeavePage clickAssignLeave() {
        scrollToElementAndClick(assignLeave);
        return new AssignLeavePage();
    }

    public AdminPage clickAdmin() {
        scrollToElementAndClick(adminEl);
        return new AdminPage();
    }

}

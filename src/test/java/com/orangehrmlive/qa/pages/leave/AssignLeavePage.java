package com.orangehrmlive.qa.pages.leave;

import com.orangehrmlive.qa.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssignLeavePage extends BaseTest {
    @FindBy(css = "form#frmLeaveApply")
    WebElement applyLeaveForm;


    public AssignLeavePage() {
        PageFactory.initElements(driver, this);
    }

    public boolean hasApplyLeaveForm() {
        return applyLeaveForm.isDisplayed();
    }
}

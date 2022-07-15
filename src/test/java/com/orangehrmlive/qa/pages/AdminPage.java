package com.orangehrmlive.qa.pages;

import com.orangehrmlive.qa.base.BaseTest;
import com.orangehrmlive.qa.util.GeneralUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AdminPage extends BaseTest {
    @FindBy(css = "div#systemUser-information")
    List<WebElement> webElements;

    @FindBy(css = "input#btnAdd")
    WebElement addBtn;

    @FindBy(css = "input#systemUser_employeeName_empName")
    WebElement employeeNameEl;

    @FindBy(css = "div.ac_results ul > li")
    List<WebElement> employees;

    @FindBy(css = "input#systemUser_userName")
    WebElement usernameEl;

    @FindBy(css = "input#systemUser_password")
    WebElement passwordEl;

    @FindBy(css = "input#systemUser_confirmPassword")
    WebElement confirmPasswordEl;

    @FindBy(css = "input#btnSave")
    WebElement saveBtn;

    @FindBy(css = ".success")
    List<WebElement> success;

    @FindBy(css = "select#systemUser_userType")
    WebElement status;

    public AdminPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean isAdminPage() {
        return webElements.size() > 0;
    }

    public AdminPage clickAddBtn() {
        addBtn.isDisplayed();
        addBtn.click();
        return this;
    }

    public AdminPage fillEmployeeName(String employeeName) {
        employeeNameEl.isDisplayed();
        employeeNameEl.clear();
        employeeNameEl.sendKeys(employeeName);
        employees.get(0).isDisplayed();
        GeneralUtil.waitForDomStable();
        employees.get(0).click();
        GeneralUtil.waitForDomStable();
        usernameEl.click();
        return this;
    }

    public AdminPage fillUsername(String username) {
        usernameEl.isDisplayed();
        usernameEl.sendKeys(username);
        return this;
    }

    public AdminPage fillPassword(String password) {
        passwordEl.isDisplayed();
        passwordEl.sendKeys(password);
        return this;
    }

    public AdminPage fillConfirmPassword(String confirmPassword) {
        confirmPasswordEl.isDisplayed();
        confirmPasswordEl.sendKeys(confirmPassword);
        return this;
    }

    public AdminPage clickSaveBtn() {
        GeneralUtil.waitForDomStable();
        saveBtn.isDisplayed();
        saveBtn.click();
        saveBtn.click();
        return this;
    }

    public AdminPage selectStatus(int index) {
        new Select(status)
                .selectByIndex(index);
        return this;
    }

    public boolean hasMessageSuccess() {
        return success.size() > 0;
    }

}

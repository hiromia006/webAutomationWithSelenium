package com.orangehrmlive.qa.pages;

import com.orangehrmlive.qa.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTest {
    // Page Factory ;

    @FindBy(id = "txtUsername")
    @CacheLookup
    WebElement usernameEl;

    @FindBy(id = "txtPassword")
    @CacheLookup
    WebElement passwordEl;

    @FindBy(id = "btnLogin")
    @CacheLookup
    WebElement loginBtn;

    @FindBy(id = "spanMessage")
    WebElement messageEl;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public DashBoardPage login(String username, String password) {
        usernameEl.clear();
        usernameEl.sendKeys(username);

        passwordEl.clear();
        passwordEl.sendKeys(password);
        loginBtn.click();

        return new DashBoardPage();
    }

    public void loginFail(String username, String password) {
        usernameEl.clear();
        usernameEl.sendKeys(username);

        passwordEl.clear();
        passwordEl.sendKeys(password);
        loginBtn.click();

    }

    public void loginFail(String username) {
        usernameEl.isDisplayed();
        usernameEl.clear();
        usernameEl.sendKeys(username);
        loginBtn.click();
    }

    public void loginFail() {
        loginBtn.isDisplayed();
        loginBtn.click();
    }

    public boolean hasErrorMessage() {
        return messageEl.isDisplayed();
    }

}

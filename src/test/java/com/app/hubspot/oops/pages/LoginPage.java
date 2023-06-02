package com.app.hubspot.oops.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private By usernameLocator = By.id("username");
    private By passwordLocator = By.id("password");
    private By loginBtn = By.cssSelector("#loginBtn i18n-string");

    private By alert = By.cssSelector("div.private-alert--danger");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage fillUsername(String username) {
        waitForElement(usernameLocator);
        getWebElement(usernameLocator).click();
        getWebElement(usernameLocator).sendKeys(username);
        return this;
    }

    public LoginPage fillPassword(String password) {
        getWebElement(passwordLocator).clear();
        getWebElement(passwordLocator).sendKeys(password);
        return this;
    }

    public HomePage clickLoginBtn() {
        waitForElement(loginBtn);
        getWebElement(loginBtn).click();
        return getInstance(HomePage.class);
    }

    public LoginPage clickLoginLinkBtn() {
        waitForElement(loginBtn);
        getWebElement(loginBtn).click();
        return this;
    }

    public boolean hasErrorMessage() {
        return getWebElements(alert).size() > 0;
    }

    public HomePage doLogin(String username, String password) {
        return fillUsername(username)
                .fillPassword(password)
                .clickLoginBtn();
    }

    public LoginPage doLogin() {
        return fillUsername("sqalearningacademy1@gmail.com")
                .fillPassword("1234455444")
                .clickLoginLinkBtn();
    }

    public LoginPage doLogin(String username) {
        return fillUsername(username)
                .clickLoginLinkBtn();
    }

}

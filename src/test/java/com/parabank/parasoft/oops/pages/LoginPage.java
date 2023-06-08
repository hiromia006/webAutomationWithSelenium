package com.parabank.parasoft.oops.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.stream.Collectors;

public class LoginPage extends BasePage {
    private By usernameSelector = By.name("username");
    private By passwordSelector = By.name("password");
    private By loginBtn = By.cssSelector("input.button");

    private By error = By.className("error");
    private By link = By.tagName("a");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage fillUsername(String username) {
        waitForTittle(getTittle());
        getWebElement(usernameSelector).sendKeys(username);
        return this;
    }

    public LoginPage fillPassword(String password) {
        waitForWebElement(passwordSelector);
        getWebElement(passwordSelector).sendKeys(password);
        return this;
    }

    public HomePage clickLoginBtn() {
        waitForWebElement(loginBtn);
        getWebElement(loginBtn).click();
        return getInstance(HomePage.class);

    }

    public LoginPage clickLoginFailBtn() {
        waitForWebElement(loginBtn);
        getWebElement(loginBtn).click();
        return this;
    }

    public HomePage doLogin(String username, String password) {
        return fillUsername(username)
                .fillPassword(password)
                .clickLoginBtn();
    }

    public LoginPage doLogin() {
        return fillUsername("")
                .fillPassword("")
                .clickLoginFailBtn();
    }

    public LoginPage doLogin(String username) {
        return fillUsername(username)
                .clickLoginFailBtn();
    }

    public boolean hasLoginFailError() {
        return getWebElements(error).size() > 0;
    }

    public void printAllUrl() {
        getWebElements(link).stream()
                .filter(webElement -> webElement.getAttribute("href").contains("parabank"))
                .map(webElement -> webElement.getAttribute("href"))
                .collect(Collectors.toList())
                .forEach(s -> System.out.println(s));
    }
}

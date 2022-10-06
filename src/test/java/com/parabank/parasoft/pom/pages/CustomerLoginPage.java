package com.parabank.parasoft.pom.pages;

import com.parabank.parasoft.pom.BaseParaBankTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerLoginPage extends BaseParaBankTest {
    @FindBy(name = "username")
    WebElement usernameEl;

    @FindBy(name = "password")
    WebElement passwordEl;

    @FindBy(css = "input.button")
    WebElement loginBtn;

    public CustomerLoginPage() {
        PageFactory.initElements(driver, this);
    }

    public HomePage login(String username, String password) {
        usernameEl.isDisplayed();
        usernameEl.clear();
        usernameEl.sendKeys(username);

        passwordEl.clear();
        passwordEl.sendKeys(password);

        loginBtn.isDisplayed();
        loginBtn.click();

        return new HomePage();
    }
}

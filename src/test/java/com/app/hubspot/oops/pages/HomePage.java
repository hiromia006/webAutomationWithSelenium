package com.app.hubspot.oops.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private By menuAccount = By.cssSelector("#account-menu span");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isAccountMenu() {
        return getWebElements(menuAccount).size() > 0;
    }

}

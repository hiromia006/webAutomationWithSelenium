package com.parabank.parasoft.oops.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private By logoutBtn = By.cssSelector("a[href$='logout.htm']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isLogoutLink() {
        return getWebElements(logoutBtn).size() > 0;
    }
}

package com.parabank.parasoft.pom.pages;

import com.parabank.parasoft.pom.BaseParaBankTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseParaBankTest {
    @FindBy(css = "a[href$='logout.htm']")
    WebElement logout;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public boolean isLoggedIn() {
        return logout.isDisplayed();
    }
}

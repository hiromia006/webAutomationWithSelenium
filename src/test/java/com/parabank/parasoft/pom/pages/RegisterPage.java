package com.parabank.parasoft.pom.pages;

import com.parabank.parasoft.pom.BaseParaBankTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends BaseParaBankTest {
    @FindBy(id = "customer.firstName")
    WebElement firstNameEl;

    @FindBy(id = "customer.lastName")
    WebElement lastNameEl;

    public RegisterPage() {
        PageFactory.initElements(driver, this);
    }


    public RegisterPage fillFirstName(String firstName) {
        firstNameEl.isDisplayed();
        firstNameEl.sendKeys(firstName);
        return this;
    }

    public RegisterPage fillLastName(String lastName) {
        lastNameEl.isDisplayed();
        lastNameEl.sendKeys(lastName);
        return this;
    }
}

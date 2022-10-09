package com.parabank.parasoft.pom.pages;


import com.parabank.parasoft.pom.BaseParaBankTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OpenAccountPage extends BaseParaBankTest {
    @FindBy(css = "select#type")
    WebElement accountType;

    @FindBy(id = "fromAccountId")
    WebElement accountId;

    @FindBy(css = "input.button")
    WebElement openNewAccountBtn;

    @FindBy(id = "newAccountId")
    WebElement newId;

    public OpenAccountPage() {
        PageFactory.initElements(driver, this);
    }

    public OpenAccountPage selectAccountType(int index) {
        accountType.isDisplayed();
        new Select(accountType)
                .selectByIndex(index);
        return this;
    }

    public OpenAccountPage selectAccountType(String value) {
        accountType.isDisplayed();
        new Select(accountId)
                .selectByValue(value);
        return this;
    }

    public OpenAccountPage selectFromAccountId(int index) {
        accountId.isDisplayed();
        new Select(accountId)
                .selectByIndex(index);
        return this;
    }


    public OpenAccountPage clickOpenAccountBtn() {
        openNewAccountBtn.isDisplayed();
        openNewAccountBtn.click();
        return this;
    }

    public boolean hasNewAccountId() {
        return newId.isDisplayed();
    }
}

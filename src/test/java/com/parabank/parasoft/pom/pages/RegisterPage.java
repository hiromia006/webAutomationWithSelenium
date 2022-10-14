package com.parabank.parasoft.pom.pages;

import com.parabank.parasoft.pom.BaseParaBankTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RegisterPage extends BaseParaBankTest {

    @FindBy(how = How.ID, using = "customer.firstName")
    WebElement customerFirstName;

    @FindBy(id = "customer.lastName")
    WebElement customerLastName;

    @FindBy(how = How.ID, using = "customer.address.street")
    WebElement addressEl;

    @FindBy(id = "customer.address.city")
    WebElement cityEl;

    @FindBy(id = "customer.address.state")
    WebElement stateEl;

    @FindBy(id = "customer.address.zipCode")
    WebElement zipCodeEl;

    @FindBy(id = "customer.phoneNumber")
    WebElement phoneNumberEl;

    @FindBy(id = "customer.ssn")
    WebElement ssnEl;

    @FindBy(id = "customer.username")
    WebElement usernameEl;

    @FindBy(id = "customer.password")
    WebElement passwordEl;

    @FindBy(id = "repeatedPassword")
    WebElement repeatedPasswordEl;

    @FindBy(css = "input[value='Register']")
    WebElement registerBtn;

    @FindBy(css = "span[id*='error']")
    List<WebElement> errors;

    public RegisterPage() {
        PageFactory.initElements(driver, this);
    }

    public RegisterPage fillFistName(String firstName) {
        customerFirstName.isDisplayed();
        customerFirstName.sendKeys(firstName);
        return this;
    }

    public RegisterPage fillLastName(String lastName) {
        customerLastName.isDisplayed();
        customerLastName.sendKeys(lastName);
        return this;
    }

    public RegisterPage fillAddress(String address) {
        addressEl.isDisplayed();
        addressEl.sendKeys(address);
        return this;
    }

    public RegisterPage fillCity(String city) {
        cityEl.isDisplayed();
        cityEl.sendKeys(city);
        return this;
    }

    public RegisterPage fillState(String state) {
        stateEl.isDisplayed();
        stateEl.sendKeys(state);
        return this;
    }

    public RegisterPage fillZipCode(String zipCode) {
        zipCodeEl.isDisplayed();
        zipCodeEl.sendKeys(zipCode);
        return this;
    }


    public RegisterPage fillPhoneNumber(String phoneNumber) {
        phoneNumberEl.isDisplayed();
        phoneNumberEl.sendKeys(phoneNumber);
        return this;
    }

    public RegisterPage fillSsn(String ssn) {
        ssnEl.isDisplayed();
        ssnEl.sendKeys(ssn);
        return this;
    }

    public RegisterPage fillUsername(String username) {
        usernameEl.isDisplayed();
        usernameEl.sendKeys(username);
        return this;
    }

    public RegisterPage fillPassword(String password) {
        passwordEl.isDisplayed();
        passwordEl.sendKeys(password);
        return this;
    }

    public RegisterPage fillConfirm(String confirm) {
        repeatedPasswordEl.isDisplayed();
        repeatedPasswordEl.sendKeys(confirm);
        return this;
    }

    public HomePage clickRegisterBtn() {
        registerBtn.isDisplayed();
        registerBtn.click();
        return new HomePage();
    }

    public RegisterPage clickRegister() {
        registerBtn.isDisplayed();
        registerBtn.click();
        return this;
    }

    public int getErrorCount() {
        return errors.size();
    }
}

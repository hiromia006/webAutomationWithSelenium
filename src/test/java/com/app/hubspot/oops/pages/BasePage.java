package com.app.hubspot.oops.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BasePage extends Page {
    public BasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageTittle() {
        return driver.getTitle();
    }

    @Override
    public WebElement getWebElement(By selector) {
        WebElement webElement = null;
        try {
            webElement = driver.findElement(selector);
        } catch (Exception exception) {
            System.out.println("Something is happened for Locator " + selector.toString());
        }
        return webElement;
    }

    @Override
    public List<WebElement> getWebElements(By selector) {
        return driver.findElements(selector);
    }

    @Override
    public void waitForElement(By selector) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(selector));
        } catch (Exception e) {
            System.out.println("loading issue for WebElement " + selector.toString());
        }
    }

    @Override
    public void waitForPageTittle(String pageTittle) {
        try {
            wait.until(ExpectedConditions.titleContains(pageTittle));
        } catch (Exception e) {
            System.out.println("Page loading issue " + pageTittle);
        }
    }
}

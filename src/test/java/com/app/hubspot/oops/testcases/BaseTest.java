package com.app.hubspot.oops.testcases;

import com.app.hubspot.oops.pages.BasePage;
import com.app.hubspot.oops.pages.Page;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.Objects;

public class BaseTest {
    WebDriver driver;
    Page page;

    @BeforeMethod
    @Parameters(value = "browserName")
    public void setDriver(String browserName) throws InterruptedException {
        if (Objects.equals(browserName, "firefox")) {
            //logging disable
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        } else if (Objects.equals(browserName, "chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (Objects.equals(browserName, "headless")) {
            //logging disable
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("-headless");
            driver = new FirefoxDriver(options);
        } else {
            System.out.println("Browser Name is not found ");
        }

        driver.get("https://app.hubspot.com/login");
        driver.manage().window().maximize();

        Thread.sleep(6000);

        page = new BasePage(driver);

    }


    @AfterMethod
    public void teatDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
        Thread.sleep(2500);
    }


}

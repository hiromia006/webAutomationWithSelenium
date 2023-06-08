package com.parabank.parasoft.oops.test;

import com.parabank.parasoft.oops.pages.BasePage;
import com.parabank.parasoft.oops.pages.Page;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Objects;

public class BaseTest {
    WebDriver driver;
    Page page;

    @BeforeMethod
    public void browserSetup() {
        String browserName = "firefox";
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

        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        driver.manage().window().maximize();

        page = new BasePage(driver);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        driver.quit();
        Thread.sleep(2000);
    }
}

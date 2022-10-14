package com.parabank.parasoft.pom;

import com.google.common.base.Objects;
import com.parabank.parasoft.pom.util.General;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseParaBankTest {
    protected static WebDriver driver;
    private Properties properties;

    public BaseParaBankTest() {
        try {
            properties = new Properties();
            String filePath = System.getProperty("user.dir") + "/src/test/resources/config.properties";
            FileInputStream inputStream = null;

            inputStream = new FileInputStream(filePath);
            properties.load(inputStream);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setUpBrowser() {
        if (Objects.equal(properties.getProperty("browserName"), "firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (Objects.equal(properties.getProperty("browserName"), "headless")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setHeadless(true);
            driver = new FirefoxDriver(firefoxOptions);
        } else if (Objects.equal(properties.getProperty("browserName"), "chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new FirefoxDriver();
        } else {
            System.out.println("Please provide browser name");
        }


        driver.get(properties.getProperty("paraBank.baseUrl"));

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(General.PAGE_LOAD_TIME));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(General.IMPLICIT_WAIT));
    }

    public String getParaBankUserName() {
        return properties.getProperty("paraBank.username");
    }

    public String getParaBankPassword() {
        return properties.getProperty("paraBank.password");
    }

    public static void takeScreenshot(String fileName) {
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String currentDir = System.getProperty("user.dir") + "/build/screenshots/";
            FileUtils.copyFile(scrFile, new File(currentDir + fileName + System.currentTimeMillis() + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

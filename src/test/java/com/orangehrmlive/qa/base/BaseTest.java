package com.orangehrmlive.qa.base;

import com.orangehrmlive.qa.util.GeneralUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    public static WebDriver driver;
    Properties properties;

    public BaseTest() {
        try {
            String filePath = System.getProperty("user.dir") + "/src/test/resources/config.properties";
            properties = new Properties();
            FileInputStream inputStream = new FileInputStream(filePath);
            properties.load(inputStream);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void initialization() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(GeneralUtil.PAGE_LOAD_TIME));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GeneralUtil.IMPLICIT_WAIT));

        driver.get("https://opensource-demo.orangehrmlive.com");
    }

    public String getUsername() {
        return properties.getProperty("username").trim();
    }


    public String getPassword() {
        return properties.getProperty("password").trim();
    }


}

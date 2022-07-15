package com.orangehrmlive.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;

public class GeneralUtil {
    static public int PAGE_LOAD_TIME = 60;
    public static int IMPLICIT_WAIT = 30;

    public static void waitForDomStable() {
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void longWaitForDomStable() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void mediumWaitForDomStable() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Properties properties;
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

        System.out.println(properties.getProperty("username"));
        System.out.println(properties.getProperty("password"));
    }

}

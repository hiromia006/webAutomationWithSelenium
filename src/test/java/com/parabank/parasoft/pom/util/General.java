package com.parabank.parasoft.pom.util;

public class General {
    public static final int PAGE_LOAD_TIME = 30;
    public static final int IMPLICIT_WAIT = 30;

    public static void waitForDomStable(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

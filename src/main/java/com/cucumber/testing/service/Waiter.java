package com.cucumber.testing.service;

import com.cucumber.testing.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiter {
    private static final int WAIT_TIMEOUT = 10;
    private static final String CLASS_ATTRIBUTE = "class";
    private static final String DISABLE_VALUE = "disable";
    private static final String ACTIVE_VALUE = "active";

    private static final WebDriverWait waiter = new WebDriverWait(DriverManager.getDriver(), WAIT_TIMEOUT);

    public static void waitUntilElementBePresent(By elementSelector) {
        waiter.until(ExpectedConditions.presenceOfElementLocated(elementSelector));
    }

    public static void waitUntilElementNoBeDisable(By elementSelector) {
        waiter.until(ExpectedConditions.not(ExpectedConditions.attributeContains(elementSelector, CLASS_ATTRIBUTE, DISABLE_VALUE)));
    }

    public static void waitUntilElementBeActive(By elementSelector) {
        waiter.until(ExpectedConditions.attributeContains(elementSelector, CLASS_ATTRIBUTE, ACTIVE_VALUE));
    }

}

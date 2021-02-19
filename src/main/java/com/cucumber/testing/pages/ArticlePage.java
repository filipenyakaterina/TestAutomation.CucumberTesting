package com.cucumber.testing.pages;

import com.cucumber.testing.service.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePage extends BasePage {
    private static final By PAGE_TITLE = By.className("hero-header");

    public WebElement pageTitle() {
        Waiter.waitUntilElementBePresent(PAGE_TITLE);
        return findElement(PAGE_TITLE);
    }
}

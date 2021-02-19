package com.cucumber.testing.pages;

import com.cucumber.testing.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    private static final String CUCUMBER_URL = "https://cucumber.io/";
    private static final String SEARCH_ICON = "//a[contains(@class,'sb-search-ico')]";

    public void openCucumberWebsite() {
        DriverManager.getDriver().get(CUCUMBER_URL);
    }

    public WebElement searchIcon() {
        return findElement(By.xpath(SEARCH_ICON));
    }
}

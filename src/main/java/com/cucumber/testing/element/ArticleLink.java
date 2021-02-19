package com.cucumber.testing.element;

import com.cucumber.testing.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static java.lang.String.format;

public class ArticleLink {
    private static final String ARTICLE_LINK = "//div[@class='section' and contains(text(),'%s')]/ancestor::a";
    private static final By ARTICLE_LINK_TITLE = By.className("link-title");

    private static final int ARTICLE_LINK_NUMBER = 0;
    private final WebElement articleLink;

    public ArticleLink(String section) {
        articleLink = DriverManager.getDriver().findElements(By.xpath(format(ARTICLE_LINK, section))).get(ARTICLE_LINK_NUMBER);
    }

    public void openLink() {
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].click();", articleLink);
    }

    public String getArticleName() {
        return articleLink.findElement(ARTICLE_LINK_TITLE).getText();
    }
}

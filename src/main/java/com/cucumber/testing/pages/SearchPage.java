package com.cucumber.testing.pages;

import com.cucumber.testing.element.ArticleLink;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static java.lang.String.format;

public class SearchPage extends BasePage {
    private static final By SEARCH_FIELD = By.name("search");
    private static final String FILTER_CRITERIA = "//div[contains(@class,'filter-item')]/div[contains(text(),'%s')]";
    private static final String FILTER_OPTION = "//div[contains(text(),'%s') and @class='filter-item-name']/parent::div";

    public WebElement searchField() {
        return findElement(SEARCH_FIELD);
    }

    public WebElement filterCriteria(String criteria) {
        return findElement(By.xpath(format(FILTER_CRITERIA, criteria)));
    }

    public By filterOption(String option) {
        return By.xpath(format(FILTER_OPTION, option));
    }

    public ArticleLink articleLink(String section) {
        return new ArticleLink(section);
    }
}

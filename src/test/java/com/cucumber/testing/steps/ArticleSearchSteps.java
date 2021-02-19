package com.cucumber.testing.steps;

import com.cucumber.testing.element.ArticleLink;
import com.cucumber.testing.pages.ArticlePage;
import com.cucumber.testing.pages.HomePage;
import com.cucumber.testing.pages.SearchPage;
import com.cucumber.testing.service.Waiter;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;

public class ArticleSearchSteps {
    private final HomePage homePage = new HomePage();
    private final SearchPage searchPage = new SearchPage();
    private final ArticlePage articlePage = new ArticlePage();

    private String articleName;

    @When("the user opens Cucumber website")
    public void openCucumberWebsite() {
        homePage.openCucumberWebsite();
    }

    @When("the user clicks on the search icon")
    public void clickOnSearchIcon() {
        homePage.searchIcon().click();
    }

    @When("the user enters {string} to the search field")
    public void enterSearchData(String searchData) {
        searchPage.searchField().sendKeys(searchData);
    }

    @When("the user clicks on the {string} item in the filters section")
    public void filterSearchResults(String filterCriteria) {
        By filterOptionSelector = searchPage.filterOption(filterCriteria);
        Waiter.waitUntilElementNoBeDisable(filterOptionSelector);
        searchPage.filterCriteria(filterCriteria).click();
        Waiter.waitUntilElementBeActive(filterOptionSelector);
    }

    @When("the user opens the first link with the template «{string} | <articleName>» in the search results")
    public void openSearchResultLink(String articleSection) {
        ArticleLink articleLink = searchPage.articleLink(articleSection);
        articleName = articleLink.getArticleName();
        articleLink.openLink();
    }

    @Then("the open page has title <articleName>")
    public void verifyIfPageTitleMatchArticleName() {
        String pageTitle = articlePage.pageTitle().getText();
        assertThat(pageTitle.equalsIgnoreCase(articleName)).
                overridingErrorMessage("The open page has title '%s' which doesn't match article name '%s'", pageTitle, articleName).
                isTrue();
    }
}

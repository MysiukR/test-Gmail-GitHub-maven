package com.epam.lab.pageobjects.github;

import com.epam.lab.decorator.LogMessage;
import com.epam.lab.decorator.PageElement;
import com.epam.lab.pageobjects.PageObject;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class GitPage extends PageObject {
  //  private WebDriver webDriver;
    private static final Logger logger = Logger.getLogger(GitPage.class.getName());
    @LogMessage("Search text in search bar")
    @FindBy(name = "q")
    private PageElement inputSearch;

    @LogMessage("Getting all name of repositories")
    @FindBy(css = "a.v-align-middle")
    private List<PageElement> nameRepositories;

    @LogMessage("Getting total result")
    @FindBy(css = "div.d-flex.flex-justify-between.border-bottom.pb-3 > h3")
    private PageElement totalResults;

    @LogMessage("Select button")
    @FindBy(className = "js-select-button")
    private PageElement btnSelectBox;

    @LogMessage("Change item to 'Fewest starts'")
    @FindBy(css = ".select-menu-list>a:nth-child(3)")
    private PageElement itemFewestStars;

    @LogMessage("Getting all tag with 'selenium'")
    @FindBy(css = "a.topic-tag.topic-tag-link.f6.my-1")
    private List<PageElement> tagSelenium;


    public List<PageElement> getTagSelenium() {
        return tagSelenium;
    }

    public void setTagSelenium(List<PageElement> tagSelenium) {
        this.tagSelenium = tagSelenium;
    }

    public PageElement getItemFewestStars() {
        return itemFewestStars;
    }

    public void setItemFewestStars(PageElement itemFewestStars) {
        this.itemFewestStars = itemFewestStars;
    }

    public PageElement getBtnSelectBox() {
        return btnSelectBox;
    }

    public void setBtnSelectBox(PageElement btnSelectBox) {
        this.btnSelectBox = btnSelectBox;
    }

    public PageElement getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(PageElement totalResults) {
        this.totalResults = totalResults;
    }

    public List<PageElement> getNameRepositories() {
        return nameRepositories;
    }

    public void setNameRepositories(List<PageElement> nameRepositories) {
        this.nameRepositories = nameRepositories;
    }

    public PageElement getInputSearch() {
        return inputSearch;
    }

    public void setInputSearch(PageElement inputSearch) {
        this.inputSearch = inputSearch;
    }
}

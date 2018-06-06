package com.epam.lab.businessobjects.Github;

import com.epam.lab.decorator.PageElement;
import com.epam.lab.decorator.PageElementList;
import com.epam.lab.pageobjects.github.GitPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;

import java.util.List;

import static com.epam.lab.utils.Constants.SELENIUM;

public class GitPageBO {

    GitPage gitPage = new GitPage();
    PageElementList pageElementList= new PageElementList();
    private static final Logger logger = Logger.getLogger(GitPage.class.getName());

    public void checkSearch(String searchText) {
        gitPage.getInputSearch().clear();
        gitPage.getInputSearch().sendKeys(searchText);
        gitPage.getInputSearch().sendKeys(Keys.ENTER);
    }

    public void outputTitle() {
        logger.info(String.format("There are %d repositories on the page.\n", getTotalCount()));
        logger.info("Name of repositories: ");
        gitPage.getNameRepositories().stream().forEach(element -> logger.info("\t" + element.getText()));
    }

    public void getTotalResult() {
        logger.info(String.format("Total count are %s", gitPage.getTotalResults().getText()));
    }

    private int getTotalCount() {
        return gitPage.getNameRepositories().size();
    }

    public void changeSortType() {
        gitPage.getBtnSelectBox().click();
        gitPage.getItemFewestStars().click();
    }

    public void checkTags() {
        List<PageElement> pageElements = pageElementList.getAllTags(gitPage.getTagSelenium(),SELENIUM);
        pageElements.forEach(element -> logger.info("Tag ["+SELENIUM+"] contain: " + element.getText()));
        int countTag = pageElementList.countTag(gitPage.getTagSelenium(),SELENIUM);
        logger.info(pageElementList.compareCounters(countTag,getTotalCount(),SELENIUM));
    }
}

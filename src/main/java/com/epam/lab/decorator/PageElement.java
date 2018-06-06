package com.epam.lab.decorator;

import com.epam.lab.utils.driver.WebDriverUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class PageElement implements WebElement {

    private WebElement webElement;
    private String name;
    private static final Logger lOG = Logger.getLogger(PageElement.class.getName());

    public PageElement(WebElement webElement) {
        this.webElement = webElement;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void click() {
        lOG.info("Click on [" + name + "]");
        webElement.click();
    }

    public void textOfElementShouldBeEqualTo(String text) {
        Assert.assertEquals(getText(), text, "Text of element [" + name + "] does not match");
    }

    public void submit() {
        webElement.submit();
    }

    public void sendKeys(CharSequence... keysToSend) {
        lOG.info("Sending keys to [" + name + "] value [" + Arrays.toString(keysToSend) + "]");
        webElement.sendKeys(keysToSend);
    }

    public void clear() {
        lOG.info("Clear [" + name + "]");
        webElement.clear();
    }

    public String getTagName() {
        lOG.info("Getting name of tag [" + name + "]");
        return webElement.getTagName();
    }

    public String getAttribute(String name) {
        lOG.info("Getting attribute [" + name + "]");
        return webElement.getAttribute(name);
    }

    public boolean isSelected() {
        lOG.info("Checking if element is selected [" + name + "]");
        return webElement.isSelected();
    }

    public boolean isEnabled() {
        lOG.info("Checking if element is enabled [" + name + "]");
        return webElement.isEnabled();
    }

    public String getText() {
        return webElement.getText();
    }

    public List<WebElement> findElements(By by) {
        lOG.info("Finding elements [" + name + "]");
        return webElement.findElements(by);
    }

    public WebElement findElement(By by) {
        lOG.info("Finding element [" + name + "]");
        return webElement.findElement(by);
    }

    public boolean isDisplayed() {
        lOG.info("Checking if element is displayed [" + name + "]");
        return webElement.isDisplayed();
    }

    public Point getLocation() {
        lOG.info("Getting element location [" + name + "]");
        return webElement.getLocation();
    }

    public Dimension getSize() {
        lOG.info("Getting size of element [" + name + "]");
        return webElement.getSize();
    }

    public Rectangle getRect() {
        lOG.info("Getting rect of element [" + name + "]");
        return webElement.getRect();
    }

    public String getCssValue(String propertyName) {
        lOG.info("Getting css value [" + name + "]");
        return webElement.getCssValue(propertyName);
    }

    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return webElement.getScreenshotAs(target);
    }

    public PageElement waitUntilVisible() {
        WebDriverUtils.newWait().until(ExpectedConditions.visibilityOf(this));
        return this;
    }

}

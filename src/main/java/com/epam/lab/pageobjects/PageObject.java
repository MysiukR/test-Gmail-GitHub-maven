package com.epam.lab.pageobjects;

import com.epam.lab.decoratorimpl.MyDefaultFieldDecorator;
import com.epam.lab.utils.driver.WebDriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public abstract class PageObject {
    protected final WebDriver driver;
    public PageObject() {
        this.driver = WebDriverUtils.getDriver(); //.getInstance().getDriverThreadLocal();
        PageFactory.initElements(
                new MyDefaultFieldDecorator(
                        new DefaultElementLocatorFactory(driver)
                ), this);
    }
}

package com.epam.lab.pageobjects.gmail;

import com.epam.lab.decorator.LogMessage;
import com.epam.lab.decorator.PageElement;
import com.epam.lab.pageobjects.PageObject;
import org.openqa.selenium.support.FindBy;

import static com.epam.lab.filereader.PropertyReader.urlGmail;

public class LoginPage extends PageObject {
    @LogMessage("'Next' after email")
    @FindBy(id = "identifierNext")
    private PageElement btnEmailNext;

    @LogMessage("'Next' after password")
    @FindBy(id = "passwordNext")
    private PageElement btnPasswordNext;

    @LogMessage("Button 'Sign in'")
    @FindBy(xpath = "//a[@data-g-label=\"Sign in\"]")
    private PageElement btnSignIn;

    @LogMessage("Typing email")
    @FindBy(xpath = "//input[@type='email']")
    private PageElement inputEmail;

    @LogMessage("Typing password")
    @FindBy(xpath = "//input[@name='password']")
    private PageElement inputPassword;

    @LogMessage("Getting text form icon")
    @FindBy(css = "div.gmail-nav__logo.gmail-logo")
    private PageElement iconText;


    public PageElement getBtnEmailNext() {
        return btnEmailNext;
    }

    public void setBtnEmailNext(PageElement btnEmailNext) {
        this.btnEmailNext = btnEmailNext;
    }

    public PageElement getBtnPasswordNext() {
        return btnPasswordNext;
    }

    public void setBtnPasswordNext(PageElement btnPasswordNext) {
        this.btnPasswordNext = btnPasswordNext;
    }

    public PageElement getBtnSignIn() {
        return btnSignIn;
    }

    public void setBtnSignIn(PageElement btnSignIn) {
        this.btnSignIn = btnSignIn;
    }

    public PageElement getInputEmail() {
        return inputEmail;
    }

    public void setInputEmail(PageElement inputEmail) {
        this.inputEmail = inputEmail;
    }

    public PageElement getInputPassword() {
        return inputPassword;
    }

    public void setInputPassword(PageElement inputPassword) {
        this.inputPassword = inputPassword;
    }

    public PageElement getIconText() {
        return iconText;
    }

    public void setIconText(PageElement iconText) {
        this.iconText = iconText;
    }

    public void getURL()
    {
        driver.get(urlGmail);
    }
}

package com.epam.lab.pageobjects.github;

import com.epam.lab.decorator.LogMessage;
import com.epam.lab.decorator.PageElement;
import com.epam.lab.pageobjects.PageObject;
import org.openqa.selenium.support.FindBy;

import static com.epam.lab.filereader.PropertyReader.urlGit;

public class LoginPage extends PageObject {
    @LogMessage("Button 'Sign in'")
    @FindBy(xpath = "//div[@class='HeaderNavlink px-0 py-2 m-0']/a[1]")
    private PageElement loginButton;

    @LogMessage("Input login in GitHub")
    @FindBy(id = "login_field")
    private PageElement loginGit;

    @LogMessage("Input password in GitHub")
    @FindBy(id = "password")
    private PageElement passwordGit;

    @LogMessage("Button 'Commit'")
    @FindBy(name = "commit")
    private PageElement btnSignIn;


    public PageElement getCommit() {
        return btnSignIn;
    }

    public void setCommit(PageElement btnSignIn) {
        this.btnSignIn = btnSignIn;
    }

    public PageElement getBtnSignIn() {
        return loginButton;
    }

    public void setBtnSignIn(PageElement loginButton) {
        this.loginButton = loginButton;
    }

    public PageElement getLoginGit() {
        return loginGit;
    }

    public void setLoginGit(PageElement loginGit) {
        this.loginGit = loginGit;
    }

    public PageElement getPasswordField() {
        return passwordGit;
    }

    public void setPasswordField(PageElement passwordGit) {
        this.passwordGit = passwordGit;
    }

    public void getURL()
    {
        driver.get(urlGit);
    }
}

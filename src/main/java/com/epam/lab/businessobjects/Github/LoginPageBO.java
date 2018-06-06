package com.epam.lab.businessobjects.Github;

import com.epam.lab.pageobjects.github.LoginPage;
import com.epam.lab.utils.driver.WebDriverUtils;
import org.testng.Assert;

import static com.epam.lab.filereader.PropertyReader.urlSessionPage;

public class LoginPageBO {
    LoginPage loginPage = new LoginPage();

    public void inputLogin(String login) {

        loginPage.getLoginGit().sendKeys(login);
    }

    public void inputPassword(String password) {
        loginPage.getPasswordField().sendKeys(password);
        isSignedIn();
    }

    public GitPageBO goToGitPage() {
        if (loginPage.getCommit().isDisplayed())
            loginPage.getCommit().click();
        isSignedIn();
        return new GitPageBO();
    }

    public void clickSignIn() {
        loginPage.getURL();
        loginPage.getBtnSignIn().click();
    }

    public void isSignedIn() {
        Assert.assertNotEquals(WebDriverUtils.getDriver().getCurrentUrl(),
                urlSessionPage, String.format("Invalid email or password! Not exist such user!"));
    }

}

package com.epam.lab.businessobjects.Gmail;

import com.epam.lab.pageobjects.gmail.LoginPage;
import org.openqa.selenium.WebElement;

public class LoginPageBO {
    private LoginPage loginPage = new LoginPage();


    public void clickSignIn() {
        loginPage.getURL();
        //Assert.assertEquals(loginPage.getIconText(), UNIQUE_TEXT, "Unsuccessful connection");
        loginPage.getBtnSignIn().click();
    }

    public void inputEmail(String email) {
        loginPage.getInputEmail().sendKeys(email);
        clickNext(loginPage.getBtnEmailNext());
    }

    public void clickNext(WebElement webElement) {
        webElement.click();
    }

    public void inputPassword(String password) {
        loginPage.getInputPassword().waitUntilVisible().sendKeys(password);
        clickNext(loginPage.getBtnPasswordNext());
    }

    public String getIconText() {
        return loginPage.getIconText().getText();
    }

    public GmailPageBO goToMainForm() {
        return new GmailPageBO();
    }

}

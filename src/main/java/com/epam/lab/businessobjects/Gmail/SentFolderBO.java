package com.epam.lab.businessobjects.Gmail;

import com.epam.lab.pageobjects.gmail.SentFolderPage;
import com.epam.lab.utils.driver.WebDriverUtils;
import org.testng.Assert;

public class SentFolderBO {
    private SentFolderPage sentFolderPage = new SentFolderPage();

    public void verifySentFolder(String email, String subject) {
        WebDriverUtils.getImplicitlyWait();
        Assert.assertEquals(email, sentFolderPage.getCurrentEmail().getAttribute("email"), "Email is not equal current email");
        Assert.assertEquals(subject, sentFolderPage.getCurrentSubject().getText(), "Subject is not equal current subject");
    }

    public void removeMessage() {
        chooseItemMessage();
        chooseDeleteButton();
        clickAlertOK();
    }


    private void clickAlertOK() {
        sentFolderPage.getAlertBtnOK().waitUntilVisible().click();
    }

    private void chooseDeleteButton() {
        WebDriverUtils.getImplicitlyWait();
        sentFolderPage.getBtnDelete().waitUntilVisible().click();
    }

    private void checkEnable() {
        boolean itemEnabled = sentFolderPage.getRemoveCheckBox().waitUntilVisible().isEnabled();
        Assert.assertEquals(true, itemEnabled, "Delete checkbox is not enabled");
    }

    private void checkDisplayed() {
        boolean itemDisplayed = sentFolderPage.getRemoveCheckBox().isDisplayed();
        Assert.assertEquals(true, itemDisplayed, "Delete checkbox is not dislayed");
    }

    private void chooseItemMessage() {
        checkEnable();
        checkDisplayed();
        sentFolderPage.getRemoveCheckBox().click();
    }
}

package com.epam.lab.businessobjects.Gmail;

import com.epam.lab.pageobjects.gmail.GmailPage;

public class GmailPageBO {
    GmailPage gmailPage = new GmailPage();

    public void clickCompose() {
        gmailPage.getBtnCompose().waitUntilVisible().click();
    }
    public SendMessageBO goToNewMessage()
    {
        return new SendMessageBO();
    }
}

package com.epam.lab.businessobjects.Gmail;

import com.epam.lab.pageobjects.gmail.SendMessagePage;
import com.epam.lab.utils.driver.WebDriverUtils;

public class SendMessageBO {
    private SendMessagePage sendMessagePage = new SendMessagePage();


    public void fillInMessage(String email, String subject, String message) {
        fillInRecipients(email);
        fillInSubject(subject);
        fillInText(message);
    }

    private void fillInSubject(String subject) {
        sendMessagePage.getInputSubject().sendKeys(subject);
    }

    private void fillInRecipients(String recipient) {
        WebDriverUtils.getImplicitlyWait();
        sendMessagePage.getInputRecipients().sendKeys(recipient);
    }

    private void fillInText(String message) {
        sendMessagePage.getInputMessageBody().sendKeys(message);
    }

    public void clickSent() {
        sendMessagePage.getBtnSend().click();
    }

    public SentFolderBO goToSentFolder() {
        sendMessagePage.getBtnSentFolder().click();
        return new SentFolderBO();
    }
}

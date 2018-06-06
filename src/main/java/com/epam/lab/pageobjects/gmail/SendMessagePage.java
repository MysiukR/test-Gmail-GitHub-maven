package com.epam.lab.pageobjects.gmail;

import com.epam.lab.decorator.LogMessage;
import com.epam.lab.decorator.PageElement;
import com.epam.lab.pageobjects.PageObject;
import org.openqa.selenium.support.FindBy;

public class SendMessagePage extends PageObject {
    @LogMessage("Button 'Send'")
    @FindBy(xpath = "//td/div/div[@role='button']")
    private PageElement btnSend;

    @LogMessage("Go to sent folder")
    @FindBy(xpath = "//div[3]/div/div/div[2]/span/a")
    private PageElement btnSentFolder;

    @LogMessage("Input subject")
    @FindBy(xpath = "//input[@name='subjectbox']")
    private PageElement inputSubject;

    @LogMessage("Input recipients")
    @FindBy(xpath = "//textarea[@name='to']")
    private PageElement inputRecipients;

    @LogMessage("Input message")
    @FindBy(xpath = "//tbody/tr/td[2]/div[2]/div")
    private PageElement inputMessageBody;


    public PageElement getInputMessageBody() {
        return inputMessageBody;
    }

    public void setInputMessageBody(PageElement inputMessageBody) {
        this.inputMessageBody = inputMessageBody;
    }

    public PageElement getInputRecipients() {
        return inputRecipients;
    }

    public void setInputRecipients(PageElement inputRecipients) {
        this.inputRecipients = inputRecipients;
    }

    public PageElement getInputSubject() {
        return inputSubject;
    }

    public void setInputSubject(PageElement inputSubject) {
        this.inputSubject = inputSubject;
    }

    public PageElement getBtnSentFolder() {
        return btnSentFolder;
    }

    public void setBtnSentFolder(PageElement btnSentFolder) {
        this.btnSentFolder = btnSentFolder;
    }

    public PageElement getBtnSend() {
        return btnSend;
    }

    public void setBtnSend(PageElement btnSend) {
        this.btnSend = btnSend;
    }
}

package com.epam.lab.pageobjects.gmail;

import com.epam.lab.decorator.LogMessage;
import com.epam.lab.decorator.PageElement;
import com.epam.lab.pageobjects.PageObject;
import org.openqa.selenium.support.FindBy;

public class SentFolderPage extends PageObject {
    @LogMessage("Getting current subject")
    @FindBy(xpath = "(//div[@role=\"main\"]/div[3]//td[6]//span)[1]")
    private PageElement currentSubject;

    @LogMessage("Getting current email")
    @FindBy(xpath = "(//div[@role=\"main\"]/div[3]//td[4]/div[2]/span[@email])[1]")
    private PageElement currentEmail;

    @LogMessage("Checking item for remove")
    @FindBy(xpath = "(//div[@role=\"main\"]/div[3]//td[2]/div)[1]")
    private PageElement removeCheckBox;

    @LogMessage("Button 'Delete'")
    @FindBy(xpath = "(//div//div[2]/div[@act=10])[2]")
    private PageElement btnDelete;

    @LogMessage("Click 'Ok' in alert message")
    @FindBy(xpath = "//button[@name='ok']")
    private PageElement alertBtnOK;


    public PageElement getAlertBtnOK() {
        return alertBtnOK;
    }

    public void setAlertBtnOK(PageElement alertBtnOK) {
        this.alertBtnOK = alertBtnOK;
    }

    public PageElement getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(PageElement btnDelete) {
        this.btnDelete = btnDelete;
    }

    public PageElement getRemoveCheckBox() {
        return removeCheckBox;
    }

    public void setRemoveCheckBox(PageElement removeCheckBox) {
        this.removeCheckBox = removeCheckBox;
    }

    public PageElement getCurrentEmail() {
        return currentEmail;
    }

    public void setCurrentEmail(PageElement currentEmail) {
        this.currentEmail = currentEmail;
    }

    public PageElement getCurrentSubject() {
        return currentSubject;
    }

    public void setCurrentSubject(PageElement currentSubject) {
        this.currentSubject = currentSubject;
    }
}

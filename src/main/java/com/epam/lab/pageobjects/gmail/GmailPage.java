package com.epam.lab.pageobjects.gmail;

import com.epam.lab.decorator.LogMessage;
import com.epam.lab.decorator.PageElement;
import com.epam.lab.pageobjects.PageObject;
import org.openqa.selenium.support.FindBy;

public class GmailPage extends PageObject {
    @LogMessage("Button 'Compose'")
    @FindBy(css = "div[gh='cm']")
    private PageElement btnCompose;


    public PageElement getBtnCompose() {
        return btnCompose;
    }

    public void setBtnCompose(PageElement btnCompose) {
        this.btnCompose = btnCompose;
    }
}

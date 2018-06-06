package com.epam.lab;

import com.epam.lab.businessobjects.Gmail.GmailPageBO;
import com.epam.lab.businessobjects.Gmail.LoginPageBO;
import com.epam.lab.businessobjects.Gmail.SendMessageBO;
import com.epam.lab.businessobjects.Gmail.SentFolderBO;
import com.epam.lab.filereader.PropertyReader;
import com.epam.lab.filereader.XSLReader;
import com.epam.lab.utils.driver.WebDriverUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.*;

import static com.epam.lab.filereader.PropertyReader.pathLoggerProperties;
@Listeners(com.epam.lab.utils.CustomListener.class)
public class TestGmail {
    private static final Logger logger = Logger.getLogger(TestGmail.class.getName());
    private PropertyReader propertyReader;
    private GmailPageBO gmailPageBO;
    private LoginPageBO loginPageBO;
    private SendMessageBO sendMessagePageBO;
    private SentFolderBO sentFolderPageBO;
    private String login;
    private String password;
    private String sendTo;
    private String subject;
    private String message;

    public TestGmail() {
    }


    @Factory(dataProvider = "currentDataProvider")
    public TestGmail(String login, String password, String sendTo, String subject, String message) {
        this.login = login;
        this.password = password;
        this.sendTo = sendTo;
        this.subject = subject;
        this.message = message;
    }

    @DataProvider(name = "currentDataProvider", parallel = true)
    public Object[][] initUsers() {
        XSLReader xslReader = new XSLReader();
        return xslReader.readXSLfile();
    }

    @Test
    public void testGmail() {
        logger.info("User [email= " + login + " , password= " + password +
                ", send to= " + sendTo + " , subject=" + subject + " , message=" + message + "]");
        propertyReader = new PropertyReader();
        loginPageBO = new LoginPageBO();
        propertyReader.readProperties();
        PropertyConfigurator.configure(pathLoggerProperties);
        logger.info("Initialize properties and go to website");
        logger.info("Running tests");
        logger.info("Test sign in to Gmail");
        loginPageBO.clickSignIn();
        loginPageBO.inputEmail(login);
        loginPageBO.inputPassword(password);
        gmailPageBO = loginPageBO.goToMainForm();
        gmailPageBO.clickCompose();
        sendMessagePageBO = gmailPageBO.goToNewMessage();
        sendMessagePageBO.fillInMessage(sendTo, subject, message);
        sendMessagePageBO.clickSent();
        sendMessagePageBO.goToSentFolder();
        sentFolderPageBO = sendMessagePageBO.goToSentFolder();
        sentFolderPageBO.verifySentFolder(sendTo, subject);
        sentFolderPageBO.removeMessage();
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        logger.info("Close browser");
        WebDriverUtils.removeDriver();
    }
}

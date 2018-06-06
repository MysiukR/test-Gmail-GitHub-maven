package com.epam.lab;

import com.epam.lab.businessobjects.Github.GitPageBO;
import com.epam.lab.businessobjects.Github.LoginPageBO;
import com.epam.lab.filereader.PropertyReader;
import com.epam.lab.utils.driver.WebDriverUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.epam.lab.filereader.PropertyReader.pathLoggerProperties;
import static com.epam.lab.utils.Constants.*;

@Listeners(com.epam.lab.utils.CustomListener.class)
public class TestGitFailed {
    private static final Logger logger = Logger.getLogger(TestGitFailed.class.getName());

    private LoginPageBO loginPageBO;
    private GitPageBO gitPageBO;
    private PropertyReader propertyReader;

    public TestGitFailed() {
    }

    @Test
    public void GitHubTest() {
        logger.info("User [email= " + INVALID_USER + " , password=" + INVALID_PASSWORD + "]");
        propertyReader = new PropertyReader();
        propertyReader.readProperties();
        PropertyConfigurator.configure(pathLoggerProperties);
        loginPageBO = new LoginPageBO();
        loginPageBO.clickSignIn();
        loginPageBO.inputLogin(INVALID_USER);
        loginPageBO.inputPassword(INVALID_PASSWORD);
        gitPageBO = loginPageBO.goToGitPage();
        gitPageBO.checkSearch(TEXT_SELENIUM_JAVA);
        gitPageBO.getTotalResult();
        gitPageBO.outputTitle();
        gitPageBO.checkTags();
        gitPageBO.changeSortType();
        gitPageBO.outputTitle();
        gitPageBO.checkSearch(TEXT_JAVA);
        gitPageBO.getTotalResult();
        gitPageBO.outputTitle();
    }

    @AfterClass
    public void closeBrowser() {
        WebDriverUtils.removeDriver();
    }
}

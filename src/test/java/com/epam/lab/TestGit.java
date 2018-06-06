package com.epam.lab;

import com.epam.lab.businessobjects.Github.GitPageBO;
import com.epam.lab.businessobjects.Github.LoginPageBO;
import com.epam.lab.filereader.CSVReader;
import com.epam.lab.filereader.PropertyReader;
import com.epam.lab.utils.driver.WebDriverUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.*;

import static com.epam.lab.filereader.PropertyReader.pathLoggerProperties;
import static com.epam.lab.utils.Constants.TEXT_JAVA;
import static com.epam.lab.utils.Constants.TEXT_SELENIUM_JAVA;

@Listeners(com.epam.lab.utils.CustomListener.class)
public class TestGit {
    private static final Logger logger = Logger.getLogger(TestGit.class.getName());
    private LoginPageBO loginPageBO;
    private GitPageBO gitPageBO;
    private PropertyReader propertyReader;
    private String login;
    private String password;

    public TestGit() {
    }

    @Factory(dataProvider = "currentDataProvider")
    public TestGit(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @DataProvider(name = "currentDataProvider",parallel = true)
    public Object[][] dataProvider() {
        CSVReader csvReader = new CSVReader();
       return csvReader.readCSVfile();
    }

    @Test
    public void GitHubTest() {
        logger.info("User [email= " + login + " , password=" + password + "]");
        propertyReader = new PropertyReader();
        propertyReader.readProperties();
        PropertyConfigurator.configure(pathLoggerProperties);
        loginPageBO = new LoginPageBO();
        loginPageBO.clickSignIn();
        loginPageBO.inputLogin(login);
        loginPageBO.inputPassword(password);
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

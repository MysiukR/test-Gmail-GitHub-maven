package com.epam.lab.filereader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.epam.lab.utils.Constants.PATH_TO_PROPERTIES;

public class PropertyReader {
    public static String driverName;
    public static String pathChromeDriver;
    public static String pathLoggerProperties;
    public static String usersGmailPath;
    public static String usersGitHubPath;
    public static String invalidUsersGitHubPath;
    public static String urlGmail;
    public static String urlGit;
    public static String urlSessionPage;

    public void readProperties() {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(PATH_TO_PROPERTIES)) {
            properties.load(fis);
            initPath(properties);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initPath(Properties properties) {
        pathChromeDriver = properties.getProperty("chromeDriverPath.value");
        pathLoggerProperties = properties.getProperty("loggerPath.value");
        urlGmail = properties.getProperty("urlGmail.value");
        urlGit = properties.getProperty("urlGit.value");
        urlSessionPage = properties.getProperty("sessionPage.value");
        driverName = properties.getProperty("driver.value");
        usersGmailPath = properties.getProperty("usersGmailXMLPath.value");
        usersGitHubPath= properties.getProperty("usersGitHubCSVPath.value");
        invalidUsersGitHubPath = properties.getProperty("invalidUsersGitHubCSVPath.value");
    }
}

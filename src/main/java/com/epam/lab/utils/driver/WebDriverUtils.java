package com.epam.lab.utils.driver;


import com.epam.lab.filereader.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static com.epam.lab.filereader.PropertyReader.driverName;
import static com.epam.lab.filereader.PropertyReader.pathChromeDriver;
import static com.epam.lab.utils.Constants.TIME_FOR_WAITING;

public class WebDriverUtils {
    private static PropertyReader propertyReader;
    private static ThreadLocal<WebDriver> webDriver = ThreadLocal.withInitial(() -> {
        propertyReader = new PropertyReader();
        propertyReader.readProperties();
        System.setProperty(driverName, pathChromeDriver);
        return new ChromeDriver();
    });

    public static WebDriver getDriver() {
        return webDriver.get();
    }

    public static void getURL(String URL) {
        getDriver().get(URL);
    }

    public static void removeDriver() {
        webDriver.get().quit();
        webDriver.remove();
    }

    public static WebDriverWait newWait() {
        return new WebDriverWait(getDriver(), 10);
    }

    public static void getImplicitlyWait() {
        getDriver().manage().timeouts().implicitlyWait(TIME_FOR_WAITING, TimeUnit.SECONDS);
    }
}
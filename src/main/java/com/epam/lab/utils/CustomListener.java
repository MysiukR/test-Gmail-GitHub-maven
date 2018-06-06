package com.epam.lab.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import static com.epam.lab.utils.Constants.LINE;


public class CustomListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        log(String.format("I am in %s method %s start", getTestClassName(iTestResult), getTestMethodName(iTestResult)));
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log(String.format("I am in %s method %s succeed", getTestClassName(iTestResult), getTestMethodName(iTestResult)));

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        log(String.format("I am in %s method %s failed", getTestClassName(iTestResult), getTestMethodName(iTestResult)));

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        log(String.format("I am in %s method %s skipped", getTestClassName(iTestResult), getTestMethodName(iTestResult)));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        log(String.format("Test failed but it is in defined success ratio %s in %s", getTestMethodName(iTestResult), getTestClassName(iTestResult)));
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        log(String.format("I am in onStart method %s on %s",  iTestContext.getName(), iTestContext.getStartDate()));
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        log(String.format("I am in onFinish method %s on %s", iTestContext.getName(),iTestContext.getEndDate()));
        log(LINE);
    }

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    private static String getTestClassName(ITestResult iTestResult) {
        return iTestResult.getTestClass().getName();
    }

    private void log(String text) {
        Reporter.log(String.format("%s<br>", text));
    }

}

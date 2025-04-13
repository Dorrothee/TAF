package org.epamLab.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.epamLab.utils.ScreenshotUtil;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class ScreenshotListener implements ITestListener {
    private static final Logger logger = LogManager.getLogger(ScreenshotListener.class);

    @Override
    public void onTestFailure(ITestResult result) {
        Object testInstance = result.getInstance(); //Get the test class instance dynamically
        WebDriver driver = null;

        try {
            //Use reflection to fetch the 'driver' field from the test class
            java.lang.reflect.Field driverField = testInstance.getClass().getDeclaredField("driver");
            driverField.setAccessible(true); //Allow access even if 'driver' is private or protected
            driver = (WebDriver) driverField.get(testInstance);

            if (driver != null) {
                String testName = result.getName(); //Get the name of the failed test
                String screenshotPath = ScreenshotUtil.captureScreenshot(driver, testName); //Save screenshot
                logger.error("Test '{}' failed. Screenshot saved at: {}", testName, screenshotPath);
            } else {
                logger.error("WebDriver instance is null for test: '{}'", result.getName());
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            //Handle errors while retrieving the 'driver' field
            logger.error("Failed to access WebDriver instance for test '{}': {}", result.getName(), e.getMessage());
        } catch (IOException e) {
            //Handle errors during screenshot capture
            logger.error("Failed to capture screenshot for test '{}': {}", result.getName(), e.getMessage());
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Test '{}' passed successfully.", result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        logger.info("Test context '{}' started.", context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("Test context '{}' finished.", context.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn("Test '{}' was skipped.", result.getName());
    }
}
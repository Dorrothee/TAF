package org.epamLab.listeners;

import com.epam.reportportal.service.ReportPortal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.epamLab.utils.ScreenshotUtil;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.util.Date;

public class ScreenshotListener implements ITestListener {
    private static final Logger logger = LogManager.getLogger(ScreenshotListener.class);

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = null;

        //Get WebDriver from the TestNG context
        if (result.getTestContext().getAttribute("driver") != null) {
            driver = (WebDriver) result.getTestContext().getAttribute("driver");
        }

        if (driver != null) {
            try {
                String testName = result.getName(); //Get the name of the failed test
                String screenshotPath = ScreenshotUtil.captureScreenshot(driver, testName); //Save screenshot
                logger.error("Test '{}' failed. Screenshot saved at: {}", testName, screenshotPath);

                //Send screenshot as attachment to ReportPortal
                File screenshotFile = new File(screenshotPath);
                if (screenshotFile.exists()) {
                    ReportPortal.emitLog("Screenshot on failure", "ERROR", new Date(), screenshotFile);
                }
            } catch (Exception e) {
                logger.error("WebDriver instance is null for test: '{}'", result.getName());
            }
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
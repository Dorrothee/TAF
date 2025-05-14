package org.epamLab.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    private static final Logger logger = LogManager.getLogger(ScreenshotUtil.class);

    public static String captureScreenshot(WebDriver driver, String testName) throws IOException {
        //Generate timestamp for unique filenames
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotName = "src/test/resources/screenshots/" + testName + "_" + timestamp + ".png";
        File screenshotDir = new File("src/test/resources/screenshots");
        if (!screenshotDir.exists() && !screenshotDir.mkdirs()) {
            throw new IOException("Could not create directory: " + screenshotDir.getAbsolutePath());
        }

        //Take the screenshot
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File(screenshotName);
        org.apache.commons.io.FileUtils.copyFile(srcFile, destFile); //Copy the file

        logger.info("Screenshot saved successfully: {}", destFile.getAbsolutePath());
        return destFile.getAbsolutePath();
    }
}
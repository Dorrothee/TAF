package org.epamLab.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class DriverManager {

    private static WebDriver driver;

    private DriverManager() {
    }

    public static WebDriver getDriver(String browser) { //Accept browser type as an argument
        if (driver == null) {
            switch (browser.toLowerCase()) {
                case "firefox":
//                    WebDriverManager.firefoxdriver().setup();
//                    driver = new FirefoxDriver();
//                    break;
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("--headless");  // headless mode
                    firefoxOptions.addArguments("--disable-gpu");  // often needed in CI environments
                    firefoxOptions.addArguments("--window-size=1920,1080");  // Optional, to avoid headless mode issues
                    driver = new FirefoxDriver(firefoxOptions);
                    break;
                case "edge":
//                    WebDriverManager.edgedriver().setup();
//                    driver = new EdgeDriver();
//                    break;
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("--headless");  // headless mode
                    edgeOptions.addArguments("--disable-gpu");  // often needed in CI environments
                    edgeOptions.addArguments("--window-size=1920,1080");  // Optional, to avoid headless mode issues
                    driver = new EdgeDriver(edgeOptions);
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
                default: // Default to Chrome
//                    WebDriverManager.chromedriver().setup();
//                    driver = new ChromeDriver();
//                    break;
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--headless");  // headless mode
                    chromeOptions.addArguments("--disable-gpu");  // often needed in CI environments
                    chromeOptions.addArguments("--window-size=1920,1080");  // Optional, to avoid headless mode issues
                    driver = new ChromeDriver(chromeOptions);
                    break;
            }
        }
        driver.manage().window().maximize();
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
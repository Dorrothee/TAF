package base;

import lombok.Getter;
import org.epamLab.driver.DriverManager;
import org.epamLab.utils.EnvironmentProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;


public class BaseTestRunner {
    @Getter
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected static EnvironmentProperties envProps;

    @BeforeSuite(alwaysRun = true)
    @Parameters({"environment"})
    public void beforeSuite(String environment) {
        envProps = new EnvironmentProperties(environment);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        String browser = envProps.getProperty("browser");
        driver = DriverManager.getDriver(browser);
        driver.manage().window().maximize();
        driver.get(envProps.getProperty("baseUrl"));
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        DriverManager.quitDriver();
    }

    protected void waitForElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}

package base;

import lombok.Getter;
import org.epamLab.driver.DriverManager;
import org.epamLab.utils.EnvironmentProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;


public class BaseTestRunner {
    @Getter
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected static EnvironmentProperties envProps;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        //Pick up -Denvironment from Maven; default to "test"
        String env = System.getProperty("environment", "test");
        envProps = new EnvironmentProperties(env);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(ITestContext context) {
        //Pick up -Dbrowser; fallback to what’s in your .properties file
        String browser = System.getProperty("browser",
                envProps.getProperty("browser"));
        driver = DriverManager.getDriver(browser);
        driver.manage().window().maximize();
        driver.get(envProps.getProperty("baseUrl"));

        //Initialize wait after the driver
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Set WebDriver in the context
        context.setAttribute("driver", driver);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        DriverManager.quitDriver();
    }

    protected void waitForElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}

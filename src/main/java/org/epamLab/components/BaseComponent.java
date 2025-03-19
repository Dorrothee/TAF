package org.epamLab.components;

import org.epamLab.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class BaseComponent extends Base {

    protected WebDriver driver;
    protected WebElement rootElement;

    public BaseComponent(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public BaseComponent(WebDriver driver, WebElement rootElement) {
        super(driver);
        this.driver = driver;
        this.rootElement = rootElement;

        PageFactory.initElements(new DefaultElementLocatorFactory(rootElement), this);
    }
}

package org.epamLab.pages;


import org.epamLab.components.header.HeaderComponent;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HeaderComponent getHeader() {
        return headerComponent;
    }
}

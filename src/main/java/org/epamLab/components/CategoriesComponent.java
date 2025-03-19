package org.epamLab.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CategoriesComponent extends BaseComponent {

    @FindBy(css = "#menu-secondary-menu li a")
    protected List<WebElement> categoryLinks;

    public CategoriesComponent(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void selectCategory(String categoryName) {
        for (WebElement category : categoryLinks) {
            waitForElementToBeVisible(category);
            if (category.getText().trim().equalsIgnoreCase(categoryName)) {
                clickElement(category);
                return;
            }
        }
        throw new RuntimeException("Category '" + categoryName + "' not found in the navigation menu.");
    }

}

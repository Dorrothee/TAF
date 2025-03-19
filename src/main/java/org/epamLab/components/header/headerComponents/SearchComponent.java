package org.epamLab.components.header.headerComponents;

import org.epamLab.components.BaseComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchComponent extends BaseComponent {

    @FindBy(css = "div.aside-right div.custom-search .aws-container form.aws-search-form:nth-of-type(1) input[type='search']")
    protected WebElement searchBar;

    @FindBy(css = "#aws-search-result-1 li:nth-child(1)")
    protected WebElement desiredProduct;

    public SearchComponent(WebDriver driver) {
        super(driver);
    }

    public void enterSearchQuery(String query) {
        enterText(searchBar, query);
    }

    public void searchProduct(String product) {
        waitForElementToBeClickable(searchBar);
        enterSearchQuery(product);
        clickElement(desiredProduct);
    }
}

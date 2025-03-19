package org.epamLab.pages;

import org.epamLab.components.categoryProducts.ProductGridComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryPage extends BasePage{

    @FindBy(css = "div.os-breadcrumb nav.woocommerce-breadcrumb")
    protected WebElement breadcrumb;

    protected ProductGridComponent productGridComponent;

    public CategoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.productGridComponent = new ProductGridComponent(driver);
    }

    public boolean isCategorySelected(String expectedCategoryName) {
        return breadcrumb.getText().trim().endsWith(expectedCategoryName);
    }

    public void openProduct(String product) {
        productGridComponent.openProductPage(product);
    }

}

package org.epamLab.components.categoryProducts;

import org.epamLab.components.BaseComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ProductGridComponent extends BaseComponent {

    protected WebDriver driver;

    @FindBy(css = "ul.products li.product")
    protected List<WebElement> productElements;

    protected List<ProductItemComponent> productContainers;

    public ProductGridComponent(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public List<ProductItemComponent> getAllProducts() {
        if (productContainers == null) {
            productContainers = new ArrayList<>();
            for (WebElement element : productElements) {
                productContainers.add(new ProductItemComponent(driver, element));
            }
        }
        return productContainers;
    }

    public void openProductPage(String productName) {
        for (ProductItemComponent product : getAllProducts()) {
            if (product.getTitle().equalsIgnoreCase(productName)) {
                product.gotToProductPage();
                break;
            }
        }
    }
}

package org.epamLab.pages;

import lombok.Getter;
import org.epamLab.components.header.HeaderComponent;
import org.epamLab.components.product.ImageComponent;
import org.epamLab.components.product.ProductInfoComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage{

    protected ImageComponent imageComponent;
    @Getter
    protected ProductInfoComponent productInfoComponent;

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.imageComponent = new ImageComponent(driver);
        this.productInfoComponent = new ProductInfoComponent(driver);
    }

    public HeaderComponent getHeader() {
        return headerComponent;
    }

    public boolean isProductSelected(String product) {
        return productInfoComponent.getTitle().getText().equals(product);
    }
}

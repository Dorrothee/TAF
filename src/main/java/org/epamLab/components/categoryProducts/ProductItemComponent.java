package org.epamLab.components.categoryProducts;

import org.epamLab.components.BaseComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductItemComponent extends BaseComponent {

    @FindBy(css = "ul.products li.product div.product-thumb-wrap")
    protected WebElement productItemContainer;

    @FindBy(css = "div.product-info-wrap h3.woocommerce-loop-product__title")
    protected WebElement productItemTitle;

    @FindBy(css = "div.product-info-wrap span.price")
    protected WebElement productItemPrice;

    @FindBy(css = "div.product-info-wrap div.custom-cart-btn")
    protected WebElement addToCartButton;

    public ProductItemComponent(WebDriver driver, WebElement productContainer) {
        super(driver, productContainer);
    }

    public String getTitle() {
        return productItemTitle.getText();
    }

    public String getPrice() {
        return productItemPrice.getText();
    }

    public void addToCart() {
        clickElement(addToCartButton);
    }

    public void gotToProductPage() {
        clickElement(productItemContainer);
    }
}

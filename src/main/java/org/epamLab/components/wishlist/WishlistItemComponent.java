package org.epamLab.components.wishlist;

import lombok.Getter;
import org.epamLab.components.BaseComponent;
import org.epamLab.components.product.QuantityProductComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishlistItemComponent extends BaseComponent {

    @FindBy(css = ".wishlist_item .product-remove button[type=\"submit\"]")
    protected WebElement removeItem;

    @FindBy(css = ".wishlist_item .product-thumbnail img")
    protected WebElement productImage;

    @FindBy(css = ".wishlist_item .product-name a")
    protected WebElement productName;

    @FindBy(css = ".wishlist_item .product-price")
    protected WebElement productPrice;

    @FindBy(css = ".product-action .button.alt")
    protected WebElement addToCartButton;

    @Getter
    protected QuantityProductComponent quantityProductComponent;

    public WishlistItemComponent(WebDriver driver, WebElement rootElement) {
        super(driver, rootElement);
        this.quantityProductComponent = new QuantityProductComponent(driver);
    }

    public void clickRemoveButton() {
        clickElement(removeItem);
    }

    public String getProductName() {
        return productName.getText();
    }

    public String getProductPrice() {
        return productPrice.getText();
    }

    public void clickAddToCartButton() {
        clickElement(addToCartButton);
    }

    public String getProductImageURL() {
        return productImage.getAttribute("src");
    }
}

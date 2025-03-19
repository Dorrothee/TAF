package org.epamLab.components.product;

import lombok.Getter;
import org.epamLab.components.BaseComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoComponent extends BaseComponent {

    @Getter
    @FindBy(css = ".product_title.entry-title")
    protected WebElement title;

    @Getter
    @FindBy(css = "p.price")
    protected WebElement price;

    @FindBy(css = "button.single_add_to_cart_button.button.alt")
    protected WebElement addToCartButton;

    @FindBy(xpath = "//span[contains(@class, 'add_to_wishlist')]")
    protected WebElement addToWishlistButton;

    @Getter
    protected QuantityProductComponent quantityProductComponent;

    public ProductInfoComponent(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.quantityProductComponent = new QuantityProductComponent(driver);
    }

    public void addToWishlist() {
        clickElement(addToWishlistButton);
    }

    public void addToCart() {
        clickElement(addToCartButton);
    }

}

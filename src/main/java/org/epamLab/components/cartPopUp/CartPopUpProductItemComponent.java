package org.epamLab.components.cartPopUp;

import lombok.Getter;
import org.epamLab.components.BaseComponent;
import org.epamLab.components.product.QuantityProductComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPopUpProductItemComponent extends BaseComponent {

    @FindBy(css = "div.cpops-cart-item__product--link a")
    protected WebElement productTitle;

    @FindBy(css = "div.cpops-cart-item__image a img")
    protected WebElement productImage;

    @Getter
    protected QuantityProductComponent quantityProductComponent;

    @FindBy(css = "div.cpops-price span.woocommerce-Price-amount.amount")
    protected WebElement productPrice;

    @FindBy(css = "button.cpops-cart-item__actions--remove")
    protected WebElement removeCartItemButton;

    public CartPopUpProductItemComponent(WebDriver driver) {
        super(driver);
        this.quantityProductComponent = new QuantityProductComponent(driver);
        PageFactory.initElements(driver, this);
    }

    public String getProductTitle() {
        return productTitle.getText();
    }

    public String getProductImageURL() {
        return productImage.getAttribute("src");
    }

    public String getProductPrice() {
        return productPrice.getText();
    }

    public void removeCardItem() {
        clickElement(removeCartItemButton);
    }

}

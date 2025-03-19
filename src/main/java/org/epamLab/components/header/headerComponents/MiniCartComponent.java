package org.epamLab.components.header.headerComponents;

import org.epamLab.components.BaseComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MiniCartComponent extends BaseComponent {

    @FindBy(css = "div.wishlist-minicart-wrapper button.fly-cart-btn")
    protected WebElement cartButton;

    @FindBy(css = "div.wishlist-minicart-wrapper span.cart-amount span.price")
    protected WebElement totalSum;

    public MiniCartComponent(WebDriver driver) {
        super(driver);
    }

    public void toCart() {
        clickElement(cartButton);
    }

    public String getTotalSum() {
        return totalSum.getText();
    }
}

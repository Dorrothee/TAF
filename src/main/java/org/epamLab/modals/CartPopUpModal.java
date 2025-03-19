package org.epamLab.modals;

import lombok.Getter;
import org.epamLab.components.BaseComponent;
import org.epamLab.components.cartPopUp.CartPopUpProductItemComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPopUpModal extends BaseComponent {

    @FindBy(xpath = "//*[@id='cartpops-drawer']")
    protected WebElement cartPopUpContainer;

    @FindBy(css = "div.cpops-drawer-header__title")
    protected WebElement cartPopUpTitle;

    @FindBy(css = "button.cpops-drawer-header__close")
    protected WebElement closeCartPopUpButton;

    @FindBy(css = ".cpops-drawer-footer #continueShopping")
    protected WebElement continueShoppingButton;

    @FindBy(css = "span.cpops-cart-line-items__value .woocommerce-Price-amount.amount")
    protected WebElement totalPrice;

    @FindBy(css = ".wc-proceed-to-checkout .checkout-button.wc-forward")
    protected WebElement makeOrder;

    @Getter
    protected CartPopUpProductItemComponent cartPopUpProductItemComponent;

    public CartPopUpModal(WebDriver driver) {
        super(driver);
        this.cartPopUpProductItemComponent = new CartPopUpProductItemComponent(driver);
    }

    public void waitForModalToAppear() {
        waitForElementToBeVisible(cartPopUpContainer);
    }

    public void closeCartPopUpModal() {
        clickElement(closeCartPopUpButton);
    }
}

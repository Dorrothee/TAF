package org.epamLab.components.product;

import org.epamLab.components.BaseComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuantityProductComponent extends BaseComponent {

    @FindBy(css = "button.woo-quantity-btn.woo-quantity-minus")
    protected WebElement minusButton;

    @FindBy(css = "input.input-text.qty.text")
    protected WebElement quantityInput;

    @FindBy(css = "button.woo-quantity-btn.woo-quantity-plus")
    protected WebElement plusButton;

    public QuantityProductComponent(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void increaseQuantity() {
        clickElement(plusButton);
    }

    public void decreaseQuantity() {
        clickElement(minusButton);
    }

    public void setQuantity(int quantity) {
        enterText(quantityInput, String.valueOf(quantity));
    }

}

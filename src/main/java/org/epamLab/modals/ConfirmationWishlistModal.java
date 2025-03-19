package org.epamLab.modals;

import org.epamLab.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationWishlistModal extends Base {

    @FindBy(css = ".tinv-modal-inner")
    protected WebElement modalContainer;

    @FindBy(css = ".tinv-txt")
    protected WebElement confirmationText;

    @FindBy(css = "button.tinvwl_button_view.tinvwl-btn-onclick")
    protected WebElement goToWishList;

    @FindBy(css = "button.tinvwl_button_close")
    protected WebElement closeBtn;

    public ConfirmationWishlistModal(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void waitForModalToAppear() {
        waitForElementToBeVisible(modalContainer);
    }

    public String getConfirmationText() {
        waitForModalToAppear();
        waitForElementToBeVisible(confirmationText);
        return confirmationText.getText();
    }

    public void clickGoToWishList() {
        clickElement(goToWishList);
    }

    public void clickClose() {
        clickElement(closeBtn);
    }

}

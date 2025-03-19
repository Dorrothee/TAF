package org.epamLab.components.header.headerComponents;

import org.epamLab.components.BaseComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MidHeader extends BaseComponent {

    @FindBy(css = "div.os-col.logo-col")
    protected WebElement logoIcon;

    SearchComponent searchComponent;

    MiniCartComponent miniCartComponent;

    @FindBy(xpath = "//div[@class='wishlist-minicart-wrapper']//a[@href='https://samguk.com.ua/my-account/']")
    protected WebElement profileButton;

    @FindBy(xpath = "//div[@class='wishlist-minicart-wrapper']//a[@href='https://samguk.com.ua/wishlist/']")
    protected WebElement wishlistButton;

    public MidHeader(WebDriver driver) {
        super(driver);
        this.searchComponent = new SearchComponent(driver);
        this.miniCartComponent = new MiniCartComponent(driver);
        PageFactory.initElements(driver, this);
    }

    public void goToHomePage() {
        clickElement(logoIcon);
    }

    public void searchProduct(String productName) {
        searchComponent.searchProduct(productName);
    }

    public void toProfile() {
        clickElement(profileButton);
    }

    public void toWishlist() {
        clickElement(profileButton);
    }
}

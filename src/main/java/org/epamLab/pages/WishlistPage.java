package org.epamLab.pages;

import org.epamLab.components.wishlist.WishlistGridComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishlistPage extends BasePage {

    protected WishlistGridComponent wishlistGridComponent;

    @FindBy(css = "table.tinvwl-table-manage-list")
    protected WebElement gridRootElement;

    public WishlistPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WishlistGridComponent getWishlistGridComponent(){
        if(wishlistGridComponent == null){
            wishlistGridComponent = new WishlistGridComponent(driver, gridRootElement);
        }
        return wishlistGridComponent;
    }

    public String getWishlistedProductTitle(String wishlistedProduct) {
        return getWishlistGridComponent()
                .findProductByTitle(wishlistedProduct)
                .getProductName();
    }
}

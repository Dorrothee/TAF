package org.epamLab.components.header;

import org.epamLab.components.BaseComponent;
import org.epamLab.components.CategoriesComponent;
import org.epamLab.components.header.headerComponents.BottomHeader;
import org.epamLab.components.header.headerComponents.MidHeader;
import org.openqa.selenium.WebDriver;

public class HeaderComponent extends BaseComponent {

    protected MidHeader midHeader;
    protected BottomHeader bottomHeader;

    public HeaderComponent(WebDriver driver) {
        super(driver);
        this.midHeader = new MidHeader(driver);
        this.bottomHeader = new BottomHeader(driver);
    }

    //Access to MidHeader functionalities
    public void goToHomePage() {
        midHeader.goToHomePage();
    }

    public void searchProduct(String productName) {
        midHeader.searchProduct(productName);
    }

    public void toProfile() {
        midHeader.toProfile();
    }

    public void toWishlist() {
        midHeader.toWishlist();
    }

    //Access to BottomHeader functionalities
    public CategoriesComponent openCategories() {
        return bottomHeader.getCategories();
    }

    public void clickSpringSale() {
        bottomHeader.getSpringSales();
    }

    public void clickRecommendedSets() {
        bottomHeader.getRecommendedSets();
    }

    public void clickDeliveryAndPayment() {
        bottomHeader.getDelAndPay();
    }

    public void clickReviews() {
        bottomHeader.getReviews();
    }

    public void clickLanguages() {
        bottomHeader.getLanguages();
    }
}

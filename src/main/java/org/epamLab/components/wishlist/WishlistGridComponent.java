package org.epamLab.components.wishlist;

import lombok.Getter;
import org.epamLab.components.BaseComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class WishlistGridComponent extends BaseComponent {

    @Getter
    protected List<WishlistItemComponent> wishlistItemComponents;

    @FindBy(xpath = "//tbody//tr")
    protected List<WebElement> wishlistRowNodes;

    public WishlistGridComponent(WebDriver driver, WebElement rootElement) {
        super(driver, rootElement);
        PageFactory.initElements(driver, this);
        wishlistItemComponents = new ArrayList<>();
        for(WebElement element: wishlistRowNodes){
            wishlistItemComponents.add(new WishlistItemComponent(driver, element));
        }
    }

    public WishlistItemComponent findProductByTitle(String name){
        for(WishlistItemComponent item: getWishlistItemComponents()){
            if(item.getProductName().equals(name))
                return item;
        }
        return null;
    }

}

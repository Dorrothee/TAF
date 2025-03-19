package org.epamLab.pages;

import lombok.Getter;
import org.epamLab.Base;
import org.epamLab.components.header.HeaderComponent;
import org.epamLab.modals.CartPopUpModal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class BasePage extends Base {

    protected HeaderComponent headerComponent;
    @Getter
    protected CartPopUpModal cartPopUpModal;

    public BasePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.headerComponent = new HeaderComponent(driver);
        this.cartPopUpModal = new CartPopUpModal(driver);
    }

}

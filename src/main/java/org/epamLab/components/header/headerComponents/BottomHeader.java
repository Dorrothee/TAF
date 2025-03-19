package org.epamLab.components.header.headerComponents;

import lombok.Getter;
import org.epamLab.components.BaseComponent;
import org.epamLab.components.CategoriesComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BottomHeader extends BaseComponent {

    @FindBy(css = "div.category-navigation button.cat-nav-trigger")
    protected WebElement categories;

    @FindBy(xpath = "//ul[@id='primary-menu']//li[@id='menu-item-97007']/a")
    protected WebElement springSale;

    @FindBy(xpath = "//ul[@id='primary-menu']//li[@id='menu-item-96536']/a")
    protected WebElement recommendedSets;

    @FindBy(xpath = "//ul[@id='primary-menu']//li[@id='menu-item-3200']/a")
    protected WebElement delAndPay;

    @FindBy(xpath = "//ul[@id='primary-menu']//li[@id='menu-item-6496']/a")
    protected WebElement reviews;

    @FindBy(xpath = "//ul[@id='primary-menu']//li[@id='menu-item-47283']/a")
    protected WebElement languages;

    @Getter
    protected CategoriesComponent categoriesComponent;

    public BottomHeader(WebDriver driver) {
        super(driver);
        this.categoriesComponent = new CategoriesComponent(driver);
        PageFactory.initElements(driver, this);
    }

    public CategoriesComponent getCategories() {
        clickElement(categories);
        return categoriesComponent;
    }

    public void getSpringSales() {
        clickElement(springSale);
    }

    public void getRecommendedSets() {
        clickElement(recommendedSets);
    }

    public void getDelAndPay() {
        clickElement(delAndPay);
    }

    public void getReviews() {
        clickElement(reviews);
    }

    public void getLanguages() {
        clickElement(languages);
    }
}

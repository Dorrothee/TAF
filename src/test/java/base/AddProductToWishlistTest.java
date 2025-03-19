package base;

import io.qameta.allure.Step;
import jdk.jfr.Description;
import org.epamLab.modals.ConfirmationWishlistModal;
import org.epamLab.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductToWishlistTest extends BaseTestRunner {

    @Test
    @Description("First scenario: Add product to wishlist")
    public void testAddProductToWishlist() {

        String category = "Снеки";
        String product = "Снеки з медом";

        //Step 1: Click categories and select "Снеки"
        HomePage homePage = new HomePage(driver);
        homePage.getHeader().openCategories().selectCategory(category);

        //Step 2: Verify that the "Снеки" category is selected
        CategoryPage categoryPage = new CategoryPage(driver);
        Assert.assertTrue(categoryPage.isCategorySelected(category), "Category is incorrect");

        //Step 3: Select "Снеки з медом" product
        categoryPage.openProduct(product);

        //Step 4: Verify the desired product page is open
        ProductPage productPage = new ProductPage(driver);
        Assert.assertEquals(productPage.getProductInfoComponent().getTitle().getText(), product);

        //Step 5: Add the product to wishlist
        productPage.getProductInfoComponent().addToWishlist();

        //Step 6: Verify that confirmation modal appears
        ConfirmationWishlistModal modal = new ConfirmationWishlistModal(driver);
        modal.waitForModalToAppear();
        Assert.assertTrue(modal.getConfirmationText().contains("додано до списку бажань"), "Modal not displayed");

        //Step 7: Click to go to wishlist page
        modal.clickGoToWishList();

        //Step 8: Verify that the product is in the wishlist
        WishlistPage wishlistPage = new WishlistPage(driver);
        Assert.assertEquals(wishlistPage.getWishlistedProductTitle(product), product);
    }
}

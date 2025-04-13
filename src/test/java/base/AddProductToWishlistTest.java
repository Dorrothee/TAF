package base;

import jdk.jfr.Description;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.epamLab.modals.ConfirmationWishlistModal;
import org.epamLab.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductToWishlistTest extends BaseTestRunner {

    private static final Logger logger = LogManager.getLogger(AddProductToWishlistTest.class);

    @Test
    @Description("First scenario: Add product to wishlist")
    public void testAddProductToWishlist() {

        logger.info("Starting test: Add product to wishlist");
        String category = "Снеки";
        String product = "Снеки з медом";

        //Step 1: Click categories and select "Снеки"
        logger.info(String.format("Navigating to category: %s", category));
        HomePage homePage = new HomePage(driver);
        homePage.getHeader().openCategories().selectCategory(category);
        logger.info(String.format("Category '%s' successfully selected", category));

        //Step 2: Verify that the "Снеки" category is selected
        logger.debug(String.format("Verifying if category '%s' is selected", category));
        CategoryPage categoryPage = new CategoryPage(driver);
        Assert.assertTrue(categoryPage.isCategorySelected(category), "Category is incorrect");
        logger.info(String.format("Category '%s' selection verified", category));

        //Step 3: Select "Снеки з медом" product
        logger.info(String.format("Opening product page for '%s'", product));
        categoryPage.openProduct(product);

        //Step 4: Verify the desired product page is open
        logger.debug(String.format("Verifying that product '%s' page is displayed", product));
        ProductPage productPage = new ProductPage(driver);
        Assert.assertEquals(productPage.getProductInfoComponent().getTitle().getText(), product);
        logger.info(String.format("Product '%s' page verified successfully", product));

        //Step 5: Add the product to wishlist
        logger.debug(String.format("Adding product '%s' to wishlist", product));
        productPage.getProductInfoComponent().addToWishlist();

        //Step 6: Verify that confirmation modal appears
        logger.info("Waiting for confirmation modal to appear");
        ConfirmationWishlistModal modal = new ConfirmationWishlistModal(driver);
        modal.waitForModalToAppear();
        Assert.assertTrue(modal.getConfirmationText().contains("додано до списку бажань"), "Modal not displayed");
        logger.info("Confirmation modal appeared successfully");

        //Step 7: Click to go to wishlist page
        logger.debug("Navigating to wishlist page");
        modal.clickGoToWishList();

        //Step 8: Verify that the product is in the wishlist
        logger.debug("Verifying product in the wishlist");
        WishlistPage wishlistPage = new WishlistPage(driver);
        Assert.assertEquals(wishlistPage.getWishlistedProductTitle(product), product);
        logger.info(String.format("Product '%s' found in wishlist", product));

        logger.info("Test completed: Add product to wishlist");
    }
}

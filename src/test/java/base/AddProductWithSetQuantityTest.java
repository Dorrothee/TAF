package base;


import jdk.jfr.Description;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.epamLab.pages.HomePage;
import org.epamLab.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductWithSetQuantityTest extends BaseTestRunner {

    private static final Logger logger = LogManager.getLogger(AddProductWithSetQuantityTest.class);

    @Test
    @Description("Second Scenario - Add product (with set quantity) to the cart")
    public void verifyAddedProductWithSetQuantity() {

        logger.info("Starting test: Adding product with a set quantity to the cart");

        String product = "Токпоккі з сиром, 240г";
        int quantity = 3;
        String price = "687";

        //Step 1-2: Enter title of the product to search for and click on it
        logger.info("Searching for product: " + product);
        HomePage homePage = new HomePage(driver);
        homePage.getHeader().searchProduct(product);
        logger.info("Clicked on the product '" + product + "' in the search results");

        //Step 3: Verify that the "Токпоккі з сиром, 240г" product is selected
        logger.info("Verifying that product '" + product + "' page is displayed");
        ProductPage productPage = new ProductPage(driver);
        Assert.assertTrue(productPage.isProductSelected(product), product);
        logger.info("Product '" + product + "' page loaded successfully");

        //Step 4: Set quantity of 3
        logger.info("Setting the quantity to " + quantity);
        productPage.getProductInfoComponent().getQuantityProductComponent().setQuantity(quantity);
        logger.info("Successfully set product's quantity to " + quantity);

        //Step 5: Add product to the cart
        logger.info("Adding product '" + product + "' to the cart");
        productPage.getProductInfoComponent().addToCart();
        logger.info("Product '" + product + "' added to the cart");

        //Step 6: Verify cart popup window is displayed with the desired product
        logger.info("Waiting for the cart popup modal to appear for product '" + product + "'");
        productPage.getCartPopUpModal().waitForModalToAppear();
        Assert.assertEquals(productPage.getCartPopUpModal().getCartPopUpProductItemComponent().getProductTitle(), product);
        logger.info("Product '" + product + "' displayed successfully in the cart popup modal");

        //Step 7: Verify the price of the product
        logger.info("Verifying product price in the cart popup modal");
        String cartPriceText = productPage.getCartPopUpModal()
                .getCartPopUpProductItemComponent()
                .getProductPrice().trim();
        Assert.assertEquals(cartPriceText, price);
        logger.info("Product price '" + cartPriceText + "' verified successfully in the cart popup modal");

        //Step 8: Close the cart popup modal
        logger.info("Closing the cart popup modal");
        productPage.getCartPopUpModal().closeCartPopUpModal();
        logger.info("Cart popup modal closed successfully");

        logger.info("Test completed successfully: Adding product with a set quantity to the cart");

    }
}

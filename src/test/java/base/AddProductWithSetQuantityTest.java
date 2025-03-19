package base;


import jdk.jfr.Description;
import org.epamLab.pages.HomePage;
import org.epamLab.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductWithSetQuantityTest extends BaseTestRunner {

    @Test
    @Description("Second Scenario - Add product (with set quantity) to the cart")
    public void verifyAddedProductWithSetQuantity() {

        String product = "Токпоккі з сиром, 240г";
        int quantity = 3;
        String price = "708";

        //Step 1-2: Enter title of the product to search for and click on it
        HomePage homePage = new HomePage(driver);
        homePage.getHeader().searchProduct(product);

        //Step 3: Verify that the "Токпоккі з сиром, 240г" product is selected
        ProductPage productPage = new ProductPage(driver);
        Assert.assertTrue(productPage.isProductSelected(product), product);

        //Step 4: Set quantity of 3
        productPage.getProductInfoComponent().getQuantityProductComponent().setQuantity(quantity);

        //Step 5: Add product to the cart
        productPage.getProductInfoComponent().addToCart();

        //Step 6: Verify cart popup window is displayed with the desired product
        productPage.getCartPopUpModal().waitForModalToAppear();
        Assert.assertEquals(productPage.getCartPopUpModal().getCartPopUpProductItemComponent().getProductTitle(), product);

        //Step 7: Verify the price of the product
        String cartPriceText = productPage.getCartPopUpModal()
                .getCartPopUpProductItemComponent()
                .getProductPrice().trim();
        Assert.assertEquals(cartPriceText, price);

        //Step 8: Close the cart popup modal
        productPage.getCartPopUpModal().closeCartPopUpModal();

    }
}

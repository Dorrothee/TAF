package base;

import jdk.jfr.Description;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.epamLab.pages.HomePage;
import org.epamLab.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTestRunner {

    private static final Logger logger = LogManager.getLogger(SignUpTest.class);

    @Test
    @Description("Third Scenario - User registration")
    public void signUp() {
        logger.info("Starting sign-up test");

        String login = "samguk";
        String email = "samguk@gmail.com";
        String password = "samgukPassword";

        //Step 1: Navigate to the Profile page
        logger.debug("Navigating to Profile page");
        HomePage homePage = new HomePage(driver);
        homePage.getHeader().toProfile();

        //Step 2: Verify that user is on the profile page
        logger.debug("Verifying Profile page");
        ProfilePage profilePage = new ProfilePage(driver);
        Assert.assertTrue(profilePage.isProfileSelected("Мой аккаунт"), "Profile page is incorrect");
        logger.info("User navigated to Profile page successfully");

        //Step 3-5: Enter credentials
        logger.debug("Filling out registration form");
        profilePage.getSignUpComponent()
                .getSignUpForm()
                .enterLogin(login)
                .enterEmail(email)
                .enterPassword(password);

        //Step 7-8: Verify credentials
        logger.debug("Verifying form fields");
        Assert.assertEquals(profilePage.getSignUpComponent().getSignUpForm().getLogin().getAttribute("value"), login);
        Assert.assertEquals(profilePage.getSignUpComponent().getSignUpForm().getEmail().getAttribute("value"), email);
        Assert.assertEquals(profilePage.getSignUpComponent().getSignUpForm().getPassword().getAttribute("value"), password);
        logger.info("Form fields verified successfully");

        //End of the test
        logger.info("SignUp test completed successfully");

    }
}

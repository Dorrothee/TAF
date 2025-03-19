package base;

import jdk.jfr.Description;
import org.epamLab.pages.HomePage;
import org.epamLab.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTestRunner {

    @Test
    @Description("Third Scenario - User registration")
    public void signUp() {

        String login = "samguk";
        String email = "samguk@gmail.com";
        String password = "samgukPassword";

        //Step 1: Navigate to the Profile page
        HomePage homePage = new HomePage(driver);
        homePage.getHeader().toProfile();

        //Step 2: Verify that user is on the profile page
        ProfilePage profilePage = new ProfilePage(driver);
        Assert.assertTrue(profilePage.isProfileSelected("Мой аккаунт"), "Profile page is incorrect");

        //Step 3-5: Enter credentials
        profilePage.getSignUpComponent()
                .getSignUpForm()
                .enterLogin(login)
                .enterEmail(email)
                .enterPassword(password);

        //Step 7-8: Verify credentials
        Assert.assertEquals(profilePage.getSignUpComponent().getSignUpForm().getLogin().getAttribute("value"), login);
        Assert.assertEquals(profilePage.getSignUpComponent().getSignUpForm().getEmail().getAttribute("value"), email);
        Assert.assertEquals(profilePage.getSignUpComponent().getSignUpForm().getPassword().getAttribute("value"), password);

    }
}

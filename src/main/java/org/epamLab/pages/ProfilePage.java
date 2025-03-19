package org.epamLab.pages;

import lombok.Getter;
import org.epamLab.components.profile.LogInComponent;
import org.epamLab.components.profile.SignUpComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage{

    @FindBy(css = ".breadcrumb-trail.breadcrumbs")
    protected WebElement profilePageCategory;

    @Getter
    protected LogInComponent logInComponent;
    @Getter
    protected SignUpComponent signUpComponent;

    public ProfilePage(WebDriver driver) {
        super(driver);
        this.logInComponent = new LogInComponent(driver);
        this.signUpComponent = new SignUpComponent(driver);
    }

    public boolean isProfileSelected(String profile) {
        return profilePageCategory.getText().trim().endsWith(profile);
    }

}

package org.epamLab.components.profile;

import lombok.Getter;
import org.epamLab.components.BaseComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpComponent extends BaseComponent {

    @FindBy(css = ".u-column2.col-2 h2")
    protected WebElement signUpTitle;

    @Getter
    protected SignUpForm signUpForm;

    public SignUpComponent(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.signUpForm = new SignUpForm(driver);
    }

}

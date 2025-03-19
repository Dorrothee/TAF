package org.epamLab.components.profile;

import lombok.Getter;
import org.epamLab.components.BaseComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpForm extends BaseComponent {

    @Getter
    @FindBy(css = "#reg_username")
    protected WebElement login;

    @Getter
    @FindBy(css = "#reg_email")
    protected WebElement email;

    @Getter
    @FindBy(css = "#reg_password")
    protected WebElement password;

    @Getter
    @FindBy(css = "div.woocommerce-privacy-policy-text")
    protected WebElement policyText;

    @Getter
    @FindBy(xpath = "//button[text()='Реєстрація']")
    protected WebElement registerButton;

    public SignUpForm(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public SignUpForm enterLogin(String loginData) {
        enterText(login, loginData);
        return this;
    }

    public SignUpForm enterEmail(String emailData) {
        enterText(email, emailData);
        return this;
    }

    public SignUpForm enterPassword(String passwordData) {
        enterText(password, passwordData);
        return this;
    }

    public void clickRegister() {
        clickElement(registerButton);
    }
}

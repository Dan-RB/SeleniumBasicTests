package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupLoginPage extends BasePage {
    private By loginTextHeader = By.xpath("//h2[text()='Login to your account']");
    private By emailLogField = By.xpath("//input[@data-qa='login-email']");
    private By passwordField = By.xpath("//input[@data-qa='login-password']");
    private By loginButton = By.xpath("//button[text()='Login']");
    private By invalidFieldText = By.xpath("//p [text()='Your email or password is incorrect!']");

    private By newSignupText = By.xpath("//h2 [text()='New User Signup!']");
    private By nameNewField = By.xpath("//input[@data-qa='signup-name']");
    private By emailNewField = By.xpath("//input[@data-qa='signup-email']");
    private By signupButton = By.xpath("//button[text()='Signup']");

    public SignupLoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginButton() {
        clickElem(loginButton);
    }

    public void writeEmailLogin(String text) {
        typeText(text, emailLogField);
    }

    public void writePasswordLogin(String text) {
        typeText(text, passwordField);
    }

    public void openPage() {
        openUrl("https://automationexercise.com/login");
    }

    public String getLoginTextHeader() {
        return getElemText(loginTextHeader);
    }

    public By getEmailLogField() {
        return emailLogField;
    }

    public By getPasswordField() {
        return passwordField;
    }

    public By getLoginButton() {
        return loginButton;
    }

    public String getInvalidFieldText() {
        return getElemText(invalidFieldText);
    }

    public String getNewSignupText() {
        return getElemText(newSignupText);
    }

    public By getNameNewField() {
        return nameNewField;
    }

    public By getEmailNewField() {
        return emailNewField;
    }

    public By getSignupButton() {
        return signupButton;
    }
}

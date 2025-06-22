package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewAccountPage extends BasePage{
    private By accInfoText = By.xpath("//b[text()='Enter Account Information']");
    private By firstNameField = By.id("first_name");
    private By lastNameField = By.id("last_name");
    private By passwordField = By.id("password");
    private By addressField = By.id("address1");
    private By stateField = By.id("state");
    private By cityField = By.id("city");
    private By zipcodeField = By.id("zipcode");
    private By phoneNumField = By.id("mobile_number");
    private By createAccButton = By.xpath("//button[@data-qa='create-account']");

    public NewAccountPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        openUrl("https://automationexercise.com/signup");
    }

    public String getAccInfoText() {
        return getElemText(accInfoText);
    }

    public By getFirstNameField() {
        return firstNameField;
    }

    public By getLastNameField() {
        return lastNameField;
    }

    public By getPasswordField() {
        return passwordField;
    }

    public By getAddressField() {
        return addressField;
    }

    public By getStateField() {
        return stateField;
    }

    public By getCityField() {
        return cityField;
    }

    public By getZipcodeField() {
        return zipcodeField;
    }

    public By getPhoneNumField() {
        return phoneNumField;
    }

    public By getCreateAccButton() {
        return createAccButton;
    }
}

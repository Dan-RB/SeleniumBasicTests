package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BasePage {
    private By payConfirmButton = By.id("submit");

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        openUrl("https://automationexercise.com/payment");
    }

    public By getPayConfirmButton() {
        return payConfirmButton;
    }
}

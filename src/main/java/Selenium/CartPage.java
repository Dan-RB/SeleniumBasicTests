package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    private By proceedButton = By.partialLinkText("Proceed To Checkout");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        openUrl("https://automationexercise.com/view_cart");
    }

    public By getProceedButton() {
        return proceedButton;
    }
}

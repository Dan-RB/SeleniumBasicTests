package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeLoggedPage extends BasePage{
    private By LogoutButton = By.partialLinkText("Logout");
    private By deleteAccButton = By.partialLinkText("Delete Account");
    private By cartButton = By.partialLinkText("Cart");

    public HomeLoggedPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        openUrl("https://automationexercise.com/");
    }

    public void clickLogoutButton() {
        clickElem(LogoutButton);
    }

    public void clickDeleteAccButton() {
        clickElem(deleteAccButton);
    }

    public By getLogoutButton() {
        return LogoutButton;
    }

    public By getDeleteAccButton() {
        return deleteAccButton;
    }

    public By getCartButton() {
        return cartButton;
    }
}

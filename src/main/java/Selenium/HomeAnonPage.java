package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeAnonPage extends BasePage{
    //@FindBy (partialLinkText = "Signup / Login") private WebElement signupLoginButton;
    //@FindBy (partialLinkText = "Products") private WebElement productsButton;
    private By signupLoginButton = By.partialLinkText("Signup / Login");
    private By productsButton = By.partialLinkText("Products");
    private By contactButton = By.partialLinkText("Contact us");
    private By testCasesButton = By.partialLinkText("Test Cases");
    private By cartButton = By.partialLinkText("Cart");

    public HomeAnonPage(WebDriver driver) {
        super(driver);
    }

    public void clickSignupLoginButton() {
        clickElem(signupLoginButton);
    }

    public void clickProductsButton() {
        clickElem(productsButton);
    }

    public void openPage() {
        openUrl("https://automationexercise.com/");
    }

    public By getSignupLoginButton() {
        return signupLoginButton;
    }

    public By getProductsButton() {
        return productsButton;
    }

    public By getContactButton() {
        return contactButton;
    }

    public By getTestCasesButton() {
        return testCasesButton;
    }

    public By getCartButton() {
        return cartButton;
    }
}

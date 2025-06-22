package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage{
    private By allProductsText = By.xpath("//h2 [text()='All Products']");
    private By womenButton = By.xpath("//a [contains(., 'Women')]");
    private By dressSubButton = By.xpath("//div [@id='Women']//a [contains(., 'Dress')]");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        openUrl("https://automationexercise.com/products");
    }

    public String getAllProductsText() {
        return getElemText(allProductsText);
    }

    public By getWomenButton() {
        return womenButton;
    }

    public By getDressSubButton() {
        return dressSubButton;
    }
}

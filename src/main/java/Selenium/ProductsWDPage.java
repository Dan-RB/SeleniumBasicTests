package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsWDPage extends BasePage {
    private By addkrtFrstProdOverlayButton = By.xpath("//div[@class='overlay-content']//a [text()='Add to cart' and @data-product-id='3']");
    private By firstProduct = By.xpath("//img [@src='/get_product_picture/3']");
    private By addedText = By.xpath("//p [text()='Your product has been added to cart.']");
    private By continueShoppingButton = By.xpath("//button [text()='Continue Shopping']");

    public ProductsWDPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        openUrl("https://automationexercise.com/category_products/1");
    }

    public By getAddkrtFrstProdOverlayButton() {
        return addkrtFrstProdOverlayButton;
    }

    public By getFirstProduct() {
        return firstProduct;
    }

    public String getAddedText() {
        return getElemText(addedText);
    }

    public By getContinueShoppingButton() {
        return continueShoppingButton;
    }
}

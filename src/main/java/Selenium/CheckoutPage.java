package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class CheckoutPage extends BasePage {
    private By reviewOrderText = By.xpath("//h2 [text()='Review Your Order']");
    private By extractTableItems = By.xpath("//tbody//tr [contains(@id, 'product')]//td");
    private By totalAmountText = By.xpath("//tbody//tr [(position() = last())]//p [@class='cart_total_price']");
    private By commentField = By.name("message");
    private By placeOrderButton = By.partialLinkText("Place Order");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        openUrl("https://automationexercise.com/checkout");
    }

    public void printTableElements() {
        for (WebElement element : findElems(extractTableItems)) {
            switch(element.getAttribute("class")) {
                case "cart_description":
                    Reporter.log("Item: " + element.getText(), true);
                    //System.out.println("Item: " + element.getText());
                    break;
                case "cart_price":
                    Reporter.log("Price: " + element.getText(), true);
                    //System.out.println("Price: " + element.getText());
                    break;
                case "cart_quantity":
                    Reporter.log("Quantity: " + element.getText(), true);
                    //System.out.println("Quantity: " + element.getText());
                    break;
                case "cart_total":
                    Reporter.log("Item total: " + element.getText(), true);
                    //System.out.println("Item total: " + element.getText());
                    break;
            }
        }
        System.out.println("=========");
        System.out.println("TOTAL: " + getElemText(totalAmountText));
    }

    public String getReviewOrderText() {
        return getElemText(reviewOrderText);
    }

    public By getExtractTableItems() {
        return extractTableItems;
    }

    public By getTotalAmountText() {
        return totalAmountText;
    }

    public By getCommentField() {
        return commentField;
    }

    public By getPlaceOrderButton() {
        return placeOrderButton;
    }
}

package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewAccountSuccessPage extends BasePage{
    private By accCreatedText = By.xpath("//b[text()='Account Created!']");
    private By continueButton = By.partialLinkText("Continue");

    public NewAccountSuccessPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        openUrl("https://automationexercise.com/signup");
    }

    public String getAccCreatedText() {
        return getElemText(accCreatedText);
    }

    public By getContinueButton() {
        return continueButton;
    }
}

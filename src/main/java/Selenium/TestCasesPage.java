package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import java.util.List;

public class TestCasesPage extends BasePage {
    private By introText = By.xpath("//span [contains(., 'Below is')]");
    private By testCasesLinks = By.xpath("//div [@class='panel-group']//a [contains(., 'Test Case')]");

    public TestCasesPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        openUrl("https://automationexercise.com/test_cases");
    }

    public void countTestCases(List<WebElement> list) {
        System.out.println("There are " + list.size() + " elements.");
        for (WebElement element : list) {
            Reporter.log(element.getText(), true);
            //System.out.println(element.getText());
        }
    }

    public String getIntroText() {
        return getElemText(introText);
    }

    public List<WebElement> getTestCasesLinks() {
        return findElems(testCasesLinks);
    }
}

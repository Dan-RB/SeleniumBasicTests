package Selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class BasePage {
    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        //driver = new EdgeDriver();
        this.driver = driver;
        this.actions = new Actions(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public void openUrl(String url) {
        driver.get(url);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getCurrentPageTitle() {
        return driver.getTitle();
    }

    public WebElement findElem(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> findElems(By locator) {
        return driver.findElements(locator);
    }

    public String getElemText(By locator) {
        return driver.findElement(locator).getText();
    }

    public void clickElem(By locator) {
        findElem(locator).click();
    }

    public void typeText(String text, By locator) {
        findElem(locator).sendKeys(text);
    }

    public void hoverOverElem(By locator) {
        actions.moveToElement(findElem(locator)).build().perform();
    }

    public void scrollToElement(By locator) {
        actions.scrollToElement(findElem(locator)).perform();
    }

    public void waitForVisibility(By locator) {
        wait.until(ExpectedConditions.visibilityOf(findElem(locator)));
    }

    public void uploadFile(By locator, String path) {
        File file = new File(path);
        findElem(locator).sendKeys(file.getAbsolutePath());
    }

    public String generateTimestamp() {
        Date date = new Date();
        return new SimpleDateFormat("MM-dd-yyyy_H-mm-ss-S").format(date);
    }

    public void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
        //driver.switchTo().defaultContent();
    }

    public void validateTitle(String actual, String expected) {
        Assert.assertEquals(actual, expected, "Page title doesn't match expected title.");
        Reporter.log("Title Matches");
    }

    public void validateText(String actual, String expected) {
        try {
            Assert.assertEquals(actual, expected, "Text doesn't match expected text.");
            Reporter.log("Text Matches", true);
        } catch (Exception e) {
            //System.out.println("Text element is not present!");
            Reporter.log("Text element is not Present!", true);
        }
    }

    public boolean validatePresence(By locator) {
        try {
            /*if (findElems(locator).size() < 1) {
                System.out.print(" is Displayed");
            }
            else {
                System.out.print(" is Not Displayed");
            }*/
            if (findElem(locator).isDisplayed()) {
                //System.out.println(getElemText(locator) + " is Present");
                Reporter.log(getElemText(locator) + " is Present", true);
            }
            return true;
        } catch (Exception e) {
            //System.out.println("Element is not present");
            Reporter.log("Element is not Present", true);
            return false;
        }
    }

    public boolean validateEnabled(By locator) {
        try {
        /*if (findElems(locator).size() < 1) {
            System.out.print(" is Displayed");
        }
        else {
            System.out.print(" is Not Displayed");
        }*/
            if (findElem(locator).isEnabled()) {
                //System.out.println(getElemText(locator) + " is Enabled");
                Reporter.log(getElemText(locator) + " is Enabled", true);
            }
            return true;
        } catch (Exception e) {
            //System.out.println("Element is not Enabled");
            Reporter.log("Element is not Enabled", true);
            return false;
        }
    }

    public String takeScreenshot() throws IOException {
        // Creating instance of File
        File shot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = generateTimestamp();
        File path = new File("src/test/screenshots/" + timestamp + ".png");
        FileUtils.copyFile(shot, path);

        // Add to report
        return " <a href='" + path.getAbsolutePath() + "'> <img src='" + path.getAbsolutePath() + "' height='70%' width='70%'/> </a>  ";
    }
}

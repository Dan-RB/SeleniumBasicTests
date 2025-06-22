package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactPage extends BasePage {
    private By contactUsText = By.xpath("//h2 [contains(., 'Contact Us')]");
    private By nameField = By.name("name");
    private By emailField = By.name("email");
    private By subjectField = By.name("subject");
    private By messageField = By.name("message");
    private By uploadButton = By.name("upload_file");
    private By submitButton = By.name("submit");
    private By successText = By.xpath("//div [@class='contact-form']//div [contains(text(), 'Success')]");

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        openUrl("https://automationexercise.com/contact_us");
    }

    public String getContactUsText() {
        return getElemText(contactUsText);
    }

    public By getNameField() {
        return nameField;
    }

    public By getEmailField() {
        return emailField;
    }

    public By getSubjectField() {
        return subjectField;
    }

    public By getMessageField() {
        return messageField;
    }

    public By getUploadButton() {
        return uploadButton;
    }

    public By getSubmitButton() {
        return submitButton;
    }

    public String getSuccessText() {
        return getElemText(successText);
    }
}

import Selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
// ENABLE Edit Configurations > Listeners > Use Default Reporters FOR REPORT

public class Tests {
    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp(ITestResult result) {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) throws IOException {
        Reporter.setCurrentTestResult(result);
        driver.quit();
    }
/*
    @AfterSuite(alwaysRun = true)
    public void saveReport(ITestResult result) throws IOException {
        Reporter.setCurrentTestResult(result);
    }
*/
    @Test(priority = 1)
    public void firstTest() throws IOException {
        Reporter.log("========== 1° Test ==========", true);
        // Open browser
        HomeAnonPage homeAnonPage = new HomeAnonPage(driver);

        // Launch the url - https://automationexercise.com/
        homeAnonPage.openPage();
        Reporter.log(homeAnonPage.takeScreenshot());

        // Validate title of the page as "Automation Exercise"
        homeAnonPage.validateTitle(homeAnonPage.getCurrentPageTitle(), "Automation Exercise");

        // Click on Signup/Login button
        homeAnonPage.clickSignupLoginButton();

        // Validate text "Login to your account" is present
        SignupLoginPage signupLoginPage = new SignupLoginPage(driver);
        signupLoginPage.validateText(signupLoginPage.getLoginTextHeader(), "Login to your account");

        // enter username
        signupLoginPage.typeText("trash@email.com", signupLoginPage.getEmailLogField());

        // Enter password
        signupLoginPage.typeText("password", signupLoginPage.getPasswordField());

        // click on Login button
        signupLoginPage.clickLoginButton();
        Reporter.log("Logging in...");

        // Validate Delete Account button is present
        HomeLoggedPage homeLoggedPage = new HomeLoggedPage(driver);
        homeLoggedPage.validatePresence(homeLoggedPage.getDeleteAccButton());
        Reporter.log(homeLoggedPage.takeScreenshot());

        // click on logout button
        homeLoggedPage.clickElem(homeLoggedPage.getLogoutButton());
        Reporter.log("Logging out...");

        // validate delete account button is nof present
        signupLoginPage.validatePresence(homeLoggedPage.getDeleteAccButton());
        Reporter.log(signupLoginPage.takeScreenshot());

        // close the browser
    }

    @Test(priority = 2)
    public void secondTest() throws IOException {
        // Open Chrome Browser
        HomeAnonPage homeAnonPage = new HomeAnonPage(driver);
        Reporter.log("========== 2° Test ==========", true);

        // Launch the url - https://automationexercise.com/
        homeAnonPage.openPage();
        Reporter.log(homeAnonPage.takeScreenshot());

        // Validate title of the page as "Automation Exercise"
        homeAnonPage.validateTitle(homeAnonPage.getCurrentPageTitle(), "Automation Exercise");

        // Click on Signup/Login button
        homeAnonPage.clickSignupLoginButton();

        // Validate text "Login to your account" is present
        SignupLoginPage signupLoginPage = new SignupLoginPage(driver);
        signupLoginPage.validateText(signupLoginPage.getLoginTextHeader(), "Login to your account");

        // enter invalid username
        signupLoginPage.typeText("invalid@mail.com", signupLoginPage.getEmailLogField());

        // enter invalid password
        signupLoginPage.typeText("invalid", signupLoginPage.getPasswordField());

        // click on Login button
        signupLoginPage.clickLoginButton();

        // Validate error message as "Your email or password is incorrect!"
        signupLoginPage.validateText(signupLoginPage.getInvalidFieldText(), "Your email or password is incorrect!");
        Reporter.log("Logging in failed.", true);
        Reporter.log(signupLoginPage.takeScreenshot());

        // close the browser
    }

    @Test(priority = 3)
    public void thirdTest() throws IOException {
        Reporter.log("========== 3° Test ==========", true);
        // Open Chrome Browser
        HomeAnonPage homeAnonPage = new HomeAnonPage(driver);

        // Launch the url - https://automationexercise.com/
        homeAnonPage.openPage();
        Reporter.log(homeAnonPage.takeScreenshot());

        // Validate title of the page as "Automation Exercise"
        homeAnonPage.validateTitle(homeAnonPage.getCurrentPageTitle(), "Automation Exercise");

        // Click on Signup/Login button
        homeAnonPage.clickSignupLoginButton();

        // Validate text "New User Signup!" is present
        SignupLoginPage signupLoginPage = new SignupLoginPage(driver);
        signupLoginPage.validateText(signupLoginPage.getNewSignupText(), "New User Signup!");

        // enter name
        signupLoginPage.typeText("Testo", signupLoginPage.getNameNewField());

        // enter email address
        signupLoginPage.typeText(signupLoginPage.generateTimestamp() + "@mail.com", signupLoginPage.getEmailNewField());
        Reporter.log("Attemping sign up...", true);
        Reporter.log(signupLoginPage.takeScreenshot());

        // click on Signup button
        signupLoginPage.clickElem(signupLoginPage.getSignupButton());

        // Validate text "Enter Account Information"
        NewAccountPage newAccountPage = new NewAccountPage(driver);
        newAccountPage.validateText(newAccountPage.getAccInfoText(), "ENTER ACCOUNT INFORMATION");
        Reporter.log("Success", true);

        // fill out all the mandatory details click on "Create Account" button
        newAccountPage.typeText("password", newAccountPage.getPasswordField());
        newAccountPage.typeText("Tony", newAccountPage.getFirstNameField());
        newAccountPage.typeText("Tiger", newAccountPage.getLastNameField());
        newAccountPage.typeText("Home", newAccountPage.getAddressField());
        newAccountPage.typeText("Anxiety", newAccountPage.getStateField());
        newAccountPage.typeText("Townsville", newAccountPage.getCityField());
        newAccountPage.typeText("12345", newAccountPage.getZipcodeField());
        newAccountPage.typeText("1234567890", newAccountPage.getPhoneNumField());
        Reporter.log("Filled fields", true);
        Reporter.log(newAccountPage.takeScreenshot());
        newAccountPage.clickElem(newAccountPage.getCreateAccButton());

        // Verify the text "Account Created!"
        NewAccountSuccessPage newAcSucPage = new NewAccountSuccessPage(driver);
        newAcSucPage.validateText(newAcSucPage.getAccCreatedText(), "ACCOUNT CREATED!");
        Reporter.log("Success", true);
        Reporter.log(newAcSucPage.takeScreenshot());

        // Click on continue button
        newAcSucPage.clickElem(newAcSucPage.getContinueButton());

        // Close the browser
    }

    @Test(priority = 4)
    public void fourthTest() throws IOException {
        Reporter.log("========== 4° Test ==========", true);
        // Open Chrome Browser
        HomeAnonPage homeAnonPage = new HomeAnonPage(driver);

        // Launch the url - https://automationexercise.com/
        homeAnonPage.openPage();
        Reporter.log(homeAnonPage.takeScreenshot());

        // Validate title of the page as "Automation Exercise"
        homeAnonPage.validateTitle(homeAnonPage.getCurrentPageTitle(), "Automation Exercise");

        // Click on "Products" button.
        homeAnonPage.clickProductsButton();

        // Validate text "All Products" is present
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.validateText(productsPage.getAllProductsText(), "ALL PRODUCTS");

        // Click on "Women" + button under category
        productsPage.clickElem(productsPage.getWomenButton());
        Reporter.log("Navigating to place...", true);

        // click on Dress
        productsPage.scrollToElement(productsPage.getDressSubButton());
        productsPage.clickElem(productsPage.getDressSubButton());

        // Click on "Add Cart" button of first product
        ProductsWDPage prodWDPage = new ProductsWDPage(driver);
        prodWDPage.hoverOverElem(prodWDPage.getFirstProduct());
        Reporter.log("Clicking on item...", true);
        Reporter.log(prodWDPage.takeScreenshot());
        prodWDPage.scrollToElement(prodWDPage.getAddkrtFrstProdOverlayButton());
        prodWDPage.clickElem(prodWDPage.getAddkrtFrstProdOverlayButton());

        // Validate text "Your product has been added to cart."
        prodWDPage.waitForVisibility(prodWDPage.getContinueShoppingButton());
        prodWDPage.validateText(prodWDPage.getAddedText(), "Your product has been added to cart.");

        // Click on "Continue Shopping"
        prodWDPage.clickElem(prodWDPage.getContinueShoppingButton());

        // close the browser
    }

    @Test(priority = 5)
    public void fifthTest() throws IOException {
        Reporter.log("========== 5° Test ==========", true);
        // Open Chrome Browser
        HomeAnonPage homeAnonPage = new HomeAnonPage(driver);

        // Launch the ugl- https://automationexercise.com/
        homeAnonPage.openPage();
        Reporter.log(homeAnonPage.takeScreenshot());

        // Validate title of the page as "Automation Exercise"
        homeAnonPage.validateTitle(homeAnonPage.getCurrentPageTitle(), "Automation Exercise");

        // Click on "Contact Us" button
        homeAnonPage.clickElem(homeAnonPage.getContactButton());

        // Validate text "Contact Us" is present
        ContactPage contactPage = new ContactPage(driver);
        contactPage.validateText(contactPage.getContactUsText(), "CONTACT US");

        // Enter name, email, subject, message
        contactPage.typeText("Nameson", contactPage.getNameField());
        contactPage.typeText("mailson@mail.com", contactPage.getEmailField());
        contactPage.typeText("Subjectson", contactPage.getSubjectField());
        contactPage.typeText("Sonson Son", contactPage.getMessageField());

        // Upload a file
        contactPage.uploadFile(contactPage.getUploadButton(), "src/test/resources/kid.PNG");
        Reporter.log("Fields and file uploaded", true);
        Reporter.log(contactPage.takeScreenshot());

        // Click on "Submit"
        contactPage.clickElem(contactPage.getSubmitButton());

        // Click "OK" if the alert appears
        contactPage.acceptAlert();
        Reporter.log("Alert accepted", true);

        // Validate the text "Success! Your details have been submitted successfully."
        contactPage.validateText(contactPage.getSuccessText(), "Success! Your details have been submitted successfully.");

        // close the browser
    }

    @Test(priority = 6)
    public void sixthTest() throws IOException {
        Reporter.log("========== 6° Test ==========", true);
        // Open Chrome Browser
        HomeAnonPage homeAnonPage = new HomeAnonPage(driver);

        // Launch the url - https://automationexercise.com/
        homeAnonPage.openPage();
        Reporter.log(homeAnonPage.takeScreenshot());

        // Validate title of the page as "Automation Exercise"
        homeAnonPage.validateTitle(homeAnonPage.getCurrentPageTitle(), "Automation Exercise");

        // Click on "Test Cases" button
        homeAnonPage.clickElem(homeAnonPage.getTestCasesButton());

        // Validate text "Below is the list of test Cases for you to practice the Automation.Click on the scenario for detailed Test Steps:" is present
        TestCasesPage testCasesPage = new TestCasesPage(driver);
        testCasesPage.validateText(testCasesPage.getIntroText(), "Below is the list of test Cases for you to practice the Automation. Click on the scenario for detailed Test Steps:");

        // Print the count of test cases and print the test cases descroptions
        testCasesPage.countTestCases(testCasesPage.getTestCasesLinks());
        Reporter.log(testCasesPage.takeScreenshot());

        // close the browser
    }

    @Test(priority = 7)
    public void seventhTest() throws IOException {
        Reporter.log("========== 7° Test ==========", true);
        // Open Chrome Browser
        HomeAnonPage homeAnonPage = new HomeAnonPage(driver);

        // Launch the url - https://automationexercise.com/
        homeAnonPage.openPage();
        Reporter.log(homeAnonPage.takeScreenshot());

        // Validate title of the page as "Automation Exercise"
        homeAnonPage.validateTitle(homeAnonPage.getCurrentPageTitle(), "Automation Exercise");

        // !! EXTRA STEPS: LOG IN
        homeAnonPage.clickSignupLoginButton();
        SignupLoginPage signupLoginPage = new SignupLoginPage(driver);
        Reporter.log("Logging in...", true);
        signupLoginPage.typeText("trash@email.com", signupLoginPage.getEmailLogField());
        signupLoginPage.typeText("password", signupLoginPage.getPasswordField());
        signupLoginPage.clickLoginButton();
        Reporter.log("Success", true);

        // Click on "Cart" button
        HomeLoggedPage homeLoggedPage = new HomeLoggedPage(driver);
        homeLoggedPage.clickElem(homeLoggedPage.getCartButton());

        // Validate "Proceed to checkout" button is present !! WE NEED ITEMS IN CART !!
        CartPage cartPage = new CartPage(driver);
        cartPage.validatePresence(cartPage.getProceedButton());
        Reporter.log(cartPage.takeScreenshot());

        // Click on "Proceed to checkout" button !! WE NEED TO BE LOGGED IN !!
        cartPage.clickElem(cartPage.getProceedButton());;

        // Verify the text "Review Your Order"
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.validateText(checkoutPage.getReviewOrderText(), "Review Your Order");
        Reporter.log(checkoutPage.takeScreenshot());

        // Print Description, Price, Quantity and total Amount
        checkoutPage.printTableElements();

        // Enter the comments
        checkoutPage.typeText("No comment.", checkoutPage.getCommentField());
        Reporter.log(checkoutPage.takeScreenshot());

        // Click on "Place Order"
        checkoutPage.clickElem(checkoutPage.getPlaceOrderButton());

        // Validate "Pay and Confirm Order" button is enabled
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.validateEnabled(paymentPage.getPayConfirmButton());
        Reporter.log(paymentPage.takeScreenshot());

        // close the browser
    }

}

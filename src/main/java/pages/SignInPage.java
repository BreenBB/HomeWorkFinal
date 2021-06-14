package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

    //removed due Captha

    @FindBy(xpath = "//input[@id='userid']")
    WebElement userIdField;

    @FindBy(xpath = "//button[@id='signin-continue-btn']")
    WebElement continueButton;

    @FindBy(xpath = "//input[@id='pass']")
    WebElement passwordField;

    @FindBy(xpath = "//button[@id='sgnBt']")
    WebElement signInButton;

    @FindBy(xpath = "//p[@id='signin-error-msg']")
    WebElement signInOopsMessage;

    public void enterLoginInLoginField(String login) {
        userIdField.sendKeys(login);
    }
    public void clickOnContinueButton() {
        continueButton.click();
    }

    public void enterPasswordInPasswordField(String password) {
        passwordField.sendKeys(password);
    }

    public void clickOnSignInButton() {
        signInButton.click();
    }


    public WebElement getLoginField() {
        return userIdField;
    }
    public WebElement getContinueButton() {
        return continueButton;
    }
    public WebElement getPasswordField() {
        return passwordField;
    }
    public WebElement getSignInButton() {
        return signInButton;
    }

    public WebElement getSignInOopsMessage() {
        return signInOopsMessage;
    }

    public SignInPage(WebDriver driver) {
        super(driver);
    }
}

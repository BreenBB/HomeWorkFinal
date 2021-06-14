package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//span[@class='gh-ug-guest']/a[contains(text(), 'Sign in')]")
    WebElement signInText;

    @FindBy(xpath = "//a[contains(text(), 'register')]")
    WebElement registerText;

    @FindBy(xpath = "//button[@id='gh-ug']//b[contains(text(),'Temp')]")
    WebElement loggedButton;

    @FindBy(xpath = "//a[contains(text(), 'Sign out')]")
    WebElement logOutButton;

    @FindBy(xpath = "//li[@class='hl-cat-nav__js-tab']//a[contains(text(), 'Electronics')]")
    WebElement electronicsTab;

    @FindBy(xpath = "//input[@type='text']")
    WebElement searchInput;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement searchButton;

    public void enterSearchButton(String input) {
        searchInput.clear();
        searchInput.sendKeys(input);
    }

    public void clickOnSearchButton() {
        searchButton.click();
    }

    public WebElement getSearchInput() {
        return searchInput;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public void clickOnSignInText() {
        signInText.click();
    }
    public boolean checkWhatSignInTextIsPresent() {
        return signInText.isDisplayed();
    }

    public void clickOnRegisterText() {
        registerText.click();
    }

    public void clickOnLoggedText() {
        loggedButton.click();
    }
    public WebElement getLoggedButton() {
        return loggedButton;
    }


    public void clickElectronicsTab() {
        electronicsTab.click();
    }
    public WebElement getElectronicsTab() {
        return electronicsTab;
    }


    public void clickOnLogOutText() {
        logOutButton.click();
    }
    public WebElement getLogOutButton() {
        return logOutButton;
    }
    //public void clickSignInPopupCloseButton() {
    //    ((JavascriptExecutor) driver).executeScript("arguments[0].click()", signInPopupCloseButton);
    //}

}